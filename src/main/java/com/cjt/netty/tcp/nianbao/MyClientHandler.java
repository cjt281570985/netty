package com.cjt.netty.tcp.nianbao;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        System.out.println((++count) + " - 客户端收到的信息: " + new String(bytes, Charset.forName("utf-8")));
    }

    //客户端一启动,最先执行的是 channelActive()
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 1; i <= 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer("send from client - " + i +"  \n\r", Charset.forName("utf-8")));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
