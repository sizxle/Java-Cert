package com.workshop;

interface A {
    public static  int a = 15;

    static void m2(){
        System.out.println("m1");
    }
}

interface B extends A  {
    public static int a = 5;

    static void m2(){
        System.out.println("m2");
    }

}

class C implements B {
    public static void main() {
        B.m2();

    }
}


public class Main2  {

    public static void main(String[] args) {

        C b = new C();
        b.main();//C.m2()
    }

}
