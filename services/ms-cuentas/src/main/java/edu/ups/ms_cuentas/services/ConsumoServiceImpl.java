package edu.ups.ms_cuentas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ups.ms_cuentas.models.entities.Consumo;
import edu.ups.ms_cuentas.repositories.ConsumoRepository;

@Service
public class ConsumoServiceImpl implements ConsumoService {

  private final ConsumoRepository consumoRepository;

  public ConsumoServiceImpl(ConsumoRepository consumoRepository) {
    this.consumoRepository = consumoRepository;
  }
    
  @Override
  @Transactional
  public Consumo crearConsumo(Consumo consumo) {
      return consumoRepository.save(consumo);
  }
  
  @Override
  @Transactional(readOnly = true)
  public Optional<Consumo> obtenerConsumo(String id) {
      return consumoRepository.findById(id);
  }
  
  @Override
  @Transactional(readOnly = true)
  public List<Consumo> obtenerConsumosPorCuenta(String cuentaId) {
      return consumoRepository.findByCuentaId(cuentaId);
  }
  
  @Override
  @Transactional
  public Consumo actualizarConsumo(Consumo consumo) {
      return consumoRepository.save(consumo);
  }
  
  @Override
  @Transactional
  public void eliminarConsumo(String id) {
      consumoRepository.deleteById(id);
  }
  
}
