// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/github/sun5066/sampe.proto

package com.github.sun5066;

public final class AddressBookProtos {
  private AddressBookProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcchat_SendMsgRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcchat_SendMsgRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcchat_MsgResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcchat_MsgResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcchat_GetMsgRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcchat_GetMsgRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcchat_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcchat_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcchat_Person_PhoneNumber_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcchat_Person_PhoneNumber_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpcchat_AddressBook_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpcchat_AddressBook_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036com/github/sun5066/sampe.proto\022\010grpcch" +
      "at\"\036\n\016SendMsgRequest\022\014\n\004text\030\001 \001(\t\"\033\n\013Ms" +
      "gResponse\022\014\n\004text\030\001 \001(\t\"\035\n\rGetMsgRequest" +
      "\022\014\n\004text\030\001 \001(\t\"\343\001\n\006Person\022\014\n\004name\030\001 \001(\t\022" +
      "\n\n\002id\030\002 \001(\005\022\r\n\005email\030\003 \001(\t\022,\n\006phones\030\004 \003" +
      "(\0132\034.grpcchat.Person.PhoneNumber\032U\n\013Phon" +
      "eNumber\022\016\n\006number\030\001 \001(\t\022-\n\004type\030\002 \001(\0162\032." +
      "grpcchat.Person.PhoneTypeH\000\210\001\001B\007\n\005_type\"" +
      "+\n\tPhoneType\022\n\n\006MOBILE\020\000\022\010\n\004HOME\020\001\022\010\n\004WO" +
      "RK\020\002\"/\n\013AddressBook\022 \n\006people\030\001 \003(\0132\020.gr" +
      "pcchat.Person2\221\001\n\013ChatMessage\022@\n\013sendMes" +
      "sage\022\030.grpcchat.SendMsgRequest\032\025.grpccha" +
      "t.MsgResponse\"\000\022@\n\ngetMessage\022\027.grpcchat" +
      ".GetMsgRequest\032\025.grpcchat.MsgResponse\"\0000" +
      "\001B)\n\022com.github.sun5066B\021AddressBookProt" +
      "osP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_grpcchat_SendMsgRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpcchat_SendMsgRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcchat_SendMsgRequest_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_grpcchat_MsgResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpcchat_MsgResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcchat_MsgResponse_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_grpcchat_GetMsgRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_grpcchat_GetMsgRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcchat_GetMsgRequest_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_grpcchat_Person_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_grpcchat_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcchat_Person_descriptor,
        new java.lang.String[] { "Name", "Id", "Email", "Phones", });
    internal_static_grpcchat_Person_PhoneNumber_descriptor =
      internal_static_grpcchat_Person_descriptor.getNestedTypes().get(0);
    internal_static_grpcchat_Person_PhoneNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcchat_Person_PhoneNumber_descriptor,
        new java.lang.String[] { "Number", "Type", "Type", });
    internal_static_grpcchat_AddressBook_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_grpcchat_AddressBook_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpcchat_AddressBook_descriptor,
        new java.lang.String[] { "People", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
