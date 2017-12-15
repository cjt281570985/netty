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

public class NioTest12 {

    //一个线程处理所有客户端的连接
    public static void main(String[] args) throws Exception{

        int[] ports = new int[5];

        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;

        //一个选择器持续保持打开的状态,直到我们调用它的close()
        Selector selector = Selector.open();

        //SelectionKey在NIO重要 返回所有事件的可能性,如有个连接过来了,是否可接收,如果接收了是否有数据读过来,是否有数据往外写,都可通过这个判断
        //一个可选择的通道的注册到Selector上,是通过SelectionKey来表示的
        //注册后信息的获得,客户端发过来的连接状态,事件是一个什么样的事件是通过SelectionKey来判断的
        //一个选择器Selector会维护三种SelectionKey集合,新创建selector的时候三个集合都是空的
        //1. key set 不能被修改 对应于当前注册到selector中的所有key  调用 keys()   在注册的同时会将一个key添加到集合中
        //2. selected-key set 只是我们感兴趣的那些,比如我只对读和写这2事件感兴趣,那selected-key set只包含读和写不包含连接和关闭
        //3. cancelled-key set 原来关注后面取消了,它的channel可能还没被取消注册, 那什么时候取消呢, 是在下一次在进行select的时候它才会被取消注册.
        //取消的key会被移除是在selection operations要(指的是select()方法)操作中.无论是在关闭它的channel或者调用SelectionKey的cancel方法

        //Selection is performed by the select(),select(long),selectNow()  methods
        //涉及三个步骤
        //1.在取消集合中的每个key都会被集合中移除掉,它的通道会被取消注册,会使得cancelled-key set 变为空集合
        //2.程序会查询底层的操作系统看看能不能更新 剩余的一些可用的channel的一些准备状况去更新他们, 以执行任何我们所感兴趣的对应的key
        //对于准备至少有这样一种操作的channel,下面2个动作会被执行
        //如果channel's key还没在selected-key set中那么将会添加进去, 它的ready-operation set 将被修改与精确标识的这些动作.之前准备的任何信息会被丢弃掉
        //如果channel's key已在selected-key set中那么它的ready-operation set会被修改,以被标识新的操作所产生,之前所记录的准备状态会被保留下来.
        //如果在这个步骤开始时键集合的所有键都拥有一个空的感兴趣的set,那么selected-key set或者是任何keys'ready-operation sets都不会被更新
        //3.如果在步骤2的时候,有任何被取消的key添加到cancelled-key中,那么它会在步骤1被处理

        //无论一个选择操作是等待阻塞一个或多个通道变成可用,以及如果是这样,那么等待多久,那么它们是这3个方法(select(),select(long),selectNow())的一个本质区别

        System.out.println(SelectorProvider.provider().getClass());
        System.out.println(sun.nio.ch.DefaultSelectorProvider.create().getClass());

        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);//配置非阻塞
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            serverSocket.bind(address);

            //42注册
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口: " + ports[i]);

        }

        while (true) {
            int numbers = selector.select(); //返回key的数量
            System.out.println("numbers: " + numbers);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys: " + selectionKeys);

            Iterator<SelectionKey> iter = selectionKeys.iterator();
            while (iter.hasNext()) {
                SelectionKey selectionKey = iter.next();

                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);//配置非阻塞

                    socketChannel.register(selector, SelectionKey.OP_READ);

                    iter.remove();
                    System.out.println("获得客户端的链接: " + socketChannel);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();

                    int bytesRead = 0;
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        byteBuffer.clear();
                        int read = socketChannel.read(byteBuffer);

                        if (read <= 0) {
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);

                        bytesRead += read;
                    }
                    System.out.println("读取: " + bytesRead + ", 来自于: " + socketChannel);
                    //一定要删除,否则下次会出问题
                    iter.remove();
                }


            }

        }


    }
}
