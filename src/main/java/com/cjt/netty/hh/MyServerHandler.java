package com.cjt.netty.hh;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

        System.out.println((++count) + "服务端接收到: " );
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        System.out.println(new String(bytes, Charset.forName("utf-8")));

        ctx.writeAndFlush(Unpooled.copiedBuffer("\n服务端回复" + count, Charset.forName("utf-8")));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();

    }
}
