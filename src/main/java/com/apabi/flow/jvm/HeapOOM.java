package com.apabi.flow.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject{} 

    /**
     * @param args
     */ 
    public static void main(String[] args) { 
        List<OOMObject> list = new ArrayList<OOMObject>();

        while(true){ 
            list.add(new OOMObject()); 
        } 
    } 

} 
