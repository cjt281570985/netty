package com.cjt.netty.tcp.chaibao;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

public class MyServerHandler extends SimpleChannelInboundHandler<StudentProtocol> {

  private int count;

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, StudentProtocol msg) throws Exception {
    System.out.println(++count);
    System.out.println("服务端接收到的消息: ");
    System.out.println("长度: " + msg.getLength());
    System.out.println("内容: " + new String(msg.getContent(), Charset.forName("utf-8")));

    System.out.println("--------接收到的数量------" + count + "------------------");
    String reMsg = "cjt5566";
    ctx.writeAndFlush(new StudentProtocol(reMsg.getBytes(Charset.forName("utf-8")).length, reMsg.getBytes(Charset.forName("utf-8"))));
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();

  }
}
