package com.cjt.nio;

import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class NioClient {


    public static void main(String[] args) {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
