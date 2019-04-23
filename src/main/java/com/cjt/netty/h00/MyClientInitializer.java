package com.cjt.netty.h00;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-08 20:38
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline = ch.pipeline();

    pipeline.addLast(new ByteToLongDecoder2());
    pipeline.addLast(new LongToByteEncoder());
    pipeline.addLast(new MyClientHandler());
  }
}
