package com.cjt.netty.h01;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-07 9:34
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
    System.out.println("客户端收到: " + msg);
    System.out.println(ctx.channel().remoteAddress());
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    ctx.writeAndFlush(123L);
  }
}
