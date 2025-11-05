package com.cert.fundamentals.interfaces;

public class Class extends ClassB implements Interface {

    public static void method(){
        System.out.println("method");
        print();
    }

    public static void main(String[] args) {
        Interface.method();

        new Class().default2();
    }
}

class ClassB{

    public static void print(){
        System.out.println("ClassB");
    }
}

 interface Interface{

    default void default1(){
        System.out.println("default 1");
    }

    default void default2(){
        System.out.println("default 2");
        default1();
        method();
//        viti();
    }

//    void viti();

    static void method(){
        System.out.println("Interface");
        method2();

    };

    private static void method2(){
        System.out.println("Interface-private");
    };
}

