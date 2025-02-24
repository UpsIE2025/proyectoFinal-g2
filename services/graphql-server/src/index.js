const { ApolloServer, gql } = require('apollo-server');
const fetch = require('node-fetch');

const typeDefs = gql`
  type Cuenta {
    id: ID!
    nombre: String
    saldo: Float
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
    obtenerCuentas: async () => {
      const res = await fetch('http://micro-cuentas:3001/cuentas');
      return res.json();
    },
  },
  Mutation: {
    crearCuenta: async (_, { nombre, saldo }) => {
      const res = await fetch('http://micro-cuentas:3001/cuentas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nombre, saldo }),
      });
      return res.json();
    },
  },
};

const server = new ApolloServer({
  typeDefs,
  resolvers,
  context: ({ req }) => {
    // validar JWT con Auth0
    const token = req.headers.authorization || '';
    // Validar token...
    return { user: /* datos del token */ };
  },
});

server.listen({ port: 4000 }).then(({ url }) => {
  console.log(`GraphQL Gateway running at ${url}`);
});