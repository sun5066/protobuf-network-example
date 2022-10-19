package com.github.sun5066

import com.google.protobuf.TextFormat
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInitializer
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.DefaultChannelGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.timeout.IdleState
import io.netty.handler.timeout.IdleStateEvent
import io.netty.util.CharsetUtil
import io.netty.util.concurrent.GlobalEventExecutor
import kotlin.concurrent.thread

fun main() {
    ServerV3().init()
}

class ServerV3 {
    private val serverBootstrap by lazy { ServerBootstrap() }

    fun init() {
        thread {
            val eventLoop = NioEventLoopGroup()
            try {
                serverBootstrap
                    .group(eventLoop)
                    .channel(NioServerSocketChannel::class.java)
                    .childHandler(ServerInitializer())

                val channelFuture = serverBootstrap.bind(6666).sync()
                channelFuture.channel().closeFuture().sync()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                eventLoop.shutdownGracefully()
            }
        }
    }
}

class ServerInitializer : ChannelInitializer<SocketChannel>() {

    private val channelGroup = DefaultChannelGroup(GlobalEventExecutor.INSTANCE)

    override fun initChannel(ch: SocketChannel) {
        val pipeline = ch.pipeline()
        pipeline.addLast(StringDecoder(CharsetUtil.UTF_8))
        pipeline.addLast(StringEncoder())
        pipeline.addLast(SimpleServerHandler(channelGroup))
    }

}

class SimpleServerHandler(private val channelGroup: ChannelGroup) : SimpleChannelInboundHandler<String>() {

    override fun channelRegistered(ctx: ChannelHandlerContext?) {
        println("접속")
        channelGroup.add(ctx?.channel())
    }

    override fun channelRead0(ctx: ChannelHandlerContext?, msg: String?) {

    }

    override fun channelUnregistered(ctx: ChannelHandlerContext?) {
        println("나감")
        channelGroup.remove(ctx?.channel())
    }

    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val data = msg.toString()
        println("key: $data")

        val decryptData = data.decrypt("123")
        val builder = Person.newBuilder()
        TextFormat.getParser().merge(decryptData, builder)
        val person = builder.build()
        println(person)
    }

    override fun channelReadComplete(ctx: ChannelHandlerContext?) {
        ctx?.flush()
    }

}

class ServerHeartBeatHandler : ChannelDuplexHandler() {
    override fun userEventTriggered(ctx: ChannelHandlerContext?, evt: Any?) {
        if (evt is IdleStateEvent) {
            if (evt.state() == IdleState.READER_IDLE) {
                ctx?.close()
            } else if (evt.state() == IdleState.WRITER_IDLE) {
                val person =
                    Person.newBuilder().setName("hi zz").setId(234).setEmail("alstjr4434@gmail.com")
                        .build()
                ctx?.channel()?.writeAndFlush(person)
            }
        }
    }
}