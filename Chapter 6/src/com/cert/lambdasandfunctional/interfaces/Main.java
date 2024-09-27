package com.cert.lambdasandfunctional.interfaces;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Prinatable<String> prinatable = s-> System.out.println(s);
        prinatable.print("Hello World");

        Supplier<Integer> supplier = () -> {
//            Prinatable<Integer> prinatable= x-> System.out.println("Main.main");
            int i = 1;
            return i;};

        System.out.println(supplier.get());

    }


}
