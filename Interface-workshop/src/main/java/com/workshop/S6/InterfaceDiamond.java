package com.workshop.S6;

interface A{
    default void method(){
        System.out.println("A method");
    }
}

interface B extends A{
    default void method(){
        System.out.println("B method");
    }
}

interface  C extends A{
    default void method(){
        System.out.println("C method");
    }
}


public class InterfaceDiamond implements C,B {

    public static void main(String[] args) {
        A a = new InterfaceDiamond();
        a.method();
    }

    @Override
    public void method() {
        C.super.method();
        B.super.method();
    }
}
