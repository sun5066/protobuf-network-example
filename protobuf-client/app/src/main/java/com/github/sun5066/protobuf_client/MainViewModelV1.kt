package com.github.sun5066.protobuf_client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.sun5066.Person
import com.google.protobuf.TextFormat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.io.BufferedInputStream
import java.net.Socket

class MainViewModelV1 : ViewModel() {
    private val socket by lazy { Socket("61.80.148.81", 6666) }
    private val reader by lazy { BufferedInputStream(socket.getInputStream()) }
//    private val writer by lazy { socket.getOutputStream() }

    val socketReaderFlow by lazy {
        flow {
            while (true) {
                val readData = reader.bufferedReader().readLine()
                val data = readData.decrypt("123")
                val builder = Person.newBuilder()
                TextFormat.getParser().merge(data, builder)
                val person = builder.build()
                emit(SocketReadState.ReadData(person))
            }
        }.catch {
            it.printStackTrace()
            close()
        }.flowOn(Dispatchers.IO).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = SocketReadState.UnInit,
        )
    }

    override fun onCleared() {
        close()
        super.onCleared()
    }

    private fun close() {
        socket.close()
    }

}

sealed interface SocketReadState {

    object UnInit : SocketReadState

    data class ReadData(
        val data: Person
    ) : SocketReadState

}