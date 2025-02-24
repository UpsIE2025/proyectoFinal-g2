const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');

// Cargar el archivo .proto de Cuentas
const packageDefinition = protoLoader.loadSync('../../ms-cuentas/src/main/proto' + '/cuenta.proto', {
  keepCase: true,
  longs: String,
  enums: String,
  defaults: true,
  oneofs: true
});

const cuentasProto = grpc.loadPackageDefinition(packageDefinition).cuentas;

// Crear el cliente gRPC para conectarse al microservicio "Cuentas"
const client = new cuentasProto.CuentasService(
  'ms-cuentas:8080',
  grpc.credentials.createInsecure() // No se usa seguridad
);

// Función para obtener una cuenta mediante gRPC
function obtenerCuenta(id) {
  return new Promise((resolve, reject) => {
    client.obtenerCuenta({ id }, (err, response) => {
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
    client.crearCuenta({ usuario_id, saldo_inicial }, (err, response) => {
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
    client.actualizarCuenta({ id, saldo, estado }, (err, response) => {
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
    client.listarCuentas({ id }, (err, response) => {
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
    client.crearConsumo({ cuenta_id, descripcion, monto }, (err, response) => {
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
    client.obtenerConsumo({ id }, (err, response) => {
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
    client.listarConsumos({ cuenta_id }, (err, response) => {
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
