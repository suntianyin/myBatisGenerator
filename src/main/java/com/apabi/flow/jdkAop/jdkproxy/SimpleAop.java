package com.apabi.flow.jdkAop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleAop implements InvocationHandler {
    private Advice advice;

    public SimpleAop(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("work");
        return method.invoke(advice,args);
    }


}
