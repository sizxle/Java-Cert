package com.workshop.s3;

public class User implements Loggable {

    public String name;


    public static void main(String[] args) {

        Object o = new User();

        if(o instanceof Loggable) {
            System.out.println("logged");
        }
    }

}


interface Loggable{

}