package com.cjt.netty.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-04 11:00
 */
public class TestServer {

  public static void main(String[] args) {

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    ServerBootstrap serverBootstrap = new ServerBootstrap();
    serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new TestServerInitialzer());

    try {
      ChannelFuture channelFuture = serverBootstrap.bind(8888).sync();
      channelFuture.channel().closeFuture().sync();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();

    }

  }

}
