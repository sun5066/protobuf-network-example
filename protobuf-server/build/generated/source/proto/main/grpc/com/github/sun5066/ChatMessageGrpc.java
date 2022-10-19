package com.github.sun5066;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.2)",
    comments = "Source: com/github/sun5066/sampe.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChatMessageGrpc {

  private ChatMessageGrpc() {}

  public static final String SERVICE_NAME = "grpcchat.ChatMessage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.sun5066.SendMsgRequest,
      com.github.sun5066.MsgResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessage",
      requestType = com.github.sun5066.SendMsgRequest.class,
      responseType = com.github.sun5066.MsgResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.sun5066.SendMsgRequest,
      com.github.sun5066.MsgResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.github.sun5066.SendMsgRequest, com.github.sun5066.MsgResponse> getSendMessageMethod;
    if ((getSendMessageMethod = ChatMessageGrpc.getSendMessageMethod) == null) {
      synchronized (ChatMessageGrpc.class) {
        if ((getSendMessageMethod = ChatMessageGrpc.getSendMessageMethod) == null) {
          ChatMessageGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<com.github.sun5066.SendMsgRequest, com.github.sun5066.MsgResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.sun5066.SendMsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.sun5066.MsgResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ChatMessageMethodDescriptorSupplier("sendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.sun5066.GetMsgRequest,
      com.github.sun5066.MsgResponse> getGetMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMessage",
      requestType = com.github.sun5066.GetMsgRequest.class,
      responseType = com.github.sun5066.MsgResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.sun5066.GetMsgRequest,
      com.github.sun5066.MsgResponse> getGetMessageMethod() {
    io.grpc.MethodDescriptor<com.github.sun5066.GetMsgRequest, com.github.sun5066.MsgResponse> getGetMessageMethod;
    if ((getGetMessageMethod = ChatMessageGrpc.getGetMessageMethod) == null) {
      synchronized (ChatMessageGrpc.class) {
        if ((getGetMessageMethod = ChatMessageGrpc.getGetMessageMethod) == null) {
          ChatMessageGrpc.getGetMessageMethod = getGetMessageMethod =
              io.grpc.MethodDescriptor.<com.github.sun5066.GetMsgRequest, com.github.sun5066.MsgResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.sun5066.GetMsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.sun5066.MsgResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ChatMessageMethodDescriptorSupplier("getMessage"))
              .build();
        }
      }
    }
    return getGetMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatMessageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatMessageStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatMessageStub>() {
        @java.lang.Override
        public ChatMessageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatMessageStub(channel, callOptions);
        }
      };
    return ChatMessageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatMessageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatMessageBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatMessageBlockingStub>() {
        @java.lang.Override
        public ChatMessageBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatMessageBlockingStub(channel, callOptions);
        }
      };
    return ChatMessageBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatMessageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatMessageFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatMessageFutureStub>() {
        @java.lang.Override
        public ChatMessageFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatMessageFutureStub(channel, callOptions);
        }
      };
    return ChatMessageFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChatMessageImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendMessage(com.github.sun5066.SendMsgRequest request,
        io.grpc.stub.StreamObserver<com.github.sun5066.MsgResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     */
    public void getMessage(com.github.sun5066.GetMsgRequest request,
        io.grpc.stub.StreamObserver<com.github.sun5066.MsgResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.github.sun5066.SendMsgRequest,
                com.github.sun5066.MsgResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getGetMessageMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.github.sun5066.GetMsgRequest,
                com.github.sun5066.MsgResponse>(
                  this, METHODID_GET_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class ChatMessageStub extends io.grpc.stub.AbstractAsyncStub<ChatMessageStub> {
    private ChatMessageStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatMessageStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatMessageStub(channel, callOptions);
    }

    /**
     */
    public void sendMessage(com.github.sun5066.SendMsgRequest request,
        io.grpc.stub.StreamObserver<com.github.sun5066.MsgResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMessage(com.github.sun5066.GetMsgRequest request,
        io.grpc.stub.StreamObserver<com.github.sun5066.MsgResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatMessageBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChatMessageBlockingStub> {
    private ChatMessageBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatMessageBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatMessageBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.github.sun5066.MsgResponse sendMessage(com.github.sun5066.SendMsgRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.github.sun5066.MsgResponse> getMessage(
        com.github.sun5066.GetMsgRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatMessageFutureStub extends io.grpc.stub.AbstractFutureStub<ChatMessageFutureStub> {
    private ChatMessageFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatMessageFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatMessageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.sun5066.MsgResponse> sendMessage(
        com.github.sun5066.SendMsgRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_GET_MESSAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatMessageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatMessageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((com.github.sun5066.SendMsgRequest) request,
              (io.grpc.stub.StreamObserver<com.github.sun5066.MsgResponse>) responseObserver);
          break;
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage((com.github.sun5066.GetMsgRequest) request,
              (io.grpc.stub.StreamObserver<com.github.sun5066.MsgResponse>) responseObserver);
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

  private static abstract class ChatMessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatMessageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.sun5066.AddressBookProtos.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatMessage");
    }
  }

  private static final class ChatMessageFileDescriptorSupplier
      extends ChatMessageBaseDescriptorSupplier {
    ChatMessageFileDescriptorSupplier() {}
  }

  private static final class ChatMessageMethodDescriptorSupplier
      extends ChatMessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatMessageMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChatMessageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatMessageFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .addMethod(getGetMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
