package com.apabi.flow.shejimoshi;
//懒汉
public class singleton {
    private volatile static singleton s;

    private singleton() {
    }

    public static singleton getInstance(){
        if(s==null){
            synchronized (singleton.class){
                if(s==null){
                    s=new singleton();
                }
            }
        }
        return s;
    }

}
class  singleton2{
//    private static singleton2 s=new singleton2();
    private static class Singleton2Hold{
        private static final singleton2 singleton2=new singleton2();//达到lazy loading效果  因为SingletonHolder类没有被主动使用
    }
    private singleton2() {
    }
    public static singleton2 getInstance(){
        return Singleton2Hold.singleton2;
    }
}