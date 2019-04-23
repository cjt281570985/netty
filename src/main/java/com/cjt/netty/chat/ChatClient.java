package com.cjt.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-10 21:25
 */
public class ChatClient {

  public static void main(String[] args) throws Exception {

    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChatClientInitializer());

      Channel channel = bootstrap.connect("localhost", 7777).sync().channel();

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      for (; ; ) {
        channel.writeAndFlush(br.readLine() + "\n");
      }


    } finally {
      eventLoopGroup.shutdownGracefully();
    }
  }

}
