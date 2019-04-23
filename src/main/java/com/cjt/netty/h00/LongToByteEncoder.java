package com.cjt.netty.h00;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-08 21:23
 */
public class LongToByteEncoder extends MessageToByteEncoder<Long> {

  @Override
  protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
    System.out.println("LongToByteEncoder.......");
    System.out.println(msg);
    out.writeLong(msg);
  }
}
