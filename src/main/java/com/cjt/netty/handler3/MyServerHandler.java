package com.cjt.netty.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-03 20:57
 */
public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {

  private int count;

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
    int length = msg.getLength();
    byte[] content = msg.getContent();

    System.out.println("服务端接收到的数据: ");
    System.out.println("长度: " + length);
    System.out.println("内容: " + new String(content, Charset.forName("utf-8")));
    System.out.println("服务端接收到的消息数量: " + (++count));

    String responseMessage = UUID.randomUUID().toString();
    int responseLength = responseMessage.getBytes("utf-8").length;
    byte[] responseContent = responseMessage.getBytes("utf-8");

    ctx.writeAndFlush(new PersonProtocol(responseLength, responseContent));
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
