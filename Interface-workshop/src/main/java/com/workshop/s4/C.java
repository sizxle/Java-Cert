package com.workshop.s4;

class A {
    int x=4;
}

class B{
    int x=5;
}

public class C extends B{
    // x??

    public static void main(String[] args) {

        C c=new C();

        System.out.println(c.x);
    }
}