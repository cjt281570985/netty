package com.cjt.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-11 1:16
 */
public class HeartServer {

  public static void main(String[] args) throws Exception {

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    ServerBootstrap serverBootstrap = new ServerBootstrap();
    serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new HeartServerInitializer());

    ChannelFuture channelFuture = serverBootstrap.bind(7777).sync();
    channelFuture.channel().closeFuture().sync();

    bossGroup.shutdownGracefully();
    workerGroup.shutdownGracefully();
  }

}
