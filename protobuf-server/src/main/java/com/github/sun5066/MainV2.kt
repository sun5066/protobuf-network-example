package com.github.sun5066

import io.grpc.ServerBuilder

class ServerV2 {

    private val chat = Chat()

    fun start() {
        val server = ServerBuilder.forPort(6666)
            .directExecutor()
            .addService(chat)
            .build()
            .start()

        server.awaitTermination()
    }
}

fun main() {
    ServerV2().start()
}