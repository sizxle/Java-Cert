package com.cert.fundamentals.innerclasses;

public class OutterClass2 {
    public String name="name";
    static class NestedClass{
        public static String name = "tshiamo";
        public String getName(){
            return name;
        }
    }

    public static void main(String[] args) {

        NestedClass nc = new NestedClass();

    }
}
