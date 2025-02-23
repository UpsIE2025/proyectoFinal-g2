package edu.ups.ms_cuentas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ups.ms_cuentas.models.entities.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, String>{
  List<Cuenta> findByUsuarioId(String usuarioId);
}
