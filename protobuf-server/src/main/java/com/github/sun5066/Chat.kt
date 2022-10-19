package com.github.sun5066

import io.grpc.stub.StreamObserver

/**
 * MainV2
 * */
class Chat : ChatMessageGrpc.ChatMessageImplBase() {

    private var msg = ""

    override fun getMessage(request: GetMsgRequest?, responseObserver: StreamObserver<MsgResponse>?) {
        val response = msgResponse {
            text = "수신 : $msg"
        }
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
        println("get: " + request?.text)
    }

    override fun sendMessage(request: SendMsgRequest?, responseObserver: StreamObserver<MsgResponse>?) {
        msg = request?.text ?: ""
        responseObserver?.onNext(
            msgResponse {
                text = "송신 : $msg"
            }
        )
        responseObserver?.onCompleted()
        println("send: " + request?.text)
    }

}