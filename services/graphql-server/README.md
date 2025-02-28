# Servidor GraphQL

## Descripción General
Este servidor GraphQL actúa como una capa de agregación que unifica diferentes microservicios, proporcionando una API GraphQL única para los clientes (App React Native). Implementa resolvers para operaciones relacionadas con cuentas y consumos, utilizando tanto comunicación gRPC como REST.

## Tecnologías Principales
- Apollo Server Express
- gRPC para comunicación con microservicios
- Node.js
- Express

## Estructura del Schema GraphQL

### Tipos
```graphql
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
```

### Queries Disponibles
```graphql
type Query {
  estadoDeCuenta(id: ID!): EstadoDeCuenta
  obtenerCuenta(id: ID!): Cuenta
  listarCuentas(id: ID!): Cuentas
  obtenerConsumo(id: ID!): Consumo
  listarConsumos(id: ID!): Consumos
}
```

### Mutations Disponibles
```graphql
type Mutation {
  crearCuenta(usuario_id: String, saldo_inicial: Float): Cuenta
  actualizarCuenta(id: ID!, saldo: Float, estado: String): Cuenta
  crearConsumo(cuenta_id: String, descripcion: String, monto: Float): Consumo
}
```

## Integración con Microservicios

### Comunicación gRPC
- **Servicio**: ms-cuentas
- **Puerto**: 9090
- **Operaciones**:
  - CrearCuenta
  - ActualizarCuenta
  - ObtenerCuenta
  - ListarCuentas
  - CrearConsumo
  - ObtenerConsumo
  - ListarConsumos

### Comunicación REST
- **Servicio**: micro-estado-cuenta
- **Puerto**: 26061
- **Endpoint**: `/v1/estado-cuenta/{id}`

### Autenticación
- **Servicio**: micro-auth
- **Puerto**: 3000
- **Endpoint**: `/validate`
- **Configuración**: 
  - Domain: dev-88x6n0ntfccbwhfp.us.auth0.com
  - Audience: https://dev-88x6n0ntfccbwhfp.us.auth0.com/api/v2/

## Configuración del Contenedor

```yaml
graphql-server:
  build: ./services/graphql-server
  container_name: graphql-server
  hostname: graphql-server
  ports:
    - "4000:4000"
  environment:
    - MICRO_AUTH_URL=http://micro-auth:3000
  networks:
    - integration-net
  depends_on:
    - ms-cuentas
```

## Variables de Entorno
- `MICRO_AUTH_URL`: URL del servicio de autenticación (default: 'http://micro-auth:3000')

## Seguridad
El servidor implementa validación de tokens JWT a través del servicio micro-auth. La función `validateToken` verifica la autenticidad de los tokens recibidos.

```javascript
async function validateToken(authHeader) {
  if (!authHeader) throw new Error("No token provided");
  const response = await fetch(`${MICRO_AUTH_URL}/validate`, {
    method: 'POST',
    headers: { 
      'Content-Type': 'application/json', 
      'Authorization': authHeader 
    }
  });
  if (!response.ok) throw new Error('Invalid token');
  return await response.json();
}
```

## Comunicación gRPC
El cliente gRPC se configura para comunicarse con el microservicio de cuentas:

```javascript
const client = new cuentasProto(
  'ms-cuentas:9090',
  grpc.credentials.createInsecure()
);
```

## Ejecución Local
1. Asegúrate de que todos los servicios dependientes estén en ejecución
2. Construye y ejecuta el contenedor:
```bash
docker-compose up graphql-server
```
3. El servidor estará disponible en: http://localhost:4000/graphql

## Dependencias de Servicios
- ms-cuentas (gRPC)
- micro-auth (REST)
- micro-estado-cuenta (REST)

## Consideraciones de Desarrollo
1. La autenticación está actualmente comentada en los resolvers para desarrollo
2. Se recomienda habilitar la autenticación en producción
3. Las llamadas gRPC utilizan conexiones no seguras (insecure) - considerar implementar TLS en producción

## Monitoreo y Logs
- Los logs del servidor Apollo están disponibles a través de Docker:
```bash
docker logs graphql-server
```

## Endpoints Principales
- **GraphQL Playground**: http://localhost:4000/graphql
- **Endpoint GraphQL**: http://localhost:4000/graphql

## Próximas Mejoras Sugeridas
1. Implementar caché para queries frecuentes
2. Añadir rate limiting
3. Habilitar monitoreo de performance
4. Implementar tracing distribuido
5. Añadir pruebas automatizadas
6. Habilitar la autenticación en todos los resolvers

