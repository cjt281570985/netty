package com.cjt.netty.chat001;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-12 14:34
 */
public class Server {

  public static void main(String[] args) throws Exception {

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap serverBootstrap = new ServerBootstrap();
      serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
          .childHandler(new ServerInitializer());

      ChannelFuture channelFuture = serverBootstrap.bind(6789).sync();
      channelFuture.channel().closeFuture().sync();

    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }

  }

}
