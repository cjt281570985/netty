package com.cjt.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {


    public static void main(String[] args) throws IOException {

        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();

        //当一个TCP连接关闭的时候,连接可能还保持着一个超时的状态保持一段时间,
        //有一个应用要绑定某个超时状态的端口号,需要设置下面参数(在上次绑定前设置)
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            //默认是阻塞 configureBlocking true
            socketChannel.configureBlocking(true);

            int readCount = 0;

            while (-1 != readCount) {
                try {
                    readCount = socketChannel.read(byteBuffer);
                } catch (Exception e){
                    e.printStackTrace();
                }

                //每次读完还需要将 byteBuffer归位到起始位置
                byteBuffer.rewind();
            }

        }

    }
}
