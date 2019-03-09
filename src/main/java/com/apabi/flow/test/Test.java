package com.apabi.flow.test;

import java.util.*;
import java.util.concurrent.*;

public class Test {
     public static void main(String[] args) throws InterruptedException {
//         ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
//                 new ArrayBlockingQueue<Runnable>(5));
//
//         for(int i=0;i<20;i++){
//             MyTask myTask = new MyTask(i);
//             executor.execute(myTask);
//             System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
//             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
//         }
//         executor.shutdown();
//         String str = "asdsadsdsad（啊大苏打实打实）（但是粉丝大方）萨达萨达萨达是";
//         int i = str.indexOf("（");
//         int i1 = str.lastIndexOf("）");
//         str = str.substring(0,i)+ str.substring(i1+1);
//         for (int j = 0;j<str.length();j++){
//             //去除括号内的内容
//             if (str.charAt(j) == '（'){
//                 int k = 0;
//                 for(k = j+1; k<str.length(); k++){
//                     if (str.charAt(k) == '）'){
//                         break;
//                     }
//                 }
//                 str = str.substring(0,j)+ str.substring(k+1);
//             }
//         }
//         System.out.println(str);


//
//         ExecutorService threadPool = Executors.newCachedThreadPool();
//         CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
//         for(int i = 1; i < 5; i++) {
//             final int taskID = i;
//             cs.submit(new Callable<Integer>() {
//                 public Integer call() throws Exception {
//                     return taskID;
//                 }
//             });
//         }
//         // 可能做一些事情
//         for(int i = 1; i < 5; i++) {
//             try {
//                 System.out.println(cs.take().get());
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             } catch (ExecutionException e) {
//                 e.printStackTrace();
//             }
//         }


         final Queue<Integer> q1 = new LinkedBlockingQueue<Integer>();
         final Queue<Integer> q2 = new LinkedBlockingQueue<Integer>();
         final int n = 1000000;
         final int m = 100;

         for (int i = 0; i < n; i++) {
             q1.add(i);
         }

         List<Thread> ts = new ArrayList<Thread>();
         for (int i = 0; i < m; i++) {
             ts.add(new Thread(new Runnable() {
                 public void run() {
                     int i = 0;
                     while (q2.size() < n && i++ < n / m) { // q2.size() 非线程安全，所以设置每个线程添加平均个数，防止poll出null报错
                         q2.add(q1.poll());
                     }
                 }
             }));
         }

         for (Thread t : ts) {
             t.start();
         }

         System.out.println("启动了 " + m + " 个线程，每个线程处理 " + n / m + " 个操作");

         for (Thread t : ts) {
             while (t.isAlive()) {
                 Thread.sleep(1);
             }
         }

         System.out.println("q1.size()：" + q1.size());
         System.out.println("q2.size()：" + q2.size());

         Set<Integer> set = new HashSet<Integer>();
         Integer i;
         while ((i = q2.poll()) != null) {
             set.add(i);
         }
         System.out.println("q2.size()：" + q2.size());
         System.out.println("set.size()：" + set.size());
     }
}
 
 
class MyTask implements Runnable {
    private int taskNum;
     
    public MyTask(int num) {
        this.taskNum = num;
    }
     
    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
