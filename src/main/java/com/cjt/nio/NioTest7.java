package com.cjt.nio;

import java.nio.ByteBuffer;


/**
 * 只读 Buffer  通过该方法转换buffer.asReadOnlyBuffer(); 不能将只读的转成可操作的
 */
public class NioTest7 {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        //class java.nio.HeapByteBuffer
        System.out.println(buffer.getClass());

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(( byte ) i);
        }

        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        //class java.nio.HeapByteBufferR
        System.out.println(readOnlyBuffer.getClass());

        readOnlyBuffer.position(0);
        //readOnlyBuffer.put(( byte ) 3);

    }
}
