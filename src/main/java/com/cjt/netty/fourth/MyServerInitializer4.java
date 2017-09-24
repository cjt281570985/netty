package com.cjt.netty.fourth;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;


public class MyServerInitializer4 extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //空闲状态检测 IdleStateHandler 在一定的时间间隔内没有读写...
        pipeline.addLast(new IdleStateHandler(5,7,3, TimeUnit.SECONDS));

        pipeline.addLast(new MyServerHandler4());

    }
}
