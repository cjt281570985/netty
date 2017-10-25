package com.cjt.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {

    public static void main(String[] args) {

        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            int randomNum = new SecureRandom().nextInt(20);
            buffer.put(randomNum);
        }

        //又要读又要写,需要加入flip(), 让它实现状态的翻转
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }


    }
}
