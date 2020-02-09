package com.chauyiu1994.grpc.client;

import com.chauyiu1994.grpc.User;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import com.chauyiu1994.grpc.userGrpc;

public class GRPCClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginRequest1 = User.LoginRequest.newBuilder().setUsername("RAM").setPassword("RAM").build();
        User.APIResponse response1 = userStub.login(loginRequest1);

        System.out.println(response1.getResponseMessage());

        User.LoginRequest loginRequest2 = User.LoginRequest.newBuilder().setUsername("RAM").setPassword("WRONG PASSWORD").build();
        User.APIResponse response2 = userStub.login(loginRequest2);

        System.out.println(response2.getResponseMessage());


    }
}
