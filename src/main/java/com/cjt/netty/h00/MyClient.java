package com.cjt.netty.h00;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-08 20:18
 */
public class MyClient {

  public static void main(String[] args) throws Exception {

    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
          .handler(new MyClientInitializer());
      ChannelFuture channelFuture = bootstrap.connect("localhost", 7788).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      eventLoopGroup.shutdownGracefully();
    }

  }

}
