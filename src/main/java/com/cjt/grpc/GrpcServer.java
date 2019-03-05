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
//        Runtime.getRuntime().addShutdownHook(new Thread(()->{
//            System.out.println("关闭JVM");
//            GrpcServer.this.stop();
//        }));
//        System.out.println("执行到这里!");
    }

    private void stop() {
        if (this.server != null) {
            this.server.shutdown();
        }
    }
    private void awaitTermination() throws InterruptedException {
        if (this.server != null) {
            //server.awaitTermination();
            this.server.awaitTermination(80000, TimeUnit.MILLISECONDS);
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        //不让服务器立刻停止
        grpcServer.awaitTermination();
    }
}
