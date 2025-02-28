# Configuración del Kong API Gateway

## Descripción General
Este Kong API Gateway sirve como punto de entrada para nuestra arquitectura de microservicios. El gateway está configurado para manejar peticiones GraphQL e implementa políticas esenciales de seguridad y compartición de recursos entre orígenes (CORS).

## Detalles de Configuración

### Información Básica
- **Versión del Gateway**: Kong 3.2
- **Modo**: Sin base de datos (DB-less)
- **Archivo de Configuración**: `kong/kong.yml`

### Configuración de Red
- **Puerto API Público**: 8000 (HTTP)
- **Puerto API Admin**: 8001 (restringido solo para configuración)
- **Nombre del Contenedor**: kong
- **Red**: integration-net (red bridge)

### Configuración de Servicios

#### Servicio GraphQL
- **Nombre**: graphql-service
- **URL Destino**: http://graphql-server:4000
- **Configuración de Ruta**:
  - Ruta: `/graphql`
  - Métodos: POST, GET
  - Protocolos: HTTP, HTTPS
  - Eliminación de Ruta: Desactivado

### Plugins

#### Plugin CORS
- **Habilitado**: Sí
- **Configuración**:
  - Orígenes Permitidos: * (todos los orígenes)
  - Métodos Permitidos: POST, GET
  - Cabeceras Permitidas: Content-Type

## Variables de Entorno

```yaml
KONG_DECLARATIVE_CONFIG: /usr/local/kong/declarative/kong.yml
KONG_DATABASE: "off"  # Modo sin base de datos
KONG_PROXY_ACCESS_LOG: /dev/stdout
KONG_ADMIN_ACCESS_LOG: /dev/stdout
KONG_PROXY_ERROR_LOG: /dev/stderr
KONG_ADMIN_ERROR_LOG: /dev/stderr
```

## Integración con Otros Servicios

El Kong API Gateway está integrado con:

1. **Servidor GraphQL**:
   - Contenedor: graphql-server
   - Puerto: 4000
   - Función: Maneja consultas y mutaciones GraphQL

2. **Servicio de Autenticación**:
   - Contenedor: micro-auth
   - Puerto: 3000
   - Función: Maneja la integración con Auth0 a traves del Servidor GraphQL
   - Dominio: dev-88x6n0ntfccbwhfp.us.auth0.com

## Arquitectura de Red

### Petición Cliente → Kong API Gateway (8000) → Servidor GraphQL (4000) → Autenticación y Microservicios


## Consideraciones de Seguridad

1. **Configuración CORS**:
   - Actualmente configurado para aceptar peticiones de todos los orígenes
   - Cabeceras restringidas solo a Content-Type
   - Métodos restringidos a POST y GET

2. **Autenticación**:
   - La autenticación se maneja a través del servicio micro-auth
   - Integración con Auth0 configurada para autenticación segura

## Despliegue

El Kong API Gateway se despliega como parte del stack de Docker Compose y se configura automáticamente usando el archivo de configuración declarativa (`kong.yml`).

### Prerrequisitos
- Docker y Docker Compose instalados
- Red `integration-net` creada

### Iniciar el Gateway
```bash
docker-compose up -d kong
```

## Monitoreo y Registro

- Los logs de acceso se dirigen a stdout
- Los logs de error se dirigen a stderr
- Los logs pueden verse usando:
  ```bash
  docker logs kong
  ```

## Consideraciones Futuras

1. **Mejoras de Seguridad**:
   - Considerar restringir CORS a orígenes específicos
   - Implementar límites de tasa
   - Agregar cabeceras de seguridad adicionales

2. **Autenticación**:
   - Evaluar la validación JWT a nivel de gateway
   - Considerar implementar métodos adicionales de autenticación

3. **Monitoreo**:
   - Agregar recolección de métricas
   - Implementar registro avanzado

## Servicios Relacionados

El API Gateway es parte de una arquitectura de microservicios más grande que incluye:
- Servidor GraphQL
- Servicio de Autenticación
- Servicio de Gestión de Cuentas (ms-cuentas)
- Servicio CDC
- Kafka para streaming de eventos
- Bases de datos PostgreSQL y MariaDB

## Solución de Problemas

Si encuentras problemas:
1. Revisar logs de Kong: `docker logs kong`
2. Verificar conectividad de red: `docker network inspect integration-net`
3. Asegurar que todos los servicios dependientes estén funcionando
4. Validar la sintaxis del archivo de configuración de Kong 

<br>
<br>

___

# Investigación
## Objetivo: Comparar Kong y Apache APISIX como soluciones de API Gateway.

## 1. Qué es un API Gateway y su Importancia en la Integración Empresarial
Un API Gateway es un componente clave en la arquitectura de microservicios y la gestión de APIs. Actúa como un intermediario entre los clientes y los servicios backend, gestionando peticiones, autenticación, autorización, control de acceso, balanceo de carga y monitoreo.

### Importancia en la Integración Empresarial:
- **Seguridad**: Implementa autenticación, autorización y mitigación de ataques (Rate Limiting, DDoS).
- **Escalabilidad**: Permite gestionar múltiples peticiones y balanceo de carga.
- **Observabilidad**: Proporciona registros, monitoreo y trazabilidad de peticiones.
- **Optimización del Tráfico**: Facilita la transformación de peticiones y cacheo de respuestas.

## 2. Comparación de Kong y Apache APISIX

### 2.1 Arquitectura

| Característica               | Kong                      | Apache APISIX         |
|------------------------------|---------------------------|------------------------|
| **Base Tecnológica**         | Nginx + Lua               | Nginx + LuaJIT        |
| **Modelo de Implementación** | Tradicional y Kubernetes-native | Kubernetes-native y Serverless |
| **Almacenamiento de Configuración** | PostgreSQL, Cassandra, DB-less | etcd |
| **Soporte de Plugins**       | Lua, OpenResty            | Lua, Java, Python, WASM |
| **Arquitectura Extensible**  | Sí                        | Sí                     |

### 2.2 Características y Rendimiento

| Característica               | Kong                      | Apache APISIX         |
|------------------------------|---------------------------|------------------------|
| **Autenticación y Autorización** | OAuth2, JWT, Basic Auth  | OAuth2, JWT, Basic Auth, OpenID Connect |
| **Balanceo de Carga**        | Round-robin, hash-based   | Múltiples estrategias avanzadas |
| **Monitoreo y Observabilidad** | Prometheus, OpenTelemetry | Prometheus, OpenTelemetry, SkyWalking |
| **Escalabilidad**            | Alta, pero requiere configuración extra | Nativa, con integración en Kubernetes |
| **Rendimiento**              | Alto, pero con overhead en DB-mode | Superior debido a etcd y LuaJIT |

## 3. Casos de Uso Recomendados

### 3.1 Kong
- Empresas que ya usan PostgreSQL o Cassandra y desean integración rápida.
- Implementaciones en entornos híbridos (local y cloud).
- Aplicaciones con requisitos de seguridad avanzados (OAuth, JWT, Keycloak).
- Empresas que requieren un ecosistema maduro con soporte empresarial.

### 3.2 Apache APISIX
- Empresas con arquitecturas nativas en Kubernetes.
- Escenarios que requieren alto rendimiento y baja latencia.
- Proyectos con necesidades de plugins flexibles y configuraciones avanzadas.
- Integraciones con sistemas serverless y edge computing.

## 4. Consideraciones para Implementación en Producción
- **Elección del Modelo de Implementación**: Definir si se utilizará un modo basado en base de datos o sin base de datos.
- **Escalabilidad**: Evaluar la necesidad de balanceo de carga y distribución del tráfico.
- **Monitoreo y Observabilidad**: Implementar herramientas como Prometheus y OpenTelemetry.
- **Seguridad**: Configurar políticas de autenticación y autorización.
- **Soporte y Comunidad**: Evaluar la disponibilidad de soporte empresarial y la comunidad de desarrollo.

## Conclusión
Ambas soluciones son poderosas, pero la elección entre Kong y Apache APISIX dependerá de los requerimientos específicos del proyecto. Kong es ideal para entornos con necesidades de seguridad avanzadas y soporte empresarial, mientras que Apache APISIX ofrece mejor rendimiento y una integración nativa con Kubernetes y sistemas serverless.

## Referencias
- [Documentación oficial de Kong](https://docs.konghq.com)
- [Documentación oficial de Apache APISIX](https://apisix.apache.org)
