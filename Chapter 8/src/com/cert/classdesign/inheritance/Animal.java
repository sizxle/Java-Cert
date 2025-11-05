package com.cert.classdesign.inheritance;

import java.util.List;

public class Animal {

    public static int leg = 4;
    private String name;

    public Animal(String name) {

        this.name = name;
    }

    public static void eat() {
        System.out.println("eatting");
    }

    public void sleep() {
        System.out.println("sleeping in animal");
    }

    public String getName(){
        return name;
    }
}
