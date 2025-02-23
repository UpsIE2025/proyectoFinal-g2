package edu.ups.ms_cuentas.services;

import java.util.List;
import java.util.Optional;

import edu.ups.ms_cuentas.models.entities.Consumo;

public interface ConsumoService {

  Consumo crearConsumo(Consumo consumo);
  Optional<Consumo> obtenerConsumo(String id);
  List<Consumo> obtenerConsumosPorCuenta(String cuentaId);
  Consumo actualizarConsumo(Consumo consumo);
  void eliminarConsumo(String id);
  
}
