package com.cert.adclassdesign.abstractclasses;

public class Stock extends Bird {

//    @Override
//    public String getName(){
//        return "Stock";
//    }

    public static void main(String[] args) {
        new Stock().printName();
    }
}

abstract class Bird{

    private String getName(){return null;}

    public void printName(){
        System.out.println(getName());
    }
}
