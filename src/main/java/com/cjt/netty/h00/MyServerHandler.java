package com.cjt.netty.h00;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-08 20:34
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println("channelRead0........");

    System.out.println(msg);

    ctx.writeAndFlush(987L);
  }

}
