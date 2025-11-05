package com.cert.exceptions;

public class Main {
    public static void main(String[] args) {


//        intresting1();

        System.out.println(method2());

    }

    private static int method2() {
        try {
            System.out.print("1");
            return 1;
        }catch (Exception e){
            System.out.print("2");
            return 2;
        }finally {
            System.out.print("3");
        }
    }

    private static void intresting1() {

        /**
         * size of 0 , means strings[0] throws an exception
         */
        String[] strings = new String[10];
        System.out.println(strings[9]);
    }
}