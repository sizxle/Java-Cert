package com.cert.genericsandcollections;

import java.util.ArrayList;
import java.util.List;

public class Playground {

    public static  <T> void print(List<? extends T> list){
        for (T t : list) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {

        List<Number> strings = new ArrayList<>();

        strings.add(1);
        strings.add(1.6);
        strings.add(new Object())

        print(strings);
    }
}
