package com.knoldus.lambdausinglagom.hello.impl;

import javax.inject.Inject;

import akka.NotUsed;
import akka.japi.Pair;
import com.knoldus.lambdausinglagom.hello.api.HelloService;
import com.knoldus.lambdausinglagom.hello.api.ResultPojo;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.ResponseHeader;
import com.lightbend.lagom.javadsl.server.HeaderServiceCall;

import java.util.concurrent.CompletableFuture;

/**
 * Implementation of the HelloService.
 */
public class HelloServiceImpl implements HelloService {

  private final Addable2Impl addable2Impl;

  @Inject
  public HelloServiceImpl(Addable2Impl addable2Impl){
    this.addable2Impl = addable2Impl;
  }
  
  @Override
  /*public ServiceCall<NotUsed, ResultPojo> getCalculation(String id) {
    return null;
  }*/
  public HeaderServiceCall<NotUsed,ResultPojo> getCalculation(String id){
    return (requestHeader,response)->{
      return CompletableFuture.completedFuture(new Pair(ResponseHeader.OK,addable2Impl.cal()));
    };
  }
}
