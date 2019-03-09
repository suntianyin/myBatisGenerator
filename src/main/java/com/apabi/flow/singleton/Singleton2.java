package com.apabi.flow.singleton;

import java.util.HashMap;

public class Singleton2 {

    private static class Singleton2Hold{
        private static final Singleton2 singleton2=new Singleton2();
    }
    private Singleton2(){};
    private static Singleton2 getSingleton2(){

        return Singleton2Hold.singleton2;
    }

}
