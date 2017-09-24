package com.cjt.netty.sixth2;

import com.cjt.netty.sixth.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler6 extends SimpleChannelInboundHandler<MyDataInfo2.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo2.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //客户端向服务端发起的请求

        int randomInt = new Random().nextInt(3);
        System.out.println("randomInt: " + randomInt);
        MyDataInfo2.MyMessage message = null;
        if (0 == randomInt) {
            MyDataInfo2.Person person = MyDataInfo2.Person.newBuilder().setName("吉米").setAge(22).setAddress("厦门").build();
            message = MyDataInfo2.MyMessage.newBuilder().setDataType(MyDataInfo2.MyMessage.DataType.PersonType).setPerson(person).build();
        } else if (1 == randomInt) {
            MyDataInfo2.Dog dog = MyDataInfo2.Dog.newBuilder().setName("一只狗").setAge(2).build();
            message = MyDataInfo2.MyMessage.newBuilder().setDataType(MyDataInfo2.MyMessage.DataType.DogType).setDog(dog).build();
        } else {
            MyDataInfo2.Cat cat = MyDataInfo2.Cat.newBuilder().setName("一只猫").setCity("上海").build();
            message = MyDataInfo2.MyMessage.newBuilder().setDataType(MyDataInfo2.MyMessage.DataType.CatType).setCat(cat).build();
        }

        ctx.channel().writeAndFlush(message);
    }
}
