package com.workshop.s5;

class A{
    static int i =5;

    public static void method(){
        System.out.println("i am just a method");
    }
}

public class StaticMethodsOnClasses extends A {

    public static void main(String[] args) {
        System.out.println(i);
        method();
    }
}
