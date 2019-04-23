package com.cjt.netty.h00;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-08 20:40
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
    System.out.println("MyClientHandler.......channelRead0.....");

    System.out.println(msg);
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelActive..........");
    ctx.writeAndFlush(123L);
  }
}
