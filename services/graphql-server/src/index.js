const { ApolloServer, gql } = require("apollo-server-express");
const fetch = require("node-fetch");
const express = require("express");
require("dotenv").config();

const MICRO_AUTH_URL = process.env.MICRO_AUTH_URL || "http://micro-auth:3000";

const app = express();

const typeDefs = gql`
  type Cuenta {
    id: ID!
    usuario_id: String
    saldo: Float
    estado: String
    fecha_creacion: String
  }

  type Consumo {
    id: ID!
    cuenta_id: String
    descripcion: String
    monto: Float
    estado: String
    fecha_consumo: String
  }

  type Cuentas {
    cuentas: [Cuenta]
  }

  type Consumos {
    consumos: [Consumo]
  }

  type EstadoDeCuenta {
    success: Boolean
    message: String
  }

  type Mutation {
    crearCuenta(usuario_id: String, saldo_inicial: Float): Cuenta
  }

  type Mutation {
    actualizarCuenta(id: ID!, saldo: Float, estado: String): Cuenta
  }

  type Query {
    estadoDeCuenta(id: ID!): EstadoDeCuenta
    obtenerCuenta(id: ID!): Cuenta
    listarCuentas(id: ID!): Cuentas
    obtenerConsumo(id: ID!): Consumo
    listarConsumos(id: ID!): Consumos
  }

  type Mutation {
    crearConsumo(cuenta_id: String, descripcion: String, monto: Float): Consumo
  }
`;

const resolvers = {
  Query: {
    estadoDeCuenta: async (_, { id }, context) => {
      // Llamada REST a micro-estado-cuenta
      if (!context.user) throw new Error("Unauthorized");
      const res = await fetch(
        `http://micro-estado-cuenta:26061/v1/estado-cuenta/${id}`,
        {
          headers: { Authorization: context.authHeader },
        }
      );
      return res.json();
    },
    obtenerCuenta: async (_, { id }, context) => {
      // Llamada gRPC a ms-cuentas
      if (!context.user) throw new Error("Unauthorized");
      const { obtenerCuenta } = require("./grpcClient");
      return await obtenerCuenta(id);
    },
    listarCuentas: async (_, { id }, context) => {
      if (!context.user) throw new Error("Unauthorized");
      const { listarCuentas } = require("./grpcClient");
      return await listarCuentas(id);
    },
    obtenerConsumo: async (_, { id }, context) => {
      if (!context.user) throw new Error("Unauthorized");
      const { obtenerConsumo } = require("./grpcClient");
      return await obtenerConsumo(id);
    },
    listarConsumos: async (_, { id }, context) => {
      if (!context.user) throw new Error("Unauthorized");
      const { listarConsumos } = require("./grpcClient");
      return await listarConsumos(id);
    },
  },

  Mutation: {
    crearCuenta: async (_, { usuario_id, saldo_inicial }, context) => {
      // Llamada gRPC a ms-cuentas
      if (!context.user) throw new Error("Unauthorized");
      const { crearCuenta } = require("./grpcClient");
      return await crearCuenta(usuario_id, saldo_inicial);
    },
    actualizarCuenta: async (_, { id, saldo, estado }, context) => {
      if (!context.user) throw new Error("Unauthorized");
      const { actualizarCuenta } = require("./grpcClient");
      return await actualizarCuenta(id, saldo, estado);
    },
    crearConsumo: async (_, { cuenta_id, descripcion, monto }, context) => {
      if (!context.user) throw new Error("Unauthorized");
      const { crearConsumo } = require("./grpcClient");
      return await crearConsumo(cuenta_id, descripcion, monto);
    },
  },
};

// Function to validate token using micro-auth
async function validateToken(authHeader) {
  if (!authHeader) throw new Error("No token provided");
  const response = await fetch(`${MICRO_AUTH_URL}/validate`, {
    method: "POST",
    headers: { "Content-Type": "application/json", Authorization: authHeader },
  });
  if (!response.ok) {
    throw new Error("Invalid token");
  }
  const data = await response.json();
  return data.user; // Extract user data
}

const server = new ApolloServer({
  typeDefs,
  resolvers,
  context: async ({ req }) => {
    const authHeader = req.headers.authorization || "";
    let user = null;
    try {
      user = await validateToken(authHeader);
    } catch (err) {
      console.error("JWT Validation Failed:", err);
    }
    return { user, authHeader };
  },
});

server.start().then(() => {
  server.applyMiddleware({ app });
  // Escuchar en el puerto 4000
  app.listen(4000, () => {
    console.log("GraphQL Gateway running at http://localhost:4000/graphql");
  });
});
