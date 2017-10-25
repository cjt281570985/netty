package com.cjt.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {

    public static void main(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("nio2.txt");

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        fileChannel.read(buffer);

        buffer.flip();

        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            System.out.print((char)b);
        }

        fileInputStream.close();

    }
}
