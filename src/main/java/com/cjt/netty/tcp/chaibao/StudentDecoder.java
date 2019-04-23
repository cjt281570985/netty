package com.cjt.netty.tcp.chaibao;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-17 9:12
 */
public class StudentDecoder extends ReplayingDecoder<Void> {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    System.out.println("StudentDecoder invoke");

    int length = in.readInt();
    byte[] content = new byte[length];
    in.readBytes(content);

    out.add(new StudentProtocol(length, content));

  }
}
