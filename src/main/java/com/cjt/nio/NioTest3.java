package com.cjt.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {

    public static void main(String[] args) throws Exception{

        FileOutputStream fileOutputStream = new FileOutputStream("nio3.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        byte[] messages = "yzy cjt jimmy".getBytes();

        for (int i = 0; i < messages.length ; i++) {
            buffer.put(messages[i]);
        }

        buffer.flip();

        fileChannel.write(buffer);
        fileOutputStream.close();

    }
}
