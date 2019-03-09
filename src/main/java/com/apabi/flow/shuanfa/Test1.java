package com.apabi.flow.shuanfa;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    //大数字运算   387*18
    public static void main(String[] args) {
        int a=18;
        int[] arry=new int[10];

        arry[arry.length-1]=7;
        arry[arry.length-2]=8;
        arry[arry.length-3]=3;

        for (int i=arry.length-1;i>0;i--){
            arry[i]*=a;
        }
        for (int i=arry.length-1;i>0;i--){
            arry[i-1]+=arry[i]/10;
            arry[i]=arry[i]%10;
        }
        for (int i=0;i<arry.length;i++){
            if(arry[i]!=0){
                for (int j=i;j<arry.length;j++){
                    System.out.print(arry[j]);
                }
                break;
            }
        }
    }
}
 class Test2 {
     public static int[] demo(int[] arry,int a){
         for (int i=arry.length-1;i>0;i--){
             arry[i]*=a;
         }
         for (int i=arry.length-1;i>0;i--){
             arry[i-1]+=arry[i]/10;
             arry[i]=arry[i]%10;
         }
         return arry;
     }
    public static void main(String[] args) {
        //5!  5*4*3*2*1
        int n=9;
        int[] arry=new int[100];
        arry[arry.length-1]=1;
        for (int i = 1; i <= n; i++) {
            arry = demo(arry, i);
        }

        for (int i=0;i<arry.length;i++){
            if(arry[i]!=0){
                for (int j=i;j<arry.length;j++){
                    System.out.print(arry[j]);
                }
                break;
            }
        }
    }
}
class Test3 {
    public static int[] demo(int[] arry,int a){
        for (int i=arry.length-1;i>0;i--){
            arry[i]*=a;
        }
        for (int i=arry.length-1;i>0;i--){
            arry[i-1]+=arry[i]/10;
            arry[i]=arry[i]%10;
        }
        return arry;
    }

    public static void main(String[] args) {
        int[] arry1=new int[10];
        arry1[arry1.length-1]=1;
        arry1[arry1.length-2]=1;
        arry1[arry1.length-3]=1;
        int[] arry2=new int[10];
        arry2[arry2.length-1]=1;
        arry2[arry2.length-2]=1;
        arry2[arry2.length-3]=1;

        for (int i = 0; i <arry1.length ; i++) {
            for (int j = 0; j <arry2.length ; j++) {
                arry2[j]=arry1[i];
            }
        }

    }
}