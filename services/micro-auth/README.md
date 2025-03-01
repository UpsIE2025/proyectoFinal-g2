# Microservicio de Autenticación (micro-auth)

## Descripción General
Este microservicio actúa como un intermediario de autenticación entre Auth0 y el servidor GraphQL, validando tokens JWT y proporcionando información del usuario autenticado. Está diseñado para funcionar como una capa de seguridad centralizada en la arquitectura del sistema.

## Tecnologías Principales
- Node.js
- Express
- jsonwebtoken
- jwks-rsa
- Auth0

## Configuración de Auth0

### Variables de Entorno Requeridas
```env
AUTH0_DOMAIN=dev-88x6n0ntfccbwhfp.us.auth0.com
AUTH0_AUDIENCE=https://dev-88x6n0ntfccbwhfp.us.auth0.com/api/v2/
PORT=3000
```

### Integración con Auth0
El servicio utiliza el endpoint JWKS (JSON Web Key Set) de Auth0 para obtener las claves de firma:
```javascript
jwksUri: `https://${AUTH0_DOMAIN}/.well-known/jwks.json`
```

## API Endpoints

### Validación de Token
- **Endpoint**: `/validate`
- **Método**: POST
- **Headers Requeridos**: 
  - `Authorization: Bearer <token>`
- **Respuesta Exitosa**:
  ```json
  {
    "valid": true,
    "user": {
      // Información decodificada del usuario
    }
  }
  ```
- **Respuesta de Error**:
  ```json
  {
    "error": "Invalid Token",
    "details": "mensaje de error específico"
  }
  ```

## Configuración del Contenedor

```yaml
micro-auth:
  build: ./services/micro-auth
  container_name: micro-auth
  ports:
    - "3000:3000"
  environment:
    - AUTH0_DOMAIN=dev-88x6n0ntfccbwhfp.us.auth0.com
    - AUTH0_AUDIENCE=https://dev-88x6n0ntfccbwhfp.us.auth0.com/api/v2/
    - PORT=3000
  networks:
    - integration-net
```

## Proceso de Validación de Token

1. **Recepción del Token**:
   - El token JWT se recibe en el header `Authorization`
   - Se elimina el prefijo "Bearer " del token

2. **Verificación de Firma**:
   - Se obtiene la clave pública de Auth0 usando JWKS
   - Se verifica la firma del token usando la clave correspondiente

3. **Validación de Claims**:
   - Se verifica el audience (`aud`)
   - Se verifica el issuer (`iss`)
   - Se decodifica la información del usuario

## Seguridad

### Características de Seguridad Implementadas
- Validación de tokens JWT
- Verificación de firma usando JWKS
- Validación de audience y issuer
- Manejo seguro de errores

### Mejores Prácticas
- No almacenamiento de secretos en código
- Uso de variables de entorno para configuración sensible
- Validación de headers de autorización

## Ejecución Local

### Usando Docker (Recomendado)
```bash
# Construir y ejecutar el contenedor
docker-compose up micro-auth

# O en modo detached (background)
docker-compose up -d micro-auth
```

El servicio estará disponible en `http://localhost:3000`

### Alternativa: Ejecución sin Docker
Si necesitas ejecutar el servicio directamente en tu máquina (sin Docker):

1. Instalar dependencias:
```bash
cd services/micro-auth
npm install
```

2. Crear archivo `.env` con las mismas variables definidas en docker-compose.yml:
```env
AUTH0_DOMAIN=dev-88x6n0ntfccbwhfp.us.auth0.com
AUTH0_AUDIENCE=https://dev-88x6n0ntfccbwhfp.us.auth0.com/api/v2/
PORT=3000
```

3. Iniciar el servicio:
```bash
npm start
```

**Nota**: Se recomienda usar la ejecución con Docker para mantener la consistencia con el entorno de producción y evitar problemas de configuración.

## Integración con Otros Servicios

### GraphQL Server
- El servidor GraphQL envía tokens JWT para validación
- Recibe información del usuario para autorización de operaciones

### Auth0
- Proporciona tokens JWT
- Mantiene las claves de firma (JWKS)
- Gestiona la autenticación de usuarios

## Monitoreo y Logs

### Logs Disponibles
- Errores de validación de token
- Inicio del servicio
- Acceso a endpoints

### Visualización de Logs
```bash
docker logs micro-auth
```

## Manejo de Errores
- **401**: Token no proporcionado
- **401**: Token inválido
- **500**: Error interno del servidor

## Consideraciones de Desarrollo

### Pruebas
Se recomienda implementar:
- Pruebas unitarias para validación de token
- Pruebas de integración con Auth0
- Pruebas de carga para validación de tokens

### Mejoras Futuras Sugeridas
1. Implementar caché de claves JWKS
2. Añadir rate limiting
3. Implementar métricas de monitoreo
4. Añadir logging estructurado
5. Implementar circuit breaker para llamadas a Auth0
6. Añadir health checks
7. Implementar tracing distribuido

## Dependencias Principales
```json
{
  "express": "^4.x",
  "jsonwebtoken": "^8.x",
  "jwks-rsa": "^2.x",
  "dotenv": "^8.x"
}
```

## Soporte y Mantenimiento
- Mantener actualizadas las dependencias
- Monitorear los logs de errores
- Verificar regularmente la configuración de Auth0
- Actualizar las claves JWKS según sea necesario