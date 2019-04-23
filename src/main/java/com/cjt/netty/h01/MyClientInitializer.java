package com.cjt.netty.h01;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-07 9:30
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline = ch.pipeline();

    pipeline.addLast(new ByteToLongDecoder());
    pipeline.addLast(new LongToByteEncoder());
    pipeline.addLast(new MyClientHandler());
  }
}
