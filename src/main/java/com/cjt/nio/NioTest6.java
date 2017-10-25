package com.cjt.nio;

import java.nio.ByteBuffer;

/**
 * Slice Buffer 与原有buffer共享相同的底层数组
 */
public class NioTest6 {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity() ; i++) {
            buffer.put(( byte ) i);
        }

        buffer.position(2);
        buffer.limit(6);

        ByteBuffer sliceBuffer = buffer.slice();// 截取共享的子序列 会同步修改

        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get(i);
            b *= 2;
            sliceBuffer.put(i, b);
        }


        //shift + Esc 关闭控制台
        //点错方法可以重新点,再按tab
        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

    }
}
