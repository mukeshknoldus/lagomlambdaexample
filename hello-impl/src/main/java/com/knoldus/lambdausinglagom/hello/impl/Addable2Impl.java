package com.knoldus.lambdausinglagom.hello.impl;

import com.knoldus.lambdausinglagom.hello.api.ResultPojo;

public class Addable2Impl {
    ResultPojo resultPojo = new ResultPojo();
    
public ResultPojo cal() {
    Addable2 addable2 = (a, b) -> {
        return a + b;
    };
    
    int result = addable2.add(5,6);
    resultPojo.setAdd(result);
    return resultPojo;
}
}
