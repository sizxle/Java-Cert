package com.cert.genericsandcollections;

import java.util.Set;

public class SetInterface {

    public static void main(String[] args) {
//        Set<Character> letters = Set.of('z','o','o');// not allowed, dupilicate
        Set<Character> letters = Set.of('z','o','p');

        letters.forEach(s-> System.out.println(s));
        letters.forEach(System.out::println);


    }
}
