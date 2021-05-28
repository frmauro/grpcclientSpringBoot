package com.grpcclient.grpcclient;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import com.grpcserver.grpcserver.HelloRequest;
import com.grpcserver.grpcserver.HelloReply;
import com.grpcserver.grpcserver.GrpcserverServiceGrpc;

@SpringBootApplication
public class GrpcclientApplication {

	public static void main(String[] args) {
		//SpringApplication.run(GrpcclientApplication.class, args);

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8030).usePlaintext().build();

		GrpcserverServiceGrpc.GrpcserverServiceBlockingStub stub = GrpcserverServiceGrpc.newBlockingStub(channel);

		HelloReply helloReply = stub.sayHello(HelloRequest.newBuilder().setName("Francisco").build());

		System.out.println(helloReply.getMessage());

		channel.shutdown();

	}

}
