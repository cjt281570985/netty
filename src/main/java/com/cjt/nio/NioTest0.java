package com.cjt.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest0 {

    public static void main(String[] args) {

        IntBuffer buffer = IntBuffer.allocate(10);

        System.out.println("init limit: " + buffer.limit());       //10
        System.out.println("init capacity: " + buffer.capacity()); //10
        System.out.println("init position: " + buffer.position()); //0

        for (int i = 0; i < 5; i++) {
            int randomNum = new SecureRandom().nextInt(20);
            buffer.put(randomNum);
        }

        System.out.println("before filp limit: " + buffer.limit());       //10
        System.out.println("before filp capacity: " + buffer.capacity()); //10
        System.out.println("before filp position: " + buffer.position()); //5
        System.out.println("--------------------------------");
        //又要读又要写,需要加入flip(), 让它实现状态的翻转
        buffer.flip();
        System.out.println("after filp limit: " + buffer.limit());

        while (buffer.hasRemaining()) {

            System.out.println("while limit: " + buffer.limit());
            System.out.println("while capacity: " + buffer.capacity());
            System.out.println("while position: " + buffer.position());


            System.out.println(buffer.get());
        }


    }
}
