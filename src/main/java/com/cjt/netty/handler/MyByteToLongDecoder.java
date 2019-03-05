package com.cjt.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-02 15:48
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    System.out.println("decode invoked!");

    System.out.println(in.readableBytes());

    //读长整型必须判断
    if (in.readableBytes() >= 8) {
      out.add(in.readLong());
    }

  }
}
