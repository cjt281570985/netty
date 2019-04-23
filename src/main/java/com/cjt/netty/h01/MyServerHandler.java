package com.cjt.netty.h01;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-07 9:28
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println(ctx.channel().remoteAddress());
    System.out.println("msg: " + msg);

    ctx.writeAndFlush(9876L);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    super.exceptionCaught(ctx, cause);
  }
}
