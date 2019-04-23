package com.cjt.netty.h01;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-07 9:39
 */
public class LongToByteEncoder extends MessageToByteEncoder<Long> {

  @Override
  protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
    System.out.println("编码中...LongToByteEncoder");
    System.out.println(out.writeLong(msg));

  }
}
