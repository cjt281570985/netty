package com.cjt.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-10 21:36
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

  private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    channelGroup.forEach(ch -> {
      if (ctx.channel() == ch) {
        ch.writeAndFlush("自己: " + msg + "\n");
      } else {
        ch.writeAndFlush(ctx.channel().remoteAddress() + ": " + msg + "\n");
      }
    });
  }

  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    System.out.println("handlerAdded: " + channelGroup.size());
    channelGroup.writeAndFlush("[服务器]" + ctx.channel().remoteAddress() + "加入!\n");

    channelGroup.add(ctx.channel());
  }

  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    System.out.println("handlerRemoved: " + channelGroup.size());

    channelGroup.writeAndFlush("[服务器]" + ctx.channel().remoteAddress() + "离开!\n");
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelActive: " + channelGroup.size());

    System.out.println(ctx.channel().remoteAddress() + "上线\n");
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelInactive: " + channelGroup.size());

    System.out.println(ctx.channel().remoteAddress() + "下线\n");
  }

  @Override
  public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelRegistered");
    super.channelRegistered(ctx);
  }

  @Override
  public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelUnregistered");
    super.channelUnregistered(ctx);
  }

}
