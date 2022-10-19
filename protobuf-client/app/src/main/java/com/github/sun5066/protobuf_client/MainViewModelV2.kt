package com.github.sun5066.protobuf_client

import android.util.Log
import androidx.lifecycle.ViewModel
import com.github.sun5066.ChatMessageGrpc
import com.github.sun5066.GetMsgRequest
import com.github.sun5066.SendMsgRequest
import io.grpc.ManagedChannelBuilder

class MainViewModelV2 : ViewModel() {
    private val clientA = Client()
    private val clientB = Client()

    init {
        getMessage()
    }

    fun sendA(text: String) {
        clientA.sendMessage(text)
        getMessage()
    }

    fun sendB(text: String) {
        clientA.sendMessage(text)
        getMessage()
    }

    private fun getMessage() {
        clientA.getMessage()
        clientB.getMessage()
    }

}

class Client {
    private val channel = ManagedChannelBuilder
        .forAddress("61.80.148.81", 6666)
        .usePlaintext()
        .directExecutor()
        .build()
    private val connector = ChatMessageGrpc.newBlockingStub(channel)

    fun sendMessage(text: String) {
        val msg = SendMsgRequest.newBuilder().setText(text).build()
        val msgResponse = connector.sendMessage(msg)
        Log.d("123123", "msgResponse: ${msgResponse.text}")
    }

    fun getMessage() {
        val msg = GetMsgRequest.newBuilder().setText("token").build()
        connector.getMessage(msg).forEach {
            Log.d("123123", "it: ${it.text}")
        }
    }
}