package edu.ups.ms_cuentas.services;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import edu.ups.ms_cuentas.proto.CuentaGrpcServiceGrpc;
import edu.ups.ms_cuentas.proto.CuentaProto;
import edu.ups.ms_cuentas.proto.ConsumoProto;
import edu.ups.ms_cuentas.proto.CrearCuentaRequest;
import edu.ups.ms_cuentas.models.entities.Consumo;
import edu.ups.ms_cuentas.models.entities.Cuenta;
import edu.ups.ms_cuentas.proto.ActualizarCuentaRequest;
import edu.ups.ms_cuentas.proto.CrearConsumoRequest;
import edu.ups.ms_cuentas.proto.GetCuentaRequest;
import edu.ups.ms_cuentas.proto.GetConsumoRequest;
import edu.ups.ms_cuentas.proto.ListaCuentasResponse;
import edu.ups.ms_cuentas.proto.ListaConsumosResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@GrpcService
public class CuentaGrpcServiceImpl extends CuentaGrpcServiceGrpc.CuentaGrpcServiceImplBase {

  private final CuentaService cuentaService;
  private final ConsumoService consumoService;

  public CuentaGrpcServiceImpl(CuentaService cuentaService, ConsumoService consumoService) {
    this.cuentaService = cuentaService;
    this.consumoService = consumoService;
  }

  @Override
  public void crearCuenta(CrearCuentaRequest request, StreamObserver<CuentaProto> responseObserver) {
      Cuenta cuenta = new Cuenta();
      cuenta.setId(UUID.randomUUID().toString());
      cuenta.setUsuarioId(request.getUsuarioId());
      cuenta.setSaldo(request.getSaldoInicial());
      cuenta.setEstado("ACTIVA");
      cuenta.setFechaCreacion(LocalDateTime.now());
      
      Cuenta nuevaCuenta = cuentaService.crearCuenta(cuenta);
      
      CuentaProto response = convertirACuentaProto(nuevaCuenta);
      responseObserver.onNext(response);
      responseObserver.onCompleted();
  }

  @Override
  public void actualizarCuenta(ActualizarCuentaRequest request, StreamObserver<CuentaProto> responseObserver) {
      Cuenta cuenta = cuentaService.obtenerCuenta(request.getId())
              .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
      
      cuenta.setSaldo(request.getSaldo());
      cuenta.setEstado(request.getEstado());
      
      Cuenta cuentaActualizada = cuentaService.actualizarCuenta(cuenta);
      
      CuentaProto response = convertirACuentaProto(cuentaActualizada);
      responseObserver.onNext(response);
      responseObserver.onCompleted();
  }

  @Override
  public void obtenerCuenta(GetCuentaRequest request, StreamObserver<CuentaProto> responseObserver) {
      Cuenta cuenta = cuentaService.obtenerCuenta(request.getId())
              .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
      
      CuentaProto response = convertirACuentaProto(cuenta);
      responseObserver.onNext(response);
      responseObserver.onCompleted();
  }

  @Override
  public void listarCuentas(GetCuentaRequest request, StreamObserver<ListaCuentasResponse> responseObserver) {
      List<Cuenta> cuentas = cuentaService.obtenerCuentasPorUsuario(request.getId());
      
      ListaCuentasResponse response = ListaCuentasResponse.newBuilder()
              .addAllCuentas(cuentas.stream()
                      .map(this::convertirACuentaProto)
                      .collect(Collectors.toList()))
              .build();
      
      responseObserver.onNext(response);
      responseObserver.onCompleted();
  }

  @Override
  public void crearConsumo(CrearConsumoRequest request, StreamObserver<ConsumoProto> responseObserver) {
      Consumo consumo = new Consumo();
      consumo.setId(UUID.randomUUID().toString());
      consumo.setCuentaId(request.getCuentaId());
      consumo.setDescripcion(request.getDescripcion());
      consumo.setMonto(request.getMonto());
      consumo.setEstado("PENDIENTE");
      consumo.setFechaConsumo(LocalDateTime.now());
      
      Consumo nuevoConsumo = consumoService.crearConsumo(consumo);
      
      ConsumoProto response = convertirAConsumoProto(nuevoConsumo);
      responseObserver.onNext(response);
      responseObserver.onCompleted();
  }

  @Override
  public void obtenerConsumo(GetConsumoRequest request, StreamObserver<ConsumoProto> responseObserver) {
      Consumo consumo = consumoService.obtenerConsumo(request.getId())
              .orElseThrow(() -> new RuntimeException("Consumo no encontrado"));
      
      ConsumoProto response = convertirAConsumoProto(consumo);
      responseObserver.onNext(response);
      responseObserver.onCompleted();
  }

  @Override
  public void listarConsumos(GetConsumoRequest request, StreamObserver<ListaConsumosResponse> responseObserver) {
      List<Consumo> consumos = consumoService.obtenerConsumosPorCuenta(request.getId());
      
      ListaConsumosResponse response = ListaConsumosResponse.newBuilder()
              .addAllConsumos(consumos.stream()
                      .map(this::convertirAConsumoProto)
                      .collect(Collectors.toList()))
              .build();
      
      responseObserver.onNext(response);
      responseObserver.onCompleted();
  }

  private CuentaProto convertirACuentaProto(Cuenta cuenta) {
      return CuentaProto.newBuilder()
              .setId(cuenta.getId())
              .setUsuarioId(cuenta.getUsuarioId())
              .setSaldo(cuenta.getSaldo())
              .setEstado(cuenta.getEstado())
              .setFechaCreacion(cuenta.getFechaCreacion().toString())
              .build();
  }

  private ConsumoProto convertirAConsumoProto(Consumo consumo) {
      return ConsumoProto.newBuilder()
              .setId(consumo.getId())
              .setCuentaId(consumo.getCuentaId())
              .setDescripcion(consumo.getDescripcion())
              .setMonto(consumo.getMonto())
              .setEstado(consumo.getEstado())
              .setFechaConsumo(consumo.getFechaConsumo().toString())
              .build();
  }

}
