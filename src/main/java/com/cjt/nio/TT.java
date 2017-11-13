package com.cjt.nio;

import java.nio.ByteBuffer;

public class TT {

    public static void main(String[] args) throws Exception{


        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        for (int i = 0; i < byteBuffer.capacity() ; i++) {
            byteBuffer.put(( byte ) i);
        }

        byteBuffer.position(3);
        byteBuffer.limit(5);

        ByteBuffer sub = byteBuffer.slice();

        while (sub.hasRemaining()) {
            System.out.println(sub.get());
        }

        for (int i = 0; i < sub.capacity() ; i++) {
            byte b = sub.get(i);
            b *= 2;
            sub.put(i,  b);
        }

        System.out.println("-----");
        byteBuffer.clear();
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }




    }
}
