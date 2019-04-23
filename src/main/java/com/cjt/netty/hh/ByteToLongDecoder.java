package com.cjt.netty.hh;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-17 20:59
 */
public class ByteToLongDecoder extends ByteToMessageDecoder {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {

    System.out.println("ByteToLongDecoder invoke");
    System.out.println(msg.readableBytes());

    if (msg.readableBytes() >= 8) {
      out.add(msg.readLong());
    }

  }
}
