package com.apabi.flow.jdkAop.jdkproxy;

public class AdviceService implements Advice {
    @Override
    public void goHome() {
        System.out.println("gohome");
    }
}
