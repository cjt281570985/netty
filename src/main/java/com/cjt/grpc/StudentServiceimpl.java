package com.cjt.grpc;

import com.cjt.proto.MyRequest;
import com.cjt.proto.MyResponse;
import com.cjt.proto.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

public class StudentServiceimpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        //super.getRealNameByUsername(request, responseObserver);
        System.out.println("接收到客户端的信息: " + request.getUsername());

        //25 MyResponse 通过 proto方式构造
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }
}
