package com.apabi.flow.thread;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"01").start();
        new Thread(()-> {
            synchronized (App.class){
                try {
                    App.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"02").start();
        new Thread(new Block(),"03").start();
        new Thread(new Block(),"04").start();
    }

    static class Block extends Thread{
        @Override
        public void run() {
            synchronized (Block.class){
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
