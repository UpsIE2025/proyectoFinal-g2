const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const path = require("path");

const PROTO_PATH = path.join(__dirname, '/cuenta.proto');

// Cargar el archivo .proto de Cuentas
const packageDefinition = protoLoader.loadSync(PROTO_PATH, {
  keepCase: true,
  longs: String,
  enums: String,
  defaults: true,
  oneofs: true
});

const cuentasProto = grpc.loadPackageDefinition(packageDefinition).CuentaGrpcService;

// Crear el cliente gRPC para conectarse al microservicio "Cuentas"
let client;
try {
  client = new cuentasProto(
  'ms-cuentas:9090',
  grpc.credentials.createInsecure() // No se usa seguridad
  );
} catch (error) {
  console.error('Error al crear el cliente gRPC:', error);
}

// Función para obtener una cuenta mediante gRPC
function obtenerCuenta(id) {
  return new Promise((resolve, reject) => {
    client.ObtenerCuenta({ id }, (err, response) => {
      if (err) {
        reject(err);
      } else {
        resolve(response);
      }
    });
  });
}

function crearCuenta(usuario_id, saldo_inicial) {
  return new Promise((resolve, reject) => {
    client.CrearCuenta({ usuario_id, saldo_inicial }, (err, response) => {
      if (err) {
        reject(err);
      } else {
        resolve(response);
      }
    });
  });
}

function actualizarCuenta(id, saldo, estado) {
  return new Promise((resolve, reject) => {
    client.ActualizarCuenta({ id, saldo, estado }, (err, response) => {
      if(err) {
        reject(err);
      } else {
        resolve(response);
      }
    });
  });
}

function listarCuentas(id) {
  return new Promise((resolve, reject) => {
    client.ListarCuentas({ id }, (err, response) => {
      if(err) {
        reject(err);
      } else {
        resolve(response);
      }
    });
  });
}

function crearConsumo(cuenta_id, descripcion, monto) {
  return new Promise((resolve, reject) => {
    client.CrearConsumo({ cuenta_id, descripcion, monto }, (err, response) => {
      if(err) {
        reject(err);
      } else {
        resolve(response);
      }
    });
  });
}

function obtenerConsumo(id) {
  return new Promise((resolve, reject) => {
    client.ObtenerConsumo({ id }, (err, response) => {
      if(err) {
        reject(err);
      } else {
        resolve(response);
      }
    });
  });
}

function listarConsumos(cuenta_id) {
  return new Promise((resolve, reject) => {
    client.ListarConsumos({ cuenta_id }, (err, response) => {
      if(err) {
        reject(err);
      } else {
        resolve(response);
      }
    });
  });
}


module.exports = {
  obtenerCuenta,
  crearCuenta,
  actualizarCuenta,
  listarCuentas,
  crearConsumo,
  obtenerConsumo,
  listarConsumos
};
