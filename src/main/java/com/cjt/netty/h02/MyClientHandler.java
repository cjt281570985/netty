package com.cjt.netty.h02;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-07 9:34
 */
public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

  private int count;
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
    byte[] bytes = new byte[msg.readableBytes()];
    msg.readBytes(bytes);
    System.out.println("客户端收到的消息: " + new String(bytes, CharsetUtil.UTF_8));
    System.out.println("=============" + (++count) +"===============");
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    for (int i = 0; i < 10; i++) {
      ByteBuf byteBuf = Unpooled.copiedBuffer("客户端发送 - " + (i + 1), CharsetUtil.UTF_8);
      ctx.writeAndFlush(byteBuf);
    }
  }
}
