// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/resources/proto/test.proto

// Protobuf Java Version: 3.25.3
package com.gameengine.system.net.message;

public final class ProtoBufDemo {
  private ProtoBufDemo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Person1_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Person1_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Student2_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Student2_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n#src/main/resources/proto/test.proto\"5\n" +
      "\007Person1\022\014\n\004name\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\022\017\n\007h" +
      "obbies\030\003 \003(\t\"6\n\010Student2\022\014\n\004name\030\001 \001(\t\022\013" +
      "\n\003age\030\002 \001(\005\022\017\n\007hobbies\030\003 \003(\tB!\n\017com.net." +
      "messageB\014ProtoBufDemoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Person1_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Person1_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Person1_descriptor,
        new java.lang.String[] { "Name", "Age", "Hobbies", });
    internal_static_Student2_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Student2_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Student2_descriptor,
        new java.lang.String[] { "Name", "Age", "Hobbies", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}