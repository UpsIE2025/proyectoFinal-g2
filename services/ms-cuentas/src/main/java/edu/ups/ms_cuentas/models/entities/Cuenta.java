package edu.ups.ms_cuentas.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {

  @Id
  private String id;
  
  @Column(name = "usuario_id", nullable = false)
  private String usuarioId;
  
  @Column(nullable = false)
  private Double saldo;
  
  @Column(nullable = false)
  private String estado;
  
  @Column(name = "fecha_creacion", nullable = false)
  private LocalDateTime fechaCreacion;
  
  @PrePersist
  protected void onCreate() {
      fechaCreacion = LocalDateTime.now();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(String usuarioId) {
    this.usuarioId = usuarioId;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  
  
}
