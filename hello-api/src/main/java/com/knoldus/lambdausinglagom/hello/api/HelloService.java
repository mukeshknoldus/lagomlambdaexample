package com.knoldus.lambdausinglagom.hello.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

public interface HelloService extends Service {

  /**
   * Example: curl http://localhost:9000/api/hello/Alice
   */
  ServiceCall<NotUsed, ResultPojo> getCalculation(String id);

  
  @Override
  default Descriptor descriptor() {
    // @formatter:off
    return named("getCalculator").withCalls(Service.restCall(Method.GET,"/api/getcalculation/:id",  this::getCalculation)).withAutoAcl(true);
  }
}
