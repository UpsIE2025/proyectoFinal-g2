package edu.ups.ms_cuentas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ups.ms_cuentas.models.entities.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, String>{
  List<Consumo> findByCuentaId(String cuentaId);
  List<Consumo> findByEstado(String estado);
}
