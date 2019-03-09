package com.apabi.flow.jdkAop;

import java.lang.reflect.Proxy;

public class SimpleAop {
    public static Object invoke(Object bean,Advice advice){
        return Proxy.newProxyInstance(SimpleAop.class.getClassLoader(),bean.getClass().getInterfaces(),advice);
    }
}
