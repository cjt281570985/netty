package com.cjt.netty.tcp.chaibao;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-17 9:13
 */
public class StudentEncoder extends MessageToByteEncoder<StudentProtocol> {


  @Override
  protected void encode(ChannelHandlerContext ctx, StudentProtocol msg, ByteBuf out)  throws Exception {
    System.out.println("StudentEncoder invoke");

    out.writeInt(msg.getLength());
    out.writeBytes(msg.getContent());

  }
}
