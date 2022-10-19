package com.github.sun5066.protobuf_client

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.sun5066.person
import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInitializer
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.util.CharsetUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModelV3 : ViewModel() {

    private val eventLoopGroup by lazy { NioEventLoopGroup() }
    private val clientInitializer by lazy { ClientInitializer() }

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val bootstrap = Bootstrap()
                bootstrap
                    .group(eventLoopGroup)
                    .channel(NioSocketChannel::class.java)
                    .handler(clientInitializer)

                val channelFuture = bootstrap.connect("61.80.148.81", 6666).sync()
                channelFuture.channel().closeFuture().sync()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                eventLoopGroup.shutdownGracefully()
            }
        }
    }

    fun send() {
        clientInitializer.send()
    }

}

class ClientInitializer : ChannelInitializer<SocketChannel>() {

    private val simpleClientHandler by lazy { SimpleClientHandler() }

    fun send() {
        simpleClientHandler.send()
    }

    override fun initChannel(ch: SocketChannel?) {
        if (ch != null) {
            val pipeline = ch.pipeline()
            pipeline.addLast(StringDecoder(CharsetUtil.UTF_8))
            pipeline.addLast(StringEncoder())
            pipeline.addLast(simpleClientHandler)
        }
    }
}

class SimpleClientHandler : SimpleChannelInboundHandler<String>() {

    private var ctx: ChannelHandlerContext? = null

    fun send() {
        val person = person {
            name = "hello"
            id = 123
            email = "alstjr4434@naver.com"
        }

        val data = person.toString()
            .encrypt("123")
            .replace("\r", "")
            .replace("\n", "")

        Log.d("123123", "data: $data")
        ctx?.channel()?.writeAndFlush(data)
    }

    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        Log.d("123123", "2msg: $msg")
    }

    override fun channelRead0(ctx: ChannelHandlerContext?, msg: String?) {
        Log.d("123123", "1msg")
        Log.d("123123", "1msg: $msg")
    }

    override fun channelActive(ctx: ChannelHandlerContext?) {
        this.ctx = ctx
        send()
    }
}