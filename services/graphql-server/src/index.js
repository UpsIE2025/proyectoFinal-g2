const { ApolloServer, gql } = require('apollo-server-express');
const fetch = require('node-fetch');
const express = require('express');

const app = express();

const typeDefs = gql`
  type EstadoDeCuenta {
    id: ID!
    balance: Float
    ultimoMovimiento: String
  }

  type Cuenta {
    id: ID!
    usuario_id: String
    saldo: Float
    estado: String
    fecha_creacion: String
  }

  type Query {
    estadoDeCuenta(id: ID!): EstadoDeCuenta
    cuenta(id: ID!): Cuenta
  }

  type Query {
    obtenerCuenta: Cuenta
  }

  type Mutation {
    crearCuenta(usuario_id: String, saldo_inicial: Float): Cuenta
  }
`;

const resolvers = {
  Query: {
    estadoDeCuenta: async (_, { id }, context) => {
      // Llamada REST a micro-estado-cuenta
      const res = await fetch(`http://micro-estado-cuenta:26061/v1/estado-cuenta/:${id}`, {
        headers: {
          Authorization: context.authHeader,
        }
      });
      return res.json();
    },
    cuenta: async(_, { id }, context) => {
      // Llamada gRPC a ms-cuentas
      const { obtenerCuenta } = require('./grpcClient');
      return await obtenerCuenta(id);
    }
  },

  Mutation: {
    crearCuenta: async (_, { usuario_id, saldo_inicial }) => {
      // Llamada gRPC a ms-cuentas
      const { crearCuenta } = require('./grpcClient');
      return await crearCuenta(usuario_id, saldo_inicial);
    },
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
