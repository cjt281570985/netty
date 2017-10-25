package com.cjt.nio;


import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

//用的不多
public class NioTest10 {

    public static void main(String[] args) throws Exception{

        RandomAccessFile randomAccessFile = new RandomAccessFile("NioText10.txt" , "rw");

        FileChannel channel = randomAccessFile.getChannel();

        FileLock fileLock = channel.lock(3, 6, true);//true共享锁,false排插锁
        System.out.println("valid: " + fileLock.isValid());
        System.out.println("lock type: " + fileLock.isShared());
    }
}
