package com.apabi.flow.shejimoshi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class jdkProxy {
    public static void main(String[] args) {
        Helloservice helloservice=new HelloServiceImpl();
        SimpleProy simpleProy=new SimpleProy(helloservice);
        Helloservice helloservice1=(Helloservice) Proxy.newProxyInstance(jdkProxy.class.getClassLoader(),helloservice.getClass().getInterfaces(),simpleProy);
        helloservice1.hello();
    }
}

interface Helloservice{
    void hello();
}
class HelloServiceImpl implements Helloservice{

    @Override
    public void hello() {
        System.out.println("aaa");
    }
}
class SimpleProy implements InvocationHandler {
    private Helloservice helloservice;

    public SimpleProy(Helloservice helloservice) {
        this.helloservice = helloservice;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("qiang");
        return method.invoke(helloservice,args);
    }
}