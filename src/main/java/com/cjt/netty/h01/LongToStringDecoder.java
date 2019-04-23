package com.cjt.netty.h01;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-07 13:53
 */
public class LongToStringDecoder extends MessageToMessageDecoder<Long> {

  @Override
  protected void decode(ChannelHandlerContext ctx, Long msg, List<Object> out) throws Exception {
    System.out.println("解码.....LongToStringDecoder");

    out.add("吉米..");
  }
}
