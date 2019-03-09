package com.apabi.flow.testIOC;

public class Car {
    private String name;
    private String length;
    private String width;
    private String height;
    private Wheel wheel;
    
    // 省略其他不重要代码

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", length='" + length + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", wheel=" + wheel +
                '}';
    }
}
