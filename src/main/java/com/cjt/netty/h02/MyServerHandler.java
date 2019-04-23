package com.cjt.netty.h02;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-07 9:28
 */
public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

  private int count;
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
    byte[] bytes = new byte[msg.readableBytes()];
    msg.readBytes(bytes);

    System.out.println("服务端收到的消息: " + new String(bytes, CharsetUtil.UTF_8));

    System.out.println("=================" + (++count) +"=====================");
    ByteBuf byteBuf = Unpooled.copiedBuffer("吉米" + count, CharsetUtil.UTF_8);
    ctx.writeAndFlush(byteBuf);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    super.exceptionCaught(ctx, cause);
  }
}
