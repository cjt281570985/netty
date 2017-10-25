package com.cjt.nio;

import java.nio.ByteBuffer;

/**
 * ByteBuffer类型化put与get
 */
public class NioTest5 {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(15);
        buffer.putLong(500000L);
        buffer.putDouble(56.232);
        buffer.putChar('吉');
        buffer.putShort((short)2);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());


    }
}
