import { ApolloClient, InMemoryCache, HttpLink, gql } from '@apollo/client';

// Configurar el enlace HTTP con la URL de tu servidor GraphQL
const client = new ApolloClient({
  link: new HttpLink({
    uri: 'http://localhost:8000/graphql', // Reemplaza con tu URL
  }),
  cache: new InMemoryCache(),
});

// Ejemplo de una consulta GraphQL
export const GET_USUARIOS = gql`
  query {
    usuarios {
      id
      nombre
      email
    }
  }
`;

// Función para obtener usuarios desde el servidor
export const fetchUsuarios = async () => {
  try {
    const { data } = await client.query({
      query: GET_USUARIOS,
    });
    return data.usuarios;
  } catch (error) {
    console.error('Error obteniendo usuarios:', error);
    return [];
  }
};

export default client;
