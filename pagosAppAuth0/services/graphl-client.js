import { ApolloClient, InMemoryCache, HttpLink, gql } from '@apollo/client';
import { setContext } from '@apollo/client/link/context';
import AsyncStorage from '@react-native-async-storage/async-storage';

const httpLink = new HttpLink({
  uri: 'http://192.168.18.15:8000/graphql', 

});

const authLink = setContext(async (_, { headers }) => {
  const token = await AsyncStorage.getItem('token');
  return {
    headers: {
      ...headers,
      Authorization: token ? `Bearer ${token}` : '',
    },
  };
});

const client = new ApolloClient({
  link: authLink.concat(httpLink),
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

export const LISTAR_CONSUMOS = gql`
  query ListarConsumos($listarConsumosId: ID!) {
    listarConsumos(id: $listarConsumosId) {
      consumos {
        id
        cuenta_id
        descripcion
        monto
        estado
        fecha_consumo
      }
    }
  }
`;

export const CREAR_CUENTA = gql`
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

export const CREAR_CONSUMO = gql`
  mutation Mutation($cuentaId: String, $descripcion: String, $monto: Float) {
    crearConsumo(cuenta_id: $cuentaId, descripcion: $descripcion, monto: $monto) {
      id
      cuenta_id
      descripcion
      monto
      estado
      fecha_consumo
    }
  }
`;

export const crearCuenta = async (usuarioId, saldoInicial) => {
    const url = "http://192.168.18.15:8000/graphql";
  
    // Get the token from AsyncStorage (or use a hardcoded token if needed)
    let token;
    try {
      token = await AsyncStorage.getItem('token');
    } catch (error) {
      console.error("Error retrieving token:", error);
      // Fallback to the hardcoded token if AsyncStorage fails
    }

    // Create the GraphQL query with the parameters received
    const query = {
      query: `mutation {
        crearCuenta(usuario_id: "${usuarioId}", saldo_inicial: ${saldoInicial}) {
          id
          usuario_id
          saldo
          estado
          fecha_creacion
        }
      }`
    };

    try {
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Bearer ${token}`
        },
        body: JSON.stringify(query)
      });

      const result = await response.json();
      console.log("Cuenta creada:", result);
      return result.data?.crearCuenta;
    } catch (error) {
      console.error("Error al crear cuenta:", error);
      return null;
    }
};

// Alternative implementation using Apollo Client
export const crearCuentaApollo = async (usuarioId, saldoInicial) => {
  try {
    const { data } = await client.mutate({
      mutation: CREAR_CUENTA,
      variables: { 
        usuarioId, 
        saldoInicial 
      },
    });
    return data.crearCuenta;
  } catch (error) {
    console.error('Error al crear la cuenta:', error);
    return null;
  }
};

  export const listarCuentas = async (usuarioId) => {
    const url = "http://192.168.18.15:8000/graphql";
    console.log("usuario", usuarioId)
    // Get the token from AsyncStorage or use the hardcoded token
    let token;
    try {
      token = await AsyncStorage.getItem('token');
    } catch (error) {
      console.error("Error retrieving token:", error);
    }
  
    // Create the GraphQL query
    const requestBody = {
      query: `{ 
        listarCuentas(usuario_id: "${usuarioId}") { 
          cuentas { 
            id
            usuario_id
            saldo
            estado
            fecha_creacion
          } 
        } 
      }`
    };
  
    try {
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Bearer ${token}`
        },
        body: JSON.stringify(requestBody)
      });
  
      const result = await response.json();
      console.log("Cuentas listadas:", result);
      
      // Return the cuentas array from the response
      return result.data?.listarCuentas?.cuentas || [];
    } catch (error) {
      console.error("Error al listar cuentas:", error);
      return [];
    }
  };
  
  // Alternative implementation using Apollo Client
  export const listarCuentasApollo = async (usuarioId) => {
    try {
      const { data } = await client.query({
        query: LISTAR_CUENTAS,
        variables: { listarCuentasId: usuarioId },
        fetchPolicy: 'network-only' // This ensures fresh data is fetched
      });
      return data.listarCuentas.cuentas;
    } catch (error) {
      console.error('Error al listar cuentas:', error);
      return [];
    }
  };

export const crearConsumo = async (cuentaId, descripcion, monto) => {
  try {
    const { data } = await client.mutate({
      mutation: CREAR_CONSUMO,
      variables: { cuentaId, descripcion, monto },
    });
    return data.crearConsumo;
  } catch (error) {
    console.error('Error al crear el consumo:', error);
    return null;
  }
};

export const listarConsumos = async (listarConsumosId) => {
  try {
    const { data } = await client.query({
      query: LISTAR_CONSUMOS,
      variables: { listarConsumosId },
    });
    return data.listarConsumos.consumos;
  } catch (error) {
    console.error('Error al listar consumos:', error);
    return [];
  }
};

export default client;
