package com.cjt.netty.h01;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-07 13:01
 */
public class ByteToLongDecoder2 extends ReplayingDecoder<Void> {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    System.out.println("解码ByteToLongDecoder2.........");

    out.add(in.readLong());

  }
}
