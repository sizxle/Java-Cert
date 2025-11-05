package com.cert.play;

public class Main {

    public static void main(String[] args) {

        print("hello","world");
        print();
        print(null);
    }

    public static void print(String ...a){
        System.out.println(a.length);
    }
}
