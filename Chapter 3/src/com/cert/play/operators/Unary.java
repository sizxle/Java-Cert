package com.cert.play.operators;

public class Unary {

    public static void main(String []args){
        double aNumber= 1.34;
        System.out.println(aNumber);
        aNumber = -aNumber;
        System.out.println(aNumber);
        aNumber = -(-aNumber);
        System.out.println(aNumber);
    }
}
