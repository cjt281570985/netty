package com.cjt.netty.h00;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-08 20:53
 */
public class ByteToLongDecoder extends ByteToMessageDecoder {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    System.out.println("ByteToLongDecoder...........");

    if (in.readableBytes() >= 8) {
      out.add(in.readLong());
    }
  }
}
