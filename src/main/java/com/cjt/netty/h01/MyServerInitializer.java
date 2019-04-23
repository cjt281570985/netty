package com.cjt.netty.h01;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-07 9:22
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline = ch.pipeline();

    pipeline.addLast(new ByteToLongDecoder2());
    pipeline.addLast(new LongToStringDecoder());
    pipeline.addLast(new LongToByteEncoder());
    pipeline.addLast(new MyServerHandler());
  }
}
