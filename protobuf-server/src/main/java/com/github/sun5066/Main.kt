package com.github.sun5066

import java.io.BufferedInputStream
import java.net.ServerSocket
import java.net.Socket
import java.util.*
import kotlin.concurrent.thread

class Server {
    private val serverSocket = ServerSocket(6666)

    fun handleConnection() {
        thread {
            while (true) {
                val socket = serverSocket.accept()
                println("${socket.localAddress} connect!")
                ConnectionHandler(socket).run()
            }
        }
    }

}

class ConnectionHandler(
    private val socket: Socket
) : Runnable {

    private val reader = Scanner(socket.getInputStream())
    private val writer = socket.getOutputStream()

    override fun run() {
        thread { disconnected() }
        thread { send() }

        while (true) {
            try {
                val data = reader.nextLine()
                println(data)
            } catch (e: Exception) {
                socket.close()
                break
            }
        }
    }

    val scanner = System.`in`
    val read = BufferedInputStream(scanner)
    private fun send() {
        while (true) {
            val text = read.bufferedReader().readLine()
            val msg = person {
                name = text
                id = 112
                email = "test@gmail.com"
            }
            val data = msg.toString().encrypt("123")
            writer.write((data + '\n').toByteArray())
            writer.flush()
        }
    }

    private fun disconnected() {
        while (true) {
            if (socket.isClosed) {
                reader.close()
                writer.close()
                socket.close()
            }
        }
    }

}


fun main() {
    Server().handleConnection()
}
