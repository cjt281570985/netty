package com.cjt.netty.tcp.chaibao;


import com.cjt.netty.h.ByteToLongDecoder;
import com.cjt.netty.h.LongToByteEncoder;
import com.cjt.netty.h.LongToStringDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();


        pipeline.addLast(new StudentDecoder());
        pipeline.addLast(new StudentEncoder());
        pipeline.addLast(new MyServerHandler());


    }
}
