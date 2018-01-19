package com.cjt.nio;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TT {

    public static void main(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("nio3.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer);
        buffer.flip();

        while (buffer.remaining()>0) {
            byte b = buffer.get();
            System.out.print((char) b);
        }

    }
}
