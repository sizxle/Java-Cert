package com.cert.buildingBlocks.creatingobjects.order;

public class ClassA {
    {
        System.out.println(" Instance initialize in class A");
    }
}

class ClassB extends  ClassA{
    {
        System.out.println(" Instance initialize in class B");
    }

    public static void main(String[] args) {
        new ClassB();
        long l = 3_147_483_648L;
        System.out.println(l);
    }

}