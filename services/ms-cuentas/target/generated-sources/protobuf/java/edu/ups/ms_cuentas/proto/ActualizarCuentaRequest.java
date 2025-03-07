// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cuenta.proto

// Protobuf Java Version: 3.25.1
package edu.ups.ms_cuentas.proto;

/**
 * Protobuf type {@code ActualizarCuentaRequest}
 */
public final class ActualizarCuentaRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ActualizarCuentaRequest)
    ActualizarCuentaRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ActualizarCuentaRequest.newBuilder() to construct.
  private ActualizarCuentaRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ActualizarCuentaRequest() {
    id_ = "";
    estado_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ActualizarCuentaRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_ActualizarCuentaRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_ActualizarCuentaRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            edu.ups.ms_cuentas.proto.ActualizarCuentaRequest.class, edu.ups.ms_cuentas.proto.ActualizarCuentaRequest.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object id_ = "";
  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SALDO_FIELD_NUMBER = 2;
  private double saldo_ = 0D;
  /**
   * <code>double saldo = 2;</code>
   * @return The saldo.
   */
  @java.lang.Override
  public double getSaldo() {
    return saldo_;
  }

  public static final int ESTADO_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object estado_ = "";
  /**
   * <code>string estado = 3;</code>
   * @return The estado.
   */
  @java.lang.Override
  public java.lang.String getEstado() {
    java.lang.Object ref = estado_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      estado_ = s;
      return s;
    }
  }
  /**
   * <code>string estado = 3;</code>
   * @return The bytes for estado.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getEstadoBytes() {
    java.lang.Object ref = estado_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      estado_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(id_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
    }
    if (java.lang.Double.doubleToRawLongBits(saldo_) != 0) {
      output.writeDouble(2, saldo_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(estado_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, estado_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(id_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
    }
    if (java.lang.Double.doubleToRawLongBits(saldo_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, saldo_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(estado_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, estado_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof edu.ups.ms_cuentas.proto.ActualizarCuentaRequest)) {
      return super.equals(obj);
    }
    edu.ups.ms_cuentas.proto.ActualizarCuentaRequest other = (edu.ups.ms_cuentas.proto.ActualizarCuentaRequest) obj;

    if (!getId()
        .equals(other.getId())) return false;
    if (java.lang.Double.doubleToLongBits(getSaldo())
        != java.lang.Double.doubleToLongBits(
            other.getSaldo())) return false;
    if (!getEstado()
        .equals(other.getEstado())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + SALDO_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getSaldo()));
    hash = (37 * hash) + ESTADO_FIELD_NUMBER;
    hash = (53 * hash) + getEstado().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(edu.ups.ms_cuentas.proto.ActualizarCuentaRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ActualizarCuentaRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ActualizarCuentaRequest)
      edu.ups.ms_cuentas.proto.ActualizarCuentaRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_ActualizarCuentaRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_ActualizarCuentaRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              edu.ups.ms_cuentas.proto.ActualizarCuentaRequest.class, edu.ups.ms_cuentas.proto.ActualizarCuentaRequest.Builder.class);
    }

    // Construct using edu.ups.ms_cuentas.proto.ActualizarCuentaRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      id_ = "";
      saldo_ = 0D;
      estado_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_ActualizarCuentaRequest_descriptor;
    }

    @java.lang.Override
    public edu.ups.ms_cuentas.proto.ActualizarCuentaRequest getDefaultInstanceForType() {
      return edu.ups.ms_cuentas.proto.ActualizarCuentaRequest.getDefaultInstance();
    }

    @java.lang.Override
    public edu.ups.ms_cuentas.proto.ActualizarCuentaRequest build() {
      edu.ups.ms_cuentas.proto.ActualizarCuentaRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public edu.ups.ms_cuentas.proto.ActualizarCuentaRequest buildPartial() {
      edu.ups.ms_cuentas.proto.ActualizarCuentaRequest result = new edu.ups.ms_cuentas.proto.ActualizarCuentaRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(edu.ups.ms_cuentas.proto.ActualizarCuentaRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.id_ = id_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.saldo_ = saldo_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.estado_ = estado_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof edu.ups.ms_cuentas.proto.ActualizarCuentaRequest) {
        return mergeFrom((edu.ups.ms_cuentas.proto.ActualizarCuentaRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(edu.ups.ms_cuentas.proto.ActualizarCuentaRequest other) {
      if (other == edu.ups.ms_cuentas.proto.ActualizarCuentaRequest.getDefaultInstance()) return this;
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getSaldo() != 0D) {
        setSaldo(other.getSaldo());
      }
      if (!other.getEstado().isEmpty()) {
        estado_ = other.estado_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              id_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 17: {
              saldo_ = input.readDouble();
              bitField0_ |= 0x00000002;
              break;
            } // case 17
            case 26: {
              estado_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object id_ = "";
    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      id_ = getDefaultInstance().getId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @param value The bytes for id to set.
     * @return This builder for chaining.
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private double saldo_ ;
    /**
     * <code>double saldo = 2;</code>
     * @return The saldo.
     */
    @java.lang.Override
    public double getSaldo() {
      return saldo_;
    }
    /**
     * <code>double saldo = 2;</code>
     * @param value The saldo to set.
     * @return This builder for chaining.
     */
    public Builder setSaldo(double value) {

      saldo_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>double saldo = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSaldo() {
      bitField0_ = (bitField0_ & ~0x00000002);
      saldo_ = 0D;
      onChanged();
      return this;
    }

    private java.lang.Object estado_ = "";
    /**
     * <code>string estado = 3;</code>
     * @return The estado.
     */
    public java.lang.String getEstado() {
      java.lang.Object ref = estado_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        estado_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string estado = 3;</code>
     * @return The bytes for estado.
     */
    public com.google.protobuf.ByteString
        getEstadoBytes() {
      java.lang.Object ref = estado_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        estado_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string estado = 3;</code>
     * @param value The estado to set.
     * @return This builder for chaining.
     */
    public Builder setEstado(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      estado_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string estado = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearEstado() {
      estado_ = getDefaultInstance().getEstado();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string estado = 3;</code>
     * @param value The bytes for estado to set.
     * @return This builder for chaining.
     */
    public Builder setEstadoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      estado_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ActualizarCuentaRequest)
  }

  // @@protoc_insertion_point(class_scope:ActualizarCuentaRequest)
  private static final edu.ups.ms_cuentas.proto.ActualizarCuentaRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new edu.ups.ms_cuentas.proto.ActualizarCuentaRequest();
  }

  public static edu.ups.ms_cuentas.proto.ActualizarCuentaRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ActualizarCuentaRequest>
      PARSER = new com.google.protobuf.AbstractParser<ActualizarCuentaRequest>() {
    @java.lang.Override
    public ActualizarCuentaRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ActualizarCuentaRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ActualizarCuentaRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public edu.ups.ms_cuentas.proto.ActualizarCuentaRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

