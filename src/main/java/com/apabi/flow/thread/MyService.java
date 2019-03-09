package com.apabi.flow.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class MyService {

    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock lock1 =new ReentrantReadWriteLock();
    private Condition condition=lock.newCondition();
    public void testMethod() {
        
        try {
            lock.lock();
            System.out.println("开始wait");
            condition.await();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName()
                        + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }
    public void signal()
    {
        try
        {
            lock.lock();
            condition.signal();
        }
        finally
        {
            lock.unlock();
        }
    }
    public void read() {
        try {
            try {
                lock1.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock1.readLock().unlock();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void write() {
        try {
            try {
                lock1.writeLock().lock();
                System.out.println("获得写锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock1.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MyService myService=new MyService();
//        myService.testMethod();
//       new Thread(new Runnable() {
//            @Override
//            public void run() {
//                myService.testMethod();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                myService.signal();
//            }
//        }).start();
        new Thread(()->{
            myService.read();
            myService.write();
        }).start();
        new Thread(()->{
            myService.read();
            myService.write();
        }).start();
    }

}