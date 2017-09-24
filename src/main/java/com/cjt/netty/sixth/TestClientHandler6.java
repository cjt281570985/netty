package com.cjt.netty.sixth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestClientHandler6 extends SimpleChannelInboundHandler<MyDataInfo.Person>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //客户端向服务端发起的请求
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder().setName("云中月").setAge(26).setAddress("同安").build();
        ctx.channel().writeAndFlush(person);
    }
}
