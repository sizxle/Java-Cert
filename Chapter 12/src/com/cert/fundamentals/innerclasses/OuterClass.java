package com.cert.fundamentals.innerclasses;

public class OuterClass {

    public String name="sthembizo";

//    public String getName(){
//        return name;
//    }

    public class InnerClass {
        public String name="Tshiamo";
        public static final int age=4;

//        @Override
        public void getName(){
            System.out.println(OuterClass.this.name);
            System.out.println(name);
            System.out.println(this.name);
        }
        InnerClass(){
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        System.out.println(outerClass.name);
        InnerClass h= outerClass.new InnerClass();
        h.getName();

        System.out.println("-------------------------------------");
        h.getName();

    }
}
