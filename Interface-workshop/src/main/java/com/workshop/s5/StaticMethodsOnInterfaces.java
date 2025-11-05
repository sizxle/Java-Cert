package com.workshop.s5;

import java.io.Serializable;

interface StaticInterface {

    int k=5;
    static void staticMethod() {
        System.out.println("static method");
    }


}


public class StaticMethodsOnInterfaces implements StaticInterface {


    public static void main(String[] args) {
        StaticInterface.staticMethod();
        System.out.println(k);

        StaticMethodsOnInterfaces a = new StaticMethodsOnInterfaces();
    }

}
