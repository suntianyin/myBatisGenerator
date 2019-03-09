package com.apabi.flow.shejimoshi;
//适配器   将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}
class Source {
    public void method1() {
        System.out.println("this is original method!");
    }
}
interface Targetable {

    /* 与原类中的方法相同 */
    public void method1();

    /* 新类的方法 */
    public void method2();
}