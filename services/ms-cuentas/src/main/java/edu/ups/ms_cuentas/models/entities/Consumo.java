package edu.ups.ms_cuentas.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumos")
public class Consumo {

  @Id
  private String id;
  
  @Column(name = "cuenta_id", nullable = false)
  private String cuentaId;
  
  @Column(nullable = false)
  private String descripcion;
  
  @Column(nullable = false)
  private Double monto;
  
  @Column(name = "fecha_consumo", nullable = false)
  private LocalDateTime fechaConsumo;
  
  @Column(nullable = false)
  private String estado;
  
  @PrePersist
  protected void onCreate() {
      fechaConsumo = LocalDateTime.now();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCuentaId() {
    return cuentaId;
  }

  public void setCuentaId(String cuentaId) {
    this.cuentaId = cuentaId;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  public LocalDateTime getFechaConsumo() {
    return fechaConsumo;
  }

  public void setFechaConsumo(LocalDateTime fechaConsumo) {
    this.fechaConsumo = fechaConsumo;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  
}
