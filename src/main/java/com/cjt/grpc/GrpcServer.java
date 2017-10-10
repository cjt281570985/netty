package com.cjt.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8899).addService(new StudentServiceimpl()).build().start();

        System.out.println("服务器启动!");

        //回调钩子
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("关闭JVM");
            GrpcServer.this.stop();
        }));

        System.out.println("执行到这里!");
    }


    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void awaitTermination() throws InterruptedException {
        if (server != null) {
            server.awaitTermination(3000, TimeUnit.MILLISECONDS);
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        GrpcServer server = new GrpcServer();

        server.start();
        server.awaitTermination();


    }

}
