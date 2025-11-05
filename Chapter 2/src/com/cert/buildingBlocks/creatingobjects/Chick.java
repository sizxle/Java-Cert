package com.cert.buildingBlocks.creatingobjects;

public class Chick {
    private String name= "Tshiamo";
    {
        System.out.println("Setting field");
    }

    public Chick() {
        name="Jane";
        System.out.println("Setting constructor");
    }

    public static void main(String[] args){
        Chick chick= new Chick();
        System.out.println(chick.name);
    }
}
