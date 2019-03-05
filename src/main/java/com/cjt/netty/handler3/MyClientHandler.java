package com.cjt.netty.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-03 21:05
 */
public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {

  private int count;

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    for (int i = 0; i < 10; i++) {
      String msgToSend = "send from client ";
      int length = msgToSend.getBytes("utf-8").length;
      byte[] content = msgToSend.getBytes("utf-8");

      ctx.writeAndFlush(new PersonProtocol(length, content));
    }
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
    int length = msg.getLength();
    byte[] content = msg.getContent();

    System.out.println("客户端接收到的消息: ");
    System.out.println("长度: " + length);
    System.out.println("内容:" + new String(content, Charset.forName("utf-8")));
    System.out.println("客户端接收到的消息数量: " + (++count));
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
