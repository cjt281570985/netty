package com.cjt.netty.thrift;

import com.cjt.thrift.generated.PersonService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class ThriftServer {


    public static void main(String[] args) throws  Exception{

        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899); //异步非阻塞
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());//协议层上所用到的对象
        arg.transportFactory(new TFramedTransport.Factory());//传输层所用到的对象
        arg.processorFactory(new TProcessorFactory(processor));


        TServer server = new THsHaServer(arg);

        System.out.println("Thrift Server Started!");

        server.serve(); //此方法为死循环
    }
}
