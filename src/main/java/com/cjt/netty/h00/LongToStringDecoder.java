package com.cjt.netty.h00;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-08 21:43
 */
public class LongToStringDecoder extends MessageToMessageDecoder<Long> {

  @Override
  protected void decode(ChannelHandlerContext ctx, Long msg, List<Object> out) throws Exception {
    System.out.println("LongToStringDecoder......");

    out.add("Long -> 吉米...");
  }
}
