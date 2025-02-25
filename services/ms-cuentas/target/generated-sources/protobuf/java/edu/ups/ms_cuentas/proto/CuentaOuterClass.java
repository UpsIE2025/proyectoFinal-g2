// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cuenta.proto

// Protobuf Java Version: 3.25.1
package edu.ups.ms_cuentas.proto;

public final class CuentaOuterClass {
  private CuentaOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CuentaProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CuentaProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ConsumoProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ConsumoProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CrearCuentaRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CrearCuentaRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ActualizarCuentaRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ActualizarCuentaRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CrearConsumoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CrearConsumoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetCuentaRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetCuentaRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetConsumoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetConsumoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ListaCuentasResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ListaCuentasResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ListaConsumosResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ListaConsumosResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014cuenta.proto\"d\n\013CuentaProto\022\n\n\002id\030\001 \001(" +
      "\t\022\022\n\nusuario_id\030\002 \001(\t\022\r\n\005saldo\030\003 \001(\001\022\016\n\006" +
      "estado\030\004 \001(\t\022\026\n\016fecha_creacion\030\005 \001(\t\"x\n\014" +
      "ConsumoProto\022\n\n\002id\030\001 \001(\t\022\021\n\tcuenta_id\030\002 " +
      "\001(\t\022\023\n\013descripcion\030\003 \001(\t\022\r\n\005monto\030\004 \001(\001\022" +
      "\016\n\006estado\030\005 \001(\t\022\025\n\rfecha_consumo\030\006 \001(\t\"?" +
      "\n\022CrearCuentaRequest\022\022\n\nusuario_id\030\001 \001(\t" +
      "\022\025\n\rsaldo_inicial\030\002 \001(\001\"D\n\027ActualizarCue" +
      "ntaRequest\022\n\n\002id\030\001 \001(\t\022\r\n\005saldo\030\002 \001(\001\022\016\n" +
      "\006estado\030\003 \001(\t\"L\n\023CrearConsumoRequest\022\021\n\t" +
      "cuenta_id\030\001 \001(\t\022\023\n\013descripcion\030\002 \001(\t\022\r\n\005" +
      "monto\030\003 \001(\001\"\036\n\020GetCuentaRequest\022\n\n\002id\030\001 " +
      "\001(\t\"\037\n\021GetConsumoRequest\022\n\n\002id\030\001 \001(\t\"5\n\024" +
      "ListaCuentasResponse\022\035\n\007cuentas\030\001 \003(\0132\014." +
      "CuentaProto\"8\n\025ListaConsumosResponse\022\037\n\010" +
      "consumos\030\001 \003(\0132\r.ConsumoProto2\226\003\n\021Cuenta" +
      "GrpcService\0220\n\013CrearCuenta\022\023.CrearCuenta" +
      "Request\032\014.CuentaProto\022:\n\020ActualizarCuent" +
      "a\022\030.ActualizarCuentaRequest\032\014.CuentaProt" +
      "o\0220\n\rObtenerCuenta\022\021.GetCuentaRequest\032\014." +
      "CuentaProto\0229\n\rListarCuentas\022\021.GetCuenta" +
      "Request\032\025.ListaCuentasResponse\0223\n\014CrearC" +
      "onsumo\022\024.CrearConsumoRequest\032\r.ConsumoPr" +
      "oto\0223\n\016ObtenerConsumo\022\022.GetConsumoReques" +
      "t\032\r.ConsumoProto\022<\n\016ListarConsumos\022\022.Get" +
      "ConsumoRequest\032\026.ListaConsumosResponseB1" +
      "\n\030edu.ups.ms_cuentas.protoB\020CuentaOuterC" +
      "lassP\001\240\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_CuentaProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CuentaProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CuentaProto_descriptor,
        new java.lang.String[] { "Id", "UsuarioId", "Saldo", "Estado", "FechaCreacion", });
    internal_static_ConsumoProto_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ConsumoProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ConsumoProto_descriptor,
        new java.lang.String[] { "Id", "CuentaId", "Descripcion", "Monto", "Estado", "FechaConsumo", });
    internal_static_CrearCuentaRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CrearCuentaRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CrearCuentaRequest_descriptor,
        new java.lang.String[] { "UsuarioId", "SaldoInicial", });
    internal_static_ActualizarCuentaRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ActualizarCuentaRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ActualizarCuentaRequest_descriptor,
        new java.lang.String[] { "Id", "Saldo", "Estado", });
    internal_static_CrearConsumoRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_CrearConsumoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CrearConsumoRequest_descriptor,
        new java.lang.String[] { "CuentaId", "Descripcion", "Monto", });
    internal_static_GetCuentaRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_GetCuentaRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetCuentaRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_GetConsumoRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_GetConsumoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetConsumoRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_ListaCuentasResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ListaCuentasResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ListaCuentasResponse_descriptor,
        new java.lang.String[] { "Cuentas", });
    internal_static_ListaConsumosResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_ListaConsumosResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ListaConsumosResponse_descriptor,
        new java.lang.String[] { "Consumos", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
