package com.cert.fundamentals.innerclasses;

public class Main {

    private Main(){}

    public static void main(String[] args) {
        new OutterClass2.NestedClass();
        new Main();
    }
}
