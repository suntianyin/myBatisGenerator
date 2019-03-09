package com.apabi.flow.ClassLoad;

class Dervied extends Base {


 
    public Dervied() {
        tellName();
 
        printName();
 
    }

    public void tellName() {
 
        System.out.println("Dervied tell name: " + name);
 
    }

    public void printName() {
 
        System.out.println("Dervied print name: " + name);
 
    }
    {
        tellName();

        printName();
    }
    private String name = "Java3y";
 
    public static void main(String[] args) {
 
        new Dervied();
    }
 
}

class Base {
 
    private String name = "公众号";
 
    public Base() {
        tellName();
 
        printName();
    }

    public void tellName() {
 
        System.out.println("Base tell name: " + name);
 
    }
    public void printName() {
 
        System.out.println("Base print name: " + name);
 
    }
 
}