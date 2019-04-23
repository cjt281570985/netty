package com.cjt.netty.hh;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-17 20:57
 */
public class LongToByteEncoder extends MessageToByteEncoder<Long> {

  @Override
  protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {

    System.out.println("LongToByteEncoder invoke");

    out.writeLong(msg);

  }
}
