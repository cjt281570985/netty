package com.cjt.netty.h;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-16 10:29
 */
public class LongToByteEncoder extends MessageToByteEncoder<Long> {


  @Override
  protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {

    System.out.println("Encoder invoked!");

    System.out.println("msg: " + msg);

    out.writeLong(msg);


  }
}
