package com.cjt.netty.test;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-04 11:16
 */
public class TestServerInitialzer extends ChannelInitializer<SocketChannel> {


  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline = ch.pipeline();

    pipeline.addLast(new HttpServerCodec());
    pipeline.addLast(new TestHttpServerHandle());
  }
}
