package edu.ups.ms_cuentas.services;

import java.util.List;
import java.util.Optional;

import edu.ups.ms_cuentas.models.entities.Cuenta;

public interface CuentaService {
  Cuenta crearCuenta(Cuenta cuenta);
  Optional<Cuenta> obtenerCuenta(String id);
  List<Cuenta> obtenerCuentasPorUsuario(String usuarioId);
  Cuenta actualizarCuenta(Cuenta cuenta);
  void eliminarCuenta(String id);
}
