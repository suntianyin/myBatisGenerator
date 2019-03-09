package com.apabi.flow.shejimoshi;
//装饰器模式


public class Decrator implements a{

    private a aa;

    public Decrator(com.apabi.flow.shejimoshi.a a) {
        this.aa = a;
    }

    @Override
    public void aaa() {
        System.out.println("Decrator");
        aa.aaa();
        System.out.println("Decrator");
    }

    public static void main(String[] args) {
        a a=new b();
        a a1=new Decrator(a);
        a1.aaa();
    }
}

interface a{
    void aaa();
}
class b implements a{

    @Override
    public void aaa() {
        System.out.println("bbb");
    }
}
