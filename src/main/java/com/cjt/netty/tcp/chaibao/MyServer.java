package com.cjt.netty.tcp.chaibao;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class MyServer {
    public static void main(String[] args) throws Exception {
        //事件循环组  (定义2个线程组)
        //bossGroup不断地从客户端接收连接,不对连接做任何处理, 把连接转给workerGroup,由它来处理,把结果返回给客户端
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            //ServerBootstrap 只是netty一个辅助类而已,设定相关属性参数而已
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)//.handler()
                    .childHandler(new MyServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(5555).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            //优雅关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
