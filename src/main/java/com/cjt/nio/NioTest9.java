package com.cjt.nio;


import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest9 {

    //39   内存映射文件
    public static void main(String[] args) throws Exception{

        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest9.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        //在内存中修改数据   位于堆外内存的
        //查看修改后的数据需要在外面打开文件
        mappedByteBuffer.put(0, ( byte ) 'a');
        mappedByteBuffer.put(3, ( byte ) 'b');

        randomAccessFile.close();

    }
}
