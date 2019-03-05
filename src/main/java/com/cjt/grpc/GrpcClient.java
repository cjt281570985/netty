package com.cjt.grpc;

import com.cjt.proto.MyRequest;
import com.cjt.proto.MyResponse;
import com.cjt.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {


    public static void main(String[] args) {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);

       //for (int i = 0; i < 10; i++) {
            MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());
            System.out.println(myResponse.getRealname());
       // }

    }
}
