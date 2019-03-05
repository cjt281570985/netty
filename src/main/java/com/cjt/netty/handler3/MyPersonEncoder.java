package com.cjt.netty.handler3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-03 20:53
 */
public class MyPersonEncoder extends MessageToByteEncoder<PersonProtocol> {

  @Override
  protected void encode(ChannelHandlerContext ctx, PersonProtocol msg, ByteBuf out) throws Exception {
    System.out.println("MyPersonEncoder encode invoked!");

    out.writeInt(msg.getLength());
    out.writeBytes(msg.getContent());
  }
}
