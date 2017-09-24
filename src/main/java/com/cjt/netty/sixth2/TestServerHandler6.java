package com.cjt.netty.sixth2;

import com.cjt.netty.sixth2.MyDataInfo2;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

// MyDataInfo.Person 实际要传的类型
public class TestServerHandler6 extends SimpleChannelInboundHandler<MyDataInfo2.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo2.MyMessage msg) throws Exception {

        MyDataInfo2.MyMessage.DataType dataType = msg.getDataType();
        if(dataType == MyDataInfo2.MyMessage.DataType.PersonType){
            MyDataInfo2.Person person = msg.getPerson();

            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getAddress());
        }else if(dataType == MyDataInfo2.MyMessage.DataType.DogType){
            MyDataInfo2.Dog dog = msg.getDog();

            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        }else{
            MyDataInfo2.Cat cat = msg.getCat();

            System.out.println(cat.getName());
            System.out.println(cat.getCity());
        }
    }
}
