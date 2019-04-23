package com.cjt.netty.seven;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class MyServer7 {

    public static void main(String[] args) throws Exception {

        //事件循环组  (定义2个线程组)
        //bossGroup不断地从客户端接收连接,不对连接做任何处理, 把连接转给workerGroup,由它来处理,把结果返回给客户端
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            //ServerBootstrap 只是netty一个辅助类而已,设定相关属性参数而已
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)//.handler()
                    .handler(new LoggingHandler(LogLevel.INFO)) //会多产生控制台日志
                    .childHandler(new MyServerInitializer7());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            //优雅关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
