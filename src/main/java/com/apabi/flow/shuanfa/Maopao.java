package com.apabi.flow.shuanfa;

public class Maopao {
    public static void main(String[] args) {
        int[] ints=new int[]{2,5,4,6,7,8,3};
        int temp=0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i+1; j <ints.length ; j++) {
                if(ints[i]>ints[j]){
                    temp=ints[i];
                    ints[i]=ints[j];
                    ints[j]=temp;
                }
            }
        }
        for (int i = 0; i <ints.length ; i++) {
            System.out.println(ints[i]);

        }
    }
}
