package com.cjt.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-02 16:03
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {

  @Override
  protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
    System.out.println("encode invoked!");

    System.out.println(msg);
    out.writeLong(msg);
  }
}
