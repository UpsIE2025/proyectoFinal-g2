const { ApolloServer, gql } = require('apollo-server');
const fetch = require('node-fetch');

const typeDefs = gql`
  type EstadoDeCuenta {
    id: ID!
    balamce: Float
    ultimoMovimiento: String
  }

  type Cuenta {
    id: ID!
    titular: String
    numero: String
  }

  type Query {
    estadoDeCuenta(id: ID!): EstadoDeCuenta
    cuenta(id: ID!): Cuenta
  }

  type Query {
    obtenerCuentas: [Cuenta]
  }

  type Mutation {
    crearCuenta(nombre: String, saldo: Float): Cuenta
  }
`;

const resolvers = {
  Query: {
    estadoDeCuenta: async (_, { id }, context) => {
      // Llamada REST a micro-estado-cuenta
      const res = await fetch(`http://micro-estado-cuenta:26061/v1/estado-cuenta/:${id}`, {
        headers: {
          Authorization: context.authHeader, // o el token en si
        }
      });
      return res.json();
    },
    cuenta: async(_, { id }, context) => {
      // Llamada gRPC a ms-cuentas
      const { getCuenta } = require('./grpcClient');
      return getCuenta(id);
    }
  },

  Mutation: {
    crearCuenta: async (_, { nombre, saldo }) => {
      // Llamada gRPC a ms-cuentas
      const { crearCuenta } = require('./grpcClient');
      return crearCuenta(nombre, saldo);  
    },
  },
};

async function validateToken(authHeader) {
  // Llama al micro-auth para validar token.
  // Se podria enviar el token y esperar respuesta ("OK" / usuario decodificado).
  const response = await fetch('http:micro-auth:3000/validate', {
    headers: { Authorization: authHeader }
  });
  if (!response.ok) {
    throw new Error('Token inválido');
  }
  return response.json(); // Devuelve el usuario decodificado
}

const server = new ApolloServer({
  typeDefs,
  resolvers,
  context: async ({ req }) => {
    // validar JWT con Auth0 ó micro-auth
    const authHeader = req.headers.authorization || '';
    // logica de validacion
    const user = await validateToken(authHeader);
    return { 
      user,
      authHeader
    };
  }
});

server.listen({ port: 4000 }).then(({ url }) => {
  console.log(`GraphQL Gateway running at ${url}`);
});