// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cuenta.proto

// Protobuf Java Version: 3.25.1
package edu.ups.ms_cuentas.proto;

/**
 * Protobuf type {@code CrearConsumoRequest}
 */
public final class CrearConsumoRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:CrearConsumoRequest)
    CrearConsumoRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CrearConsumoRequest.newBuilder() to construct.
  private CrearConsumoRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CrearConsumoRequest() {
    cuentaId_ = "";
    descripcion_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CrearConsumoRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_CrearConsumoRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_CrearConsumoRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            edu.ups.ms_cuentas.proto.CrearConsumoRequest.class, edu.ups.ms_cuentas.proto.CrearConsumoRequest.Builder.class);
  }

  public static final int CUENTA_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object cuentaId_ = "";
  /**
   * <code>string cuenta_id = 1;</code>
   * @return The cuentaId.
   */
  @java.lang.Override
  public java.lang.String getCuentaId() {
    java.lang.Object ref = cuentaId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      cuentaId_ = s;
      return s;
    }
  }
  /**
   * <code>string cuenta_id = 1;</code>
   * @return The bytes for cuentaId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCuentaIdBytes() {
    java.lang.Object ref = cuentaId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      cuentaId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DESCRIPCION_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object descripcion_ = "";
  /**
   * <code>string descripcion = 2;</code>
   * @return The descripcion.
   */
  @java.lang.Override
  public java.lang.String getDescripcion() {
    java.lang.Object ref = descripcion_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      descripcion_ = s;
      return s;
    }
  }
  /**
   * <code>string descripcion = 2;</code>
   * @return The bytes for descripcion.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDescripcionBytes() {
    java.lang.Object ref = descripcion_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      descripcion_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MONTO_FIELD_NUMBER = 3;
  private double monto_ = 0D;
  /**
   * <code>double monto = 3;</code>
   * @return The monto.
   */
  @java.lang.Override
  public double getMonto() {
    return monto_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(cuentaId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, cuentaId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(descripcion_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, descripcion_);
    }
    if (java.lang.Double.doubleToRawLongBits(monto_) != 0) {
      output.writeDouble(3, monto_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(cuentaId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, cuentaId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(descripcion_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, descripcion_);
    }
    if (java.lang.Double.doubleToRawLongBits(monto_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, monto_);
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
    if (!(obj instanceof edu.ups.ms_cuentas.proto.CrearConsumoRequest)) {
      return super.equals(obj);
    }
    edu.ups.ms_cuentas.proto.CrearConsumoRequest other = (edu.ups.ms_cuentas.proto.CrearConsumoRequest) obj;

    if (!getCuentaId()
        .equals(other.getCuentaId())) return false;
    if (!getDescripcion()
        .equals(other.getDescripcion())) return false;
    if (java.lang.Double.doubleToLongBits(getMonto())
        != java.lang.Double.doubleToLongBits(
            other.getMonto())) return false;
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
    hash = (37 * hash) + CUENTA_ID_FIELD_NUMBER;
    hash = (53 * hash) + getCuentaId().hashCode();
    hash = (37 * hash) + DESCRIPCION_FIELD_NUMBER;
    hash = (53 * hash) + getDescripcion().hashCode();
    hash = (37 * hash) + MONTO_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getMonto()));
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest parseFrom(
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
  public static Builder newBuilder(edu.ups.ms_cuentas.proto.CrearConsumoRequest prototype) {
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
   * Protobuf type {@code CrearConsumoRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:CrearConsumoRequest)
      edu.ups.ms_cuentas.proto.CrearConsumoRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_CrearConsumoRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_CrearConsumoRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              edu.ups.ms_cuentas.proto.CrearConsumoRequest.class, edu.ups.ms_cuentas.proto.CrearConsumoRequest.Builder.class);
    }

    // Construct using edu.ups.ms_cuentas.proto.CrearConsumoRequest.newBuilder()
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
      cuentaId_ = "";
      descripcion_ = "";
      monto_ = 0D;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return edu.ups.ms_cuentas.proto.CuentaOuterClass.internal_static_CrearConsumoRequest_descriptor;
    }

    @java.lang.Override
    public edu.ups.ms_cuentas.proto.CrearConsumoRequest getDefaultInstanceForType() {
      return edu.ups.ms_cuentas.proto.CrearConsumoRequest.getDefaultInstance();
    }

    @java.lang.Override
    public edu.ups.ms_cuentas.proto.CrearConsumoRequest build() {
      edu.ups.ms_cuentas.proto.CrearConsumoRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public edu.ups.ms_cuentas.proto.CrearConsumoRequest buildPartial() {
      edu.ups.ms_cuentas.proto.CrearConsumoRequest result = new edu.ups.ms_cuentas.proto.CrearConsumoRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(edu.ups.ms_cuentas.proto.CrearConsumoRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.cuentaId_ = cuentaId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.descripcion_ = descripcion_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.monto_ = monto_;
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
      if (other instanceof edu.ups.ms_cuentas.proto.CrearConsumoRequest) {
        return mergeFrom((edu.ups.ms_cuentas.proto.CrearConsumoRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(edu.ups.ms_cuentas.proto.CrearConsumoRequest other) {
      if (other == edu.ups.ms_cuentas.proto.CrearConsumoRequest.getDefaultInstance()) return this;
      if (!other.getCuentaId().isEmpty()) {
        cuentaId_ = other.cuentaId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getDescripcion().isEmpty()) {
        descripcion_ = other.descripcion_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.getMonto() != 0D) {
        setMonto(other.getMonto());
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
              cuentaId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              descripcion_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 25: {
              monto_ = input.readDouble();
              bitField0_ |= 0x00000004;
              break;
            } // case 25
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

    private java.lang.Object cuentaId_ = "";
    /**
     * <code>string cuenta_id = 1;</code>
     * @return The cuentaId.
     */
    public java.lang.String getCuentaId() {
      java.lang.Object ref = cuentaId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cuentaId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string cuenta_id = 1;</code>
     * @return The bytes for cuentaId.
     */
    public com.google.protobuf.ByteString
        getCuentaIdBytes() {
      java.lang.Object ref = cuentaId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cuentaId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string cuenta_id = 1;</code>
     * @param value The cuentaId to set.
     * @return This builder for chaining.
     */
    public Builder setCuentaId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      cuentaId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string cuenta_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCuentaId() {
      cuentaId_ = getDefaultInstance().getCuentaId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string cuenta_id = 1;</code>
     * @param value The bytes for cuentaId to set.
     * @return This builder for chaining.
     */
    public Builder setCuentaIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      cuentaId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object descripcion_ = "";
    /**
     * <code>string descripcion = 2;</code>
     * @return The descripcion.
     */
    public java.lang.String getDescripcion() {
      java.lang.Object ref = descripcion_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        descripcion_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string descripcion = 2;</code>
     * @return The bytes for descripcion.
     */
    public com.google.protobuf.ByteString
        getDescripcionBytes() {
      java.lang.Object ref = descripcion_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        descripcion_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string descripcion = 2;</code>
     * @param value The descripcion to set.
     * @return This builder for chaining.
     */
    public Builder setDescripcion(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      descripcion_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string descripcion = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearDescripcion() {
      descripcion_ = getDefaultInstance().getDescripcion();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string descripcion = 2;</code>
     * @param value The bytes for descripcion to set.
     * @return This builder for chaining.
     */
    public Builder setDescripcionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      descripcion_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private double monto_ ;
    /**
     * <code>double monto = 3;</code>
     * @return The monto.
     */
    @java.lang.Override
    public double getMonto() {
      return monto_;
    }
    /**
     * <code>double monto = 3;</code>
     * @param value The monto to set.
     * @return This builder for chaining.
     */
    public Builder setMonto(double value) {

      monto_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>double monto = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearMonto() {
      bitField0_ = (bitField0_ & ~0x00000004);
      monto_ = 0D;
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


    // @@protoc_insertion_point(builder_scope:CrearConsumoRequest)
  }

  // @@protoc_insertion_point(class_scope:CrearConsumoRequest)
  private static final edu.ups.ms_cuentas.proto.CrearConsumoRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new edu.ups.ms_cuentas.proto.CrearConsumoRequest();
  }

  public static edu.ups.ms_cuentas.proto.CrearConsumoRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CrearConsumoRequest>
      PARSER = new com.google.protobuf.AbstractParser<CrearConsumoRequest>() {
    @java.lang.Override
    public CrearConsumoRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<CrearConsumoRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CrearConsumoRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public edu.ups.ms_cuentas.proto.CrearConsumoRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

