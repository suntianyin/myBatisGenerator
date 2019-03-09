package com.apabi.flow.jdkAop.jdkproxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Advice advice=new AdviceService();
        SimpleAop simpleAop=new SimpleAop(advice);
        Advice a = (Advice) Proxy.newProxyInstance(Test.class.getClassLoader(), advice.getClass().getInterfaces(), simpleAop);
        a.goHome();
    }
}
