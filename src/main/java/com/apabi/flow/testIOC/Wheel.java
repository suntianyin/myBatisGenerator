package com.apabi.flow.testIOC;

public class Wheel {
    private String brand;
    private String specification ;
    
    // 省略其他不重要代码

    @Override
    public String toString() {
        return "Wheel{" +
                "brand='" + brand + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }
}