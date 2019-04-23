package com.cjt.netty.hh;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-17 20:59
 */
public class ByteToLongDecoder2 extends ReplayingDecoder<Void> {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {

    System.out.println("ByteToLongDecoder2 invoke");
    System.out.println(msg.readableBytes());

    out.add(msg.readLong());

  }
}
