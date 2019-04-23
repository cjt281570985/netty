package com.cjt.netty.h;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-16 20:48
 */
public class LongToStringDecoder extends MessageToMessageDecoder<Long> {

  @Override
  protected void decode(ChannelHandlerContext ctx, Long msg, List<Object> out) throws Exception {
    System.out.println("LongToStringDecoder invoke!");
    System.out.println(msg);
    out.add(msg.toString());
  }
}
