package com.cjt.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-02 20:19
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {


  //88例子使用
  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    //此处不需要检查
    /*if (in.readableBytes() >= 8) {
      out.add(in.readLong());
    }*/

    System.out.println("MyByteToLongDecoder2 decode invoked!");

    out.add(in.readLong());
  }
}
