package com.apabi.flow.thread;

public class InterruptDemo {
    private static volatile boolean flag=true;
    public static void main(String[] args) {
           Thread t=new Thread(()->{
               while(flag){
//                while(!Thread.currentThread().isInterrupted()){
                   System.out.println("TODO");
//                }
               }
           });
           t.start();
//        flag=false;
        t.interrupt();
    }
}
