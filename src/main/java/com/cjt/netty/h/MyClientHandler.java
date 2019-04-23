package com.cjt.netty.h;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

public class MyClientHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client output: " + msg);

        //此处如果再重复写入发送Long型, 会死循环
        //ctx.writeAndFlush(99L);
    }

    //客户端一启动,最先执行的是 channelActive()
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       ctx.writeAndFlush(123456L);
       // ctx.writeAndFlush(Unpooled.copiedBuffer("cjt5207890", Charset.forName("utf-8")));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
