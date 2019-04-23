package com.cjt.netty.heartbeat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-11 1:29
 */
public class HeartServerInitializer extends ChannelInitializer<Channel> {

  @Override
  protected void initChannel(Channel ch) throws Exception {
    ChannelPipeline pipeline = ch.pipeline();

    pipeline.addLast(new IdleStateHandler(10, 17, 18, TimeUnit.SECONDS));
    pipeline.addLast(new HeartServerHandler());
  }
}
