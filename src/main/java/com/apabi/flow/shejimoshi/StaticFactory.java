package com.apabi.flow.shejimoshi;
//静态工厂
public class StaticFactory {


    public static Hello get1(){
        return new HelloService1();
    }
    public static Hello get2(){
        return new HelloService2();
    }

    public static void main(String[] args) {
        StaticFactory.get1().go();
        StaticFactory.get2().go();
    }
}
interface Hello{
    void go();
}
class HelloService1 implements Hello{

    @Override
    public void go() {
        System.out.println("a");
    }
}
class HelloService2 implements Hello{

    @Override
    public void go() {
        System.out.println("b");
    }
}
