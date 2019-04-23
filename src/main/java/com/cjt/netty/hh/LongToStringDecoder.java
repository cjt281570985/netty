package com.cjt.netty.hh;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-17 21:24
 */
public class LongToStringDecoder extends MessageToMessageDecoder<Long> {

  @Override
  protected void decode(ChannelHandlerContext ctx, Long msg, List<Object> out) throws Exception {
    System.out.println("LongToStringDecoder invoke");


  }
}
