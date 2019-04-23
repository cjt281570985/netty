package com.cjt.netty.tcp.chaibao;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;

public class MyClientHandler extends SimpleChannelInboundHandler<StudentProtocol> {

  private int count;

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, StudentProtocol msg) throws Exception {

    System.out.println("收到服务器的第" + (++count) + "次反馈!");
    System.out.println(msg.getLength());
    System.out.println(new String(msg.getContent(), Charset.forName("utf-8")));
    System.out.println("---------------" + count + "-----------------");
  }

  //客户端一启动,最先执行的是 channelActive()
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    for (int i = 1; i <= 10; i++) {
      String s = i + "客户端发送";
      StudentProtocol protocol = new StudentProtocol(s.getBytes(Charset.forName("utf-8")).length, s.getBytes(Charset.forName("utf-8")));
      ctx.writeAndFlush(protocol);
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
