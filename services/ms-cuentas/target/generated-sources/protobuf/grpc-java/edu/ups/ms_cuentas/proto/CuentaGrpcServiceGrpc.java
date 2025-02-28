package edu.ups.ms_cuentas.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: cuenta.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CuentaGrpcServiceGrpc {

  private CuentaGrpcServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "CuentaGrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.CrearCuentaRequest,
      edu.ups.ms_cuentas.proto.CuentaProto> getCrearCuentaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CrearCuenta",
      requestType = edu.ups.ms_cuentas.proto.CrearCuentaRequest.class,
      responseType = edu.ups.ms_cuentas.proto.CuentaProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.CrearCuentaRequest,
      edu.ups.ms_cuentas.proto.CuentaProto> getCrearCuentaMethod() {
    io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.CrearCuentaRequest, edu.ups.ms_cuentas.proto.CuentaProto> getCrearCuentaMethod;
    if ((getCrearCuentaMethod = CuentaGrpcServiceGrpc.getCrearCuentaMethod) == null) {
      synchronized (CuentaGrpcServiceGrpc.class) {
        if ((getCrearCuentaMethod = CuentaGrpcServiceGrpc.getCrearCuentaMethod) == null) {
          CuentaGrpcServiceGrpc.getCrearCuentaMethod = getCrearCuentaMethod =
              io.grpc.MethodDescriptor.<edu.ups.ms_cuentas.proto.CrearCuentaRequest, edu.ups.ms_cuentas.proto.CuentaProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CrearCuenta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.CrearCuentaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.CuentaProto.getDefaultInstance()))
              .setSchemaDescriptor(new CuentaGrpcServiceMethodDescriptorSupplier("CrearCuenta"))
              .build();
        }
      }
    }
    return getCrearCuentaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.ActualizarCuentaRequest,
      edu.ups.ms_cuentas.proto.CuentaProto> getActualizarCuentaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActualizarCuenta",
      requestType = edu.ups.ms_cuentas.proto.ActualizarCuentaRequest.class,
      responseType = edu.ups.ms_cuentas.proto.CuentaProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.ActualizarCuentaRequest,
      edu.ups.ms_cuentas.proto.CuentaProto> getActualizarCuentaMethod() {
    io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.ActualizarCuentaRequest, edu.ups.ms_cuentas.proto.CuentaProto> getActualizarCuentaMethod;
    if ((getActualizarCuentaMethod = CuentaGrpcServiceGrpc.getActualizarCuentaMethod) == null) {
      synchronized (CuentaGrpcServiceGrpc.class) {
        if ((getActualizarCuentaMethod = CuentaGrpcServiceGrpc.getActualizarCuentaMethod) == null) {
          CuentaGrpcServiceGrpc.getActualizarCuentaMethod = getActualizarCuentaMethod =
              io.grpc.MethodDescriptor.<edu.ups.ms_cuentas.proto.ActualizarCuentaRequest, edu.ups.ms_cuentas.proto.CuentaProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ActualizarCuenta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.ActualizarCuentaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.CuentaProto.getDefaultInstance()))
              .setSchemaDescriptor(new CuentaGrpcServiceMethodDescriptorSupplier("ActualizarCuenta"))
              .build();
        }
      }
    }
    return getActualizarCuentaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetCuentaRequest,
      edu.ups.ms_cuentas.proto.CuentaProto> getObtenerCuentaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ObtenerCuenta",
      requestType = edu.ups.ms_cuentas.proto.GetCuentaRequest.class,
      responseType = edu.ups.ms_cuentas.proto.CuentaProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetCuentaRequest,
      edu.ups.ms_cuentas.proto.CuentaProto> getObtenerCuentaMethod() {
    io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetCuentaRequest, edu.ups.ms_cuentas.proto.CuentaProto> getObtenerCuentaMethod;
    if ((getObtenerCuentaMethod = CuentaGrpcServiceGrpc.getObtenerCuentaMethod) == null) {
      synchronized (CuentaGrpcServiceGrpc.class) {
        if ((getObtenerCuentaMethod = CuentaGrpcServiceGrpc.getObtenerCuentaMethod) == null) {
          CuentaGrpcServiceGrpc.getObtenerCuentaMethod = getObtenerCuentaMethod =
              io.grpc.MethodDescriptor.<edu.ups.ms_cuentas.proto.GetCuentaRequest, edu.ups.ms_cuentas.proto.CuentaProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ObtenerCuenta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.GetCuentaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.CuentaProto.getDefaultInstance()))
              .setSchemaDescriptor(new CuentaGrpcServiceMethodDescriptorSupplier("ObtenerCuenta"))
              .build();
        }
      }
    }
    return getObtenerCuentaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetCuentaRequest,
      edu.ups.ms_cuentas.proto.ListaCuentasResponse> getListarCuentasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListarCuentas",
      requestType = edu.ups.ms_cuentas.proto.GetCuentaRequest.class,
      responseType = edu.ups.ms_cuentas.proto.ListaCuentasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetCuentaRequest,
      edu.ups.ms_cuentas.proto.ListaCuentasResponse> getListarCuentasMethod() {
    io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetCuentaRequest, edu.ups.ms_cuentas.proto.ListaCuentasResponse> getListarCuentasMethod;
    if ((getListarCuentasMethod = CuentaGrpcServiceGrpc.getListarCuentasMethod) == null) {
      synchronized (CuentaGrpcServiceGrpc.class) {
        if ((getListarCuentasMethod = CuentaGrpcServiceGrpc.getListarCuentasMethod) == null) {
          CuentaGrpcServiceGrpc.getListarCuentasMethod = getListarCuentasMethod =
              io.grpc.MethodDescriptor.<edu.ups.ms_cuentas.proto.GetCuentaRequest, edu.ups.ms_cuentas.proto.ListaCuentasResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListarCuentas"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.GetCuentaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.ListaCuentasResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CuentaGrpcServiceMethodDescriptorSupplier("ListarCuentas"))
              .build();
        }
      }
    }
    return getListarCuentasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.CrearConsumoRequest,
      edu.ups.ms_cuentas.proto.ConsumoProto> getCrearConsumoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CrearConsumo",
      requestType = edu.ups.ms_cuentas.proto.CrearConsumoRequest.class,
      responseType = edu.ups.ms_cuentas.proto.ConsumoProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.CrearConsumoRequest,
      edu.ups.ms_cuentas.proto.ConsumoProto> getCrearConsumoMethod() {
    io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.CrearConsumoRequest, edu.ups.ms_cuentas.proto.ConsumoProto> getCrearConsumoMethod;
    if ((getCrearConsumoMethod = CuentaGrpcServiceGrpc.getCrearConsumoMethod) == null) {
      synchronized (CuentaGrpcServiceGrpc.class) {
        if ((getCrearConsumoMethod = CuentaGrpcServiceGrpc.getCrearConsumoMethod) == null) {
          CuentaGrpcServiceGrpc.getCrearConsumoMethod = getCrearConsumoMethod =
              io.grpc.MethodDescriptor.<edu.ups.ms_cuentas.proto.CrearConsumoRequest, edu.ups.ms_cuentas.proto.ConsumoProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CrearConsumo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.CrearConsumoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.ConsumoProto.getDefaultInstance()))
              .setSchemaDescriptor(new CuentaGrpcServiceMethodDescriptorSupplier("CrearConsumo"))
              .build();
        }
      }
    }
    return getCrearConsumoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetConsumoRequest,
      edu.ups.ms_cuentas.proto.ConsumoProto> getObtenerConsumoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ObtenerConsumo",
      requestType = edu.ups.ms_cuentas.proto.GetConsumoRequest.class,
      responseType = edu.ups.ms_cuentas.proto.ConsumoProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetConsumoRequest,
      edu.ups.ms_cuentas.proto.ConsumoProto> getObtenerConsumoMethod() {
    io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetConsumoRequest, edu.ups.ms_cuentas.proto.ConsumoProto> getObtenerConsumoMethod;
    if ((getObtenerConsumoMethod = CuentaGrpcServiceGrpc.getObtenerConsumoMethod) == null) {
      synchronized (CuentaGrpcServiceGrpc.class) {
        if ((getObtenerConsumoMethod = CuentaGrpcServiceGrpc.getObtenerConsumoMethod) == null) {
          CuentaGrpcServiceGrpc.getObtenerConsumoMethod = getObtenerConsumoMethod =
              io.grpc.MethodDescriptor.<edu.ups.ms_cuentas.proto.GetConsumoRequest, edu.ups.ms_cuentas.proto.ConsumoProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ObtenerConsumo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.GetConsumoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.ConsumoProto.getDefaultInstance()))
              .setSchemaDescriptor(new CuentaGrpcServiceMethodDescriptorSupplier("ObtenerConsumo"))
              .build();
        }
      }
    }
    return getObtenerConsumoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetConsumoRequest,
      edu.ups.ms_cuentas.proto.ListaConsumosResponse> getListarConsumosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListarConsumos",
      requestType = edu.ups.ms_cuentas.proto.GetConsumoRequest.class,
      responseType = edu.ups.ms_cuentas.proto.ListaConsumosResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetConsumoRequest,
      edu.ups.ms_cuentas.proto.ListaConsumosResponse> getListarConsumosMethod() {
    io.grpc.MethodDescriptor<edu.ups.ms_cuentas.proto.GetConsumoRequest, edu.ups.ms_cuentas.proto.ListaConsumosResponse> getListarConsumosMethod;
    if ((getListarConsumosMethod = CuentaGrpcServiceGrpc.getListarConsumosMethod) == null) {
      synchronized (CuentaGrpcServiceGrpc.class) {
        if ((getListarConsumosMethod = CuentaGrpcServiceGrpc.getListarConsumosMethod) == null) {
          CuentaGrpcServiceGrpc.getListarConsumosMethod = getListarConsumosMethod =
              io.grpc.MethodDescriptor.<edu.ups.ms_cuentas.proto.GetConsumoRequest, edu.ups.ms_cuentas.proto.ListaConsumosResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListarConsumos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.GetConsumoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.ups.ms_cuentas.proto.ListaConsumosResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CuentaGrpcServiceMethodDescriptorSupplier("ListarConsumos"))
              .build();
        }
      }
    }
    return getListarConsumosMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CuentaGrpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CuentaGrpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CuentaGrpcServiceStub>() {
        @java.lang.Override
        public CuentaGrpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CuentaGrpcServiceStub(channel, callOptions);
        }
      };
    return CuentaGrpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CuentaGrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CuentaGrpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CuentaGrpcServiceBlockingStub>() {
        @java.lang.Override
        public CuentaGrpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CuentaGrpcServiceBlockingStub(channel, callOptions);
        }
      };
    return CuentaGrpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CuentaGrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CuentaGrpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CuentaGrpcServiceFutureStub>() {
        @java.lang.Override
        public CuentaGrpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CuentaGrpcServiceFutureStub(channel, callOptions);
        }
      };
    return CuentaGrpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void crearCuenta(edu.ups.ms_cuentas.proto.CrearCuentaRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.CuentaProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCrearCuentaMethod(), responseObserver);
    }

    /**
     */
    default void actualizarCuenta(edu.ups.ms_cuentas.proto.ActualizarCuentaRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.CuentaProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getActualizarCuentaMethod(), responseObserver);
    }

    /**
     */
    default void obtenerCuenta(edu.ups.ms_cuentas.proto.GetCuentaRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.CuentaProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getObtenerCuentaMethod(), responseObserver);
    }

    /**
     */
    default void listarCuentas(edu.ups.ms_cuentas.proto.GetCuentaRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ListaCuentasResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListarCuentasMethod(), responseObserver);
    }

    /**
     */
    default void crearConsumo(edu.ups.ms_cuentas.proto.CrearConsumoRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ConsumoProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCrearConsumoMethod(), responseObserver);
    }

    /**
     */
    default void obtenerConsumo(edu.ups.ms_cuentas.proto.GetConsumoRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ConsumoProto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getObtenerConsumoMethod(), responseObserver);
    }

    /**
     */
    default void listarConsumos(edu.ups.ms_cuentas.proto.GetConsumoRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ListaConsumosResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListarConsumosMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CuentaGrpcService.
   */
  public static abstract class CuentaGrpcServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CuentaGrpcServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CuentaGrpcService.
   */
  public static final class CuentaGrpcServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CuentaGrpcServiceStub> {
    private CuentaGrpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CuentaGrpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CuentaGrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void crearCuenta(edu.ups.ms_cuentas.proto.CrearCuentaRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.CuentaProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCrearCuentaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void actualizarCuenta(edu.ups.ms_cuentas.proto.ActualizarCuentaRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.CuentaProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getActualizarCuentaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void obtenerCuenta(edu.ups.ms_cuentas.proto.GetCuentaRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.CuentaProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getObtenerCuentaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listarCuentas(edu.ups.ms_cuentas.proto.GetCuentaRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ListaCuentasResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListarCuentasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void crearConsumo(edu.ups.ms_cuentas.proto.CrearConsumoRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ConsumoProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCrearConsumoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void obtenerConsumo(edu.ups.ms_cuentas.proto.GetConsumoRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ConsumoProto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getObtenerConsumoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listarConsumos(edu.ups.ms_cuentas.proto.GetConsumoRequest request,
        io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ListaConsumosResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListarConsumosMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CuentaGrpcService.
   */
  public static final class CuentaGrpcServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CuentaGrpcServiceBlockingStub> {
    private CuentaGrpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CuentaGrpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CuentaGrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.ups.ms_cuentas.proto.CuentaProto crearCuenta(edu.ups.ms_cuentas.proto.CrearCuentaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCrearCuentaMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.ups.ms_cuentas.proto.CuentaProto actualizarCuenta(edu.ups.ms_cuentas.proto.ActualizarCuentaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getActualizarCuentaMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.ups.ms_cuentas.proto.CuentaProto obtenerCuenta(edu.ups.ms_cuentas.proto.GetCuentaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getObtenerCuentaMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.ups.ms_cuentas.proto.ListaCuentasResponse listarCuentas(edu.ups.ms_cuentas.proto.GetCuentaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListarCuentasMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.ups.ms_cuentas.proto.ConsumoProto crearConsumo(edu.ups.ms_cuentas.proto.CrearConsumoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCrearConsumoMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.ups.ms_cuentas.proto.ConsumoProto obtenerConsumo(edu.ups.ms_cuentas.proto.GetConsumoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getObtenerConsumoMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.ups.ms_cuentas.proto.ListaConsumosResponse listarConsumos(edu.ups.ms_cuentas.proto.GetConsumoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListarConsumosMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CuentaGrpcService.
   */
  public static final class CuentaGrpcServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CuentaGrpcServiceFutureStub> {
    private CuentaGrpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CuentaGrpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CuentaGrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.ups.ms_cuentas.proto.CuentaProto> crearCuenta(
        edu.ups.ms_cuentas.proto.CrearCuentaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCrearCuentaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.ups.ms_cuentas.proto.CuentaProto> actualizarCuenta(
        edu.ups.ms_cuentas.proto.ActualizarCuentaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getActualizarCuentaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.ups.ms_cuentas.proto.CuentaProto> obtenerCuenta(
        edu.ups.ms_cuentas.proto.GetCuentaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getObtenerCuentaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.ups.ms_cuentas.proto.ListaCuentasResponse> listarCuentas(
        edu.ups.ms_cuentas.proto.GetCuentaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListarCuentasMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.ups.ms_cuentas.proto.ConsumoProto> crearConsumo(
        edu.ups.ms_cuentas.proto.CrearConsumoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCrearConsumoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.ups.ms_cuentas.proto.ConsumoProto> obtenerConsumo(
        edu.ups.ms_cuentas.proto.GetConsumoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getObtenerConsumoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.ups.ms_cuentas.proto.ListaConsumosResponse> listarConsumos(
        edu.ups.ms_cuentas.proto.GetConsumoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListarConsumosMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREAR_CUENTA = 0;
  private static final int METHODID_ACTUALIZAR_CUENTA = 1;
  private static final int METHODID_OBTENER_CUENTA = 2;
  private static final int METHODID_LISTAR_CUENTAS = 3;
  private static final int METHODID_CREAR_CONSUMO = 4;
  private static final int METHODID_OBTENER_CONSUMO = 5;
  private static final int METHODID_LISTAR_CONSUMOS = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREAR_CUENTA:
          serviceImpl.crearCuenta((edu.ups.ms_cuentas.proto.CrearCuentaRequest) request,
              (io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.CuentaProto>) responseObserver);
          break;
        case METHODID_ACTUALIZAR_CUENTA:
          serviceImpl.actualizarCuenta((edu.ups.ms_cuentas.proto.ActualizarCuentaRequest) request,
              (io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.CuentaProto>) responseObserver);
          break;
        case METHODID_OBTENER_CUENTA:
          serviceImpl.obtenerCuenta((edu.ups.ms_cuentas.proto.GetCuentaRequest) request,
              (io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.CuentaProto>) responseObserver);
          break;
        case METHODID_LISTAR_CUENTAS:
          serviceImpl.listarCuentas((edu.ups.ms_cuentas.proto.GetCuentaRequest) request,
              (io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ListaCuentasResponse>) responseObserver);
          break;
        case METHODID_CREAR_CONSUMO:
          serviceImpl.crearConsumo((edu.ups.ms_cuentas.proto.CrearConsumoRequest) request,
              (io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ConsumoProto>) responseObserver);
          break;
        case METHODID_OBTENER_CONSUMO:
          serviceImpl.obtenerConsumo((edu.ups.ms_cuentas.proto.GetConsumoRequest) request,
              (io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ConsumoProto>) responseObserver);
          break;
        case METHODID_LISTAR_CONSUMOS:
          serviceImpl.listarConsumos((edu.ups.ms_cuentas.proto.GetConsumoRequest) request,
              (io.grpc.stub.StreamObserver<edu.ups.ms_cuentas.proto.ListaConsumosResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCrearCuentaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.ups.ms_cuentas.proto.CrearCuentaRequest,
              edu.ups.ms_cuentas.proto.CuentaProto>(
                service, METHODID_CREAR_CUENTA)))
        .addMethod(
          getActualizarCuentaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.ups.ms_cuentas.proto.ActualizarCuentaRequest,
              edu.ups.ms_cuentas.proto.CuentaProto>(
                service, METHODID_ACTUALIZAR_CUENTA)))
        .addMethod(
          getObtenerCuentaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.ups.ms_cuentas.proto.GetCuentaRequest,
              edu.ups.ms_cuentas.proto.CuentaProto>(
                service, METHODID_OBTENER_CUENTA)))
        .addMethod(
          getListarCuentasMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.ups.ms_cuentas.proto.GetCuentaRequest,
              edu.ups.ms_cuentas.proto.ListaCuentasResponse>(
                service, METHODID_LISTAR_CUENTAS)))
        .addMethod(
          getCrearConsumoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.ups.ms_cuentas.proto.CrearConsumoRequest,
              edu.ups.ms_cuentas.proto.ConsumoProto>(
                service, METHODID_CREAR_CONSUMO)))
        .addMethod(
          getObtenerConsumoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.ups.ms_cuentas.proto.GetConsumoRequest,
              edu.ups.ms_cuentas.proto.ConsumoProto>(
                service, METHODID_OBTENER_CONSUMO)))
        .addMethod(
          getListarConsumosMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.ups.ms_cuentas.proto.GetConsumoRequest,
              edu.ups.ms_cuentas.proto.ListaConsumosResponse>(
                service, METHODID_LISTAR_CONSUMOS)))
        .build();
  }

  private static abstract class CuentaGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CuentaGrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.ups.ms_cuentas.proto.CuentaOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CuentaGrpcService");
    }
  }

  private static final class CuentaGrpcServiceFileDescriptorSupplier
      extends CuentaGrpcServiceBaseDescriptorSupplier {
    CuentaGrpcServiceFileDescriptorSupplier() {}
  }

  private static final class CuentaGrpcServiceMethodDescriptorSupplier
      extends CuentaGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CuentaGrpcServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CuentaGrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CuentaGrpcServiceFileDescriptorSupplier())
              .addMethod(getCrearCuentaMethod())
              .addMethod(getActualizarCuentaMethod())
              .addMethod(getObtenerCuentaMethod())
              .addMethod(getListarCuentasMethod())
              .addMethod(getCrearConsumoMethod())
              .addMethod(getObtenerConsumoMethod())
              .addMethod(getListarConsumosMethod())
              .build();
        }
      }
    }
    return result;
  }
}
