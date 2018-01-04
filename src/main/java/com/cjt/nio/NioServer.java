package com.cjt.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class NioServer {

    private static Map<String, SocketChannel> clientMap = new HashMap<>();
    //43
    public static void main(String[] args) throws Exception {
        //前4行 样板代码,基本上不可省
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //一定要设置成非阻塞
        serverSocketChannel.configureBlocking(false);
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        //将Channel对象注册到selector选择器对象上
        //serverSocketChannel关注的是连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            try {
                selector.select();//一直阻塞在那里,等到它所监听的key有事件发生的时候
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                selectionKeys.forEach(selectionKey -> {
                    final SocketChannel client; //serverSocketChannel关注的是数据的读取事件

                    try {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel();
                            //此处对于ServerSocketChannel用不上了,转而建立新的连接client
                            client = server.accept();
                            client.configureBlocking(false);//也是配置非阻塞
                            client.register(selector, SelectionKey.OP_READ);

                            String key = "[" + UUID.randomUUID().toString() + "]";

                            clientMap.put(key,client);
                        } else if (selectionKey.isReadable()) {
                            client = (SocketChannel)selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                            int count = client.read(readBuffer);
                            if (count > 0) {
                                readBuffer.flip();

                                Charset charset = Charset.forName("utf-8");
                                String receivedMessage = String.valueOf(charset.decode(readBuffer).array());

                                System.out.println(client + ": " + receivedMessage);

                                String senderKey = null;
                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    if (client == entry.getValue()) {
                                        senderKey = entry.getKey();
                                        break;
                                    }
                                }

                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    SocketChannel value = entry.getValue();

                                    ByteBuffer writeByffer = ByteBuffer.allocate(1024);
                                    writeByffer.put((senderKey + ": " + receivedMessage).getBytes());

                                    writeByffer.flip();

                                    value.write(writeByffer);
                                }


                            }

                        }



                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                selectionKeys.clear();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
