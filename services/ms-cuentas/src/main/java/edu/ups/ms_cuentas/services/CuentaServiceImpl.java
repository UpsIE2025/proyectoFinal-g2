package edu.ups.ms_cuentas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ups.ms_cuentas.models.entities.Cuenta;
import edu.ups.ms_cuentas.repositories.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService{

  private final CuentaRepository cuentaRepository;

  public CuentaServiceImpl(CuentaRepository cuentaRepository) {
    this.cuentaRepository = cuentaRepository;
  }
    
  @Override
  @Transactional
  public Cuenta crearCuenta(Cuenta cuenta) {
      return cuentaRepository.save(cuenta);
  }
  
  @Override
  @Transactional(readOnly = true)
  public Optional<Cuenta> obtenerCuenta(String id) {
      return cuentaRepository.findById(id);
  }
  
  @Override
  @Transactional(readOnly = true)
  public List<Cuenta> obtenerCuentasPorUsuario(String usuarioId) {
      return cuentaRepository.findByUsuarioId(usuarioId);
  }
  
  @Override
  @Transactional
  public Cuenta actualizarCuenta(Cuenta cuenta) {
      return cuentaRepository.save(cuenta);
  }
  
  @Override
  @Transactional
  public void eliminarCuenta(String id) {
      cuentaRepository.deleteById(id);
  }
  
}
