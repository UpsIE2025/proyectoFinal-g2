const { ApolloServer, gql } = require('apollo-server-express');
const fetch = require('node-fetch');
const express = require('express');

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

  type EstadoDeCuenta {
    success: Boolean
    message: String
  }

  type Mutation {
    crearCuenta(usuario_id: String, saldo_inicial: Float): Cuenta
  }
  
  type Mutation {
    actualizarCuenta(id: ID!, saldo: Float, estado: String): Cuenta}

  type Query {
    estadoDeCuenta(id: ID!): EstadoDeCuenta
    obtenerCuenta(id: ID!): Cuenta
    listarCuentas(id: ID!): [Cuenta]
    obtenerConsumo(id: ID!): Consumo
    listarConsumos(id: ID!): [Consumo]
  }

  type Mutation {
    crearConsumo(cuenta_id: String, descripcion: String, monto: Float): Consumo
  }  
`;

const resolvers = {
  Query: {
    estadoDeCuenta: async (_, { cuenta }, context) => {
      // Llamada REST a micro-estado-cuenta
      const res = await fetch(`http://micro-estado-cuenta:26061/v1/estado-cuenta/:${cuenta}`, {
        // headers: {
        //   Authorization: context.authHeader,
        // }
      });
      return res.json();
    },
    obtenerCuenta: async(_, { id }, context) => {
      // Llamada gRPC a ms-cuentas
      const { obtenerCuenta } = require('./grpcClient');
      return await obtenerCuenta(id);
    },
    listarCuentas: async(_, { id }, context) => {
      const { listarCuentas } = require('./grpcClient');
      return await listarCuentas(id);
    },
    obtenerConsumo: async(_, { id }, context) => {
      const {obtenerConsumo} = require('./grpcClient');
      return await obtenerConsumo(id);
    },
    listarConsumos: async(_, { id }, context) => {
      const {listarConsumos} = require('./grpcClient');
      return await listarConsumos(id);
    }
  },

  Mutation: {
    crearCuenta: async (_, { usuario_id, saldo_inicial }) => {
      // Llamada gRPC a ms-cuentas
      const { crearCuenta } = require('./grpcClient');
      return await crearCuenta(usuario_id, saldo_inicial);
    },
    actualizarCuenta: async (_, { id, saldo, estado }) => {
      // Llamada gRPC a ms-cuentas
      const { actualizarCuenta } = require('./grpcClient');
      return await actualizarCuenta(id, saldo, estado);
    },
    crearConsumo: async (_,{ cuenta_id, descripcion, monto }) => {
      const { crearConsumo } = require('./grpcClient');
      return await crearConsumo(cuenta_id, descripcion, monto);
    }
  },
};

// async function validateToken(authHeader) {
//   // Llama al micro-auth para validar token.
//   // Se podria enviar el token y esperar respuesta ("OK" / usuario decodificado).
//   const response = await fetch('http:micro-auth:3000/validate', {
//     headers: { Authorization: authHeader }
//   });
//   if (!response.ok) {
//     throw new Error('Token inválido');
//   }
//   return response.json(); // Devuelve el usuario decodificado
// }

const server = new ApolloServer({
  typeDefs,
  resolvers
  // context: async ({ req }) => {
  //   // validar JWT con Auth0 ó micro-auth
  //   const authHeader = req.headers.authorization || '';
  //   // logica de validacion
  //   const user = await validateToken(authHeader);
  //   return { 
  //     user,
  //     authHeader
  //   };
  // }
});

server.start().then(() => {
  server.applyMiddleware({ app });

  // Escuchar en el puerto 4000
  app.listen(4000, ( ) => {
      console.log('GraphQL Gateway running at http://localhost:4000/graphql');
  });
});
