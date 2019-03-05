package com.cjt.nio;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

public class NioTest1222 {
    //一个线程处理所有客户端的连接
    public static void main(String[] args) throws Exception {
        int[] ports = new int[3];
        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;

        Selector selector = Selector.open();
        System.out.println(SelectorProvider.provider().getClass());
        System.out.println(sun.nio.ch.DefaultSelectorProvider.create().getClass());

        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);//配置非阻塞
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(address);
            //42注册
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口: " + ports[i]);
        }

        while (true) {
            int numbers = selector.select(); //返回key的数量
            System.out.println("numbers1: " + numbers);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys1: " + selectionKeys);

            Iterator<SelectionKey> iter = selectionKeys.iterator();
            while (iter.hasNext()) {
                SelectionKey selectionKey = iter.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);//配置非阻塞
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    //将其从key中移除,否则还会继续监听此事件.  此链接已经创建
                    iter.remove();
                    System.out.println("获得客户端的链接1: " + socketChannel);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();

                    int bytesRead = 0;
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        byteBuffer.clear();
                        int read = socketChannel.read(byteBuffer);
                        if (read <= 0) {
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        bytesRead += read;
                    }
                    System.out.println("读取1: " + bytesRead + ", 来自于: " + socketChannel);
                    //一定要删除,否则下次会出问题
                    iter.remove();
                }
            }
        }
    }
}
