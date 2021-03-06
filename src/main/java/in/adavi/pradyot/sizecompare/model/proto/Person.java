// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: person.proto

package model.proto;

/**
 * Protobuf type {@code Person}
 */
public  final class Person extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Person)
    PersonOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Person.newBuilder() to construct.
  private Person(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Person() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Person();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Person(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 130: {
            model.proto.Name.Builder subBuilder = null;
            if (name_ != null) {
              subBuilder = name_.toBuilder();
            }
            name_ = input.readMessage(model.proto.Name.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(name_);
              name_ = subBuilder.buildPartial();
            }

            break;
          }
          case 136: {

            age_ = input.readUInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return model.proto.PersonOuterClass.internal_static_Person_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return model.proto.PersonOuterClass.internal_static_Person_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            model.proto.Person.class, model.proto.Person.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 16;
  private model.proto.Name name_;
  /**
   * <code>.Name name = 16;</code>
   */
  public boolean hasName() {
    return name_ != null;
  }
  /**
   * <code>.Name name = 16;</code>
   */
  public model.proto.Name getName() {
    return name_ == null ? model.proto.Name.getDefaultInstance() : name_;
  }
  /**
   * <code>.Name name = 16;</code>
   */
  public model.proto.NameOrBuilder getNameOrBuilder() {
    return getName();
  }

  public static final int AGE_FIELD_NUMBER = 17;
  private long age_;
  /**
   * <code>uint64 age = 17;</code>
   */
  public long getAge() {
    return age_;
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
    if (name_ != null) {
      output.writeMessage(16, getName());
    }
    if (age_ != 0L) {
      output.writeUInt64(17, age_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (name_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(16, getName());
    }
    if (age_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(17, age_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof model.proto.Person)) {
      return super.equals(obj);
    }
    model.proto.Person other = (model.proto.Person) obj;

    if (hasName() != other.hasName()) return false;
    if (hasName()) {
      if (!getName()
          .equals(other.getName())) return false;
    }
    if (getAge()
        != other.getAge()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasName()) {
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
    }
    hash = (37 * hash) + AGE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getAge());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static model.proto.Person parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static model.proto.Person parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static model.proto.Person parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static model.proto.Person parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static model.proto.Person parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static model.proto.Person parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static model.proto.Person parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static model.proto.Person parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static model.proto.Person parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static model.proto.Person parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static model.proto.Person parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static model.proto.Person parseFrom(
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
  public static Builder newBuilder(model.proto.Person prototype) {
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
   * Protobuf type {@code Person}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Person)
      model.proto.PersonOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return model.proto.PersonOuterClass.internal_static_Person_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return model.proto.PersonOuterClass.internal_static_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              model.proto.Person.class, model.proto.Person.Builder.class);
    }

    // Construct using model.proto.Person.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (nameBuilder_ == null) {
        name_ = null;
      } else {
        name_ = null;
        nameBuilder_ = null;
      }
      age_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return model.proto.PersonOuterClass.internal_static_Person_descriptor;
    }

    @java.lang.Override
    public model.proto.Person getDefaultInstanceForType() {
      return model.proto.Person.getDefaultInstance();
    }

    @java.lang.Override
    public model.proto.Person build() {
      model.proto.Person result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public model.proto.Person buildPartial() {
      model.proto.Person result = new model.proto.Person(this);
      if (nameBuilder_ == null) {
        result.name_ = name_;
      } else {
        result.name_ = nameBuilder_.build();
      }
      result.age_ = age_;
      onBuilt();
      return result;
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
      if (other instanceof model.proto.Person) {
        return mergeFrom((model.proto.Person)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(model.proto.Person other) {
      if (other == model.proto.Person.getDefaultInstance()) return this;
      if (other.hasName()) {
        mergeName(other.getName());
      }
      if (other.getAge() != 0L) {
        setAge(other.getAge());
      }
      this.mergeUnknownFields(other.unknownFields);
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
      model.proto.Person parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (model.proto.Person) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private model.proto.Name name_;
    private com.google.protobuf.SingleFieldBuilderV3<
        model.proto.Name, model.proto.Name.Builder, model.proto.NameOrBuilder> nameBuilder_;
    /**
     * <code>.Name name = 16;</code>
     */
    public boolean hasName() {
      return nameBuilder_ != null || name_ != null;
    }
    /**
     * <code>.Name name = 16;</code>
     */
    public model.proto.Name getName() {
      if (nameBuilder_ == null) {
        return name_ == null ? model.proto.Name.getDefaultInstance() : name_;
      } else {
        return nameBuilder_.getMessage();
      }
    }
    /**
     * <code>.Name name = 16;</code>
     */
    public Builder setName(model.proto.Name value) {
      if (nameBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        name_ = value;
        onChanged();
      } else {
        nameBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Name name = 16;</code>
     */
    public Builder setName(
        model.proto.Name.Builder builderForValue) {
      if (nameBuilder_ == null) {
        name_ = builderForValue.build();
        onChanged();
      } else {
        nameBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Name name = 16;</code>
     */
    public Builder mergeName(model.proto.Name value) {
      if (nameBuilder_ == null) {
        if (name_ != null) {
          name_ =
            model.proto.Name.newBuilder(name_).mergeFrom(value).buildPartial();
        } else {
          name_ = value;
        }
        onChanged();
      } else {
        nameBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Name name = 16;</code>
     */
    public Builder clearName() {
      if (nameBuilder_ == null) {
        name_ = null;
        onChanged();
      } else {
        name_ = null;
        nameBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Name name = 16;</code>
     */
    public model.proto.Name.Builder getNameBuilder() {
      
      onChanged();
      return getNameFieldBuilder().getBuilder();
    }
    /**
     * <code>.Name name = 16;</code>
     */
    public model.proto.NameOrBuilder getNameOrBuilder() {
      if (nameBuilder_ != null) {
        return nameBuilder_.getMessageOrBuilder();
      } else {
        return name_ == null ?
            model.proto.Name.getDefaultInstance() : name_;
      }
    }
    /**
     * <code>.Name name = 16;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        model.proto.Name, model.proto.Name.Builder, model.proto.NameOrBuilder> 
        getNameFieldBuilder() {
      if (nameBuilder_ == null) {
        nameBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            model.proto.Name, model.proto.Name.Builder, model.proto.NameOrBuilder>(
                getName(),
                getParentForChildren(),
                isClean());
        name_ = null;
      }
      return nameBuilder_;
    }

    private long age_ ;
    /**
     * <code>uint64 age = 17;</code>
     */
    public long getAge() {
      return age_;
    }
    /**
     * <code>uint64 age = 17;</code>
     */
    public Builder setAge(long value) {
      
      age_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 age = 17;</code>
     */
    public Builder clearAge() {
      
      age_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:Person)
  }

  // @@protoc_insertion_point(class_scope:Person)
  private static final model.proto.Person DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new model.proto.Person();
  }

  public static model.proto.Person getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Person>
      PARSER = new com.google.protobuf.AbstractParser<Person>() {
    @java.lang.Override
    public Person parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Person(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Person> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Person> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public model.proto.Person getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

