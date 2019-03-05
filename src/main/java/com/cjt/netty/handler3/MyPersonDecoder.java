package com.cjt.netty.handler3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-03 17:14
 */
public class MyPersonDecoder extends ReplayingDecoder<Void> {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    System.out.println("--------------------------------");
    System.out.println("MyPersonDecoder decode invoked!");

    int length = in.readInt();

    byte[] content = new byte[length];
    in.readBytes(content);

    out.add(new PersonProtocol(length, content));
  }
}
