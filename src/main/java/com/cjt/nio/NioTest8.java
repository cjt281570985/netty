package com.cjt.nio;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest8 {

    public static void main(String[] args) throws Exception{

        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output2.txt");

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        //ByteBuffer buffer = ByteBuffer.wrap(byte[] bytes);
        //可通过修改数组参数bytes 或 buffer来改变值,有些危险
        ByteBuffer buffer = ByteBuffer.allocateDirect(78);


        System.out.println("while limit: " + buffer.limit());
        System.out.println("while capacity: " + buffer.capacity());
        System.out.println("while position: " + buffer.position());

        while (true) {
            buffer.clear();
            int read = inputChannel.read(buffer);
            System.out.println("read: " + read);

            if (-1 == read) {
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);

            System.out.println("while limit: " + buffer.limit());
            System.out.println("while capacity: " + buffer.capacity());
            System.out.println("while position: " + buffer.position());
        }

        inputStream.close();
        outputStream.close();

    }
}
