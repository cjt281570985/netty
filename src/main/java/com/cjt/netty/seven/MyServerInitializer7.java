package com.cjt.netty.seven;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class MyServerInitializer7 extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //websocket基于http协议,所以要有http编解码器
        pipeline.addLast(new HttpServerCodec());
        //对写大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        //http聚合器,对httpMessage进行聚合,聚合成FullHttpRequest或FullHttpResponse
        //一个ChannelHandler，它将HttpMessage及其后续HttpContents聚合到一个单独的FullHttpRequest或FullHttpResponse中(取决于它是否用于处理请求或响应)，而不包含以下HttpContents。当您不想处理传输编码为“分块”的HTTP消息时，它非常有用。如果用于处理响应，则在ChannelPipeline中的HttpResponseDecoder之后插入该处理程序;如果用于处理请求，则在ChannelPipeline中的HttpRequestDecoder和HttpResponseEncoder之后插入该处理程序。
        pipeline.addLast(new HttpObjectAggregator(1024*24));

        // ========= 以上用于支持http协议 =========
        //websocket 服务器处理的协议,用于指定给客户端连接访问的路由: /ws
        //这个处理程序为您运行websocket服务器完成了所有繁重的工作。它处理websocket握手以及控制帧(关闭、Ping、Pong)的处理。文本和二进制数据帧被传递到管道中的下一个处理程序(由您实现)进行处理。参见io.netty.example.http.websocketx.html5.WebSocketServer。此处理程序的实现假定您只想运行websocket服务器，而不处理其他类型的HTTP请求(如GET和POST)。如果希望在一台服务器中同时支持HTTP请求和websockets，请参考io。
        //对于websocket来讲,都是以frames进行传输的,不同的数据类型对应的frames也不同
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        pipeline.addLast(new MyServerHandler7());


    }
}
