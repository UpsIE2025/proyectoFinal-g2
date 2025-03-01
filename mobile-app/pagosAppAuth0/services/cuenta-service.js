import { ApolloClient, InMemoryCache, HttpLink, gql } from '@apollo/client';
import { setContext } from '@apollo/client/link/context';
import AsyncStorage from '@react-native-async-storage/async-storage';

// URL de tu servidor GraphQL
const httpLink = new HttpLink({
  uri: 'https://tu-servidor-graphql.com/graphql', // Reemplázalo con tu endpoint real
});

// Middleware para agregar el token en los headers
const authLink = setContext(async (_, { headers }) => {
  const token = await AsyncStorage.getItem('token'); // Obtener el token almacenado
  return {
    headers: {
      ...headers,
      Authorization: token ? `Bearer ${token}` : '',
    },
  };
});

// Configurar Apollo Client con autenticación
const client = new ApolloClient({
  link: authLink.concat(httpLink), // Encadena el authLink con httpLink
  cache: new InMemoryCache(),
});

export const LISTAR_CUENTAS = gql`
  query ListarCuentas($listarCuentasId: ID!) {
    listarCuentas(id: $listarCuentasId) {
      cuentas {
        estado
        fecha_creacion
        id
        saldo
        usuario_id
      }
    }
  }
`;

export const CREAR_CUENTAS = gql`
  mutation CrearCuenta($usuarioId: String, $saldoInicial: Float) {
    crearCuenta(usuario_id: $usuarioId, saldo_inicial: $saldoInicial) {
      estado
      fecha_creacion
      id
      saldo
      usuario_id
    }
  }
`;


// Función para obtener usuarios desde el servidor con autenticación
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
