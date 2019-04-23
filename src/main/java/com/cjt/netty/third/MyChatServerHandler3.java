package com.cjt.netty.third;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatServerHandler3 extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch->{
            if(channel != ch){
                ch.writeAndFlush(channel.remoteAddress() + " 发送的消息: " + msg + "\n");
            }else{
                ch.writeAndFlush("[自己] " + msg + "\n");
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + " 加入\n");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved");
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + " 离开\n");
        //channelGroup.remove(channel); netty会自动执行该操作, 无需要编写此行代码
        System.out.println("channelGroup size: " + channelGroup.size());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 上线\n");;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 下线\n");;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}