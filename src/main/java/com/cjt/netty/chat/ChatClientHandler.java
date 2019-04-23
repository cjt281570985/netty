package com.cjt.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-10 21:36
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {


  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println(msg);

  }

}
