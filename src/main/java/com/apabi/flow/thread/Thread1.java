package com.apabi.flow.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread1 {
    static class Run implements Runnable{
//        volatile int i=0;
        AtomicInteger inc = new AtomicInteger();

        @Override
        public void run() {
            for (int n=0;n<10000;n++){
//               i=i+1;
                inc.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Run run=new Run();
//        Thread t1=new Thread(run);
//        t1.start();
//        Thread t2=new Thread(run);
//        t2.start();
//        Thread t3=new Thread(run);
//        t3.start();
//        t1.join();
//        t2.join();
//        t3.join();
        System.out.println((int)Math.pow(10,10));
//        System.out.println(run.inc);
    }
}
