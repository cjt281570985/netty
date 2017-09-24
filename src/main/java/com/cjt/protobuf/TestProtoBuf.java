package com.cjt.protobuf;

import java.util.Random;

public class TestProtoBuf {


    public static void main(String[] args) throws  Exception{

        DataInfo.Student student = DataInfo.Student.newBuilder().setName("吉米").setAge(28).setAddress("厦门").build();
        byte[] student2ByteArray = student.toByteArray();
        DataInfo.Student student1 = DataInfo.Student.parseFrom(student2ByteArray);

        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getAddress());


        for (int i = 0; i < 10; i++) {
            System.out.println( new Random().nextInt(3));;
        }
    }


}
