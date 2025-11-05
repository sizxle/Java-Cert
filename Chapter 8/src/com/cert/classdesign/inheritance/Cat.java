package com.cert.classdesign.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal {

    public static int leg= 3;
     public String name= "cat";

    public Cat(String name) {
        super(name);
    }


     public static void eat(){
        System.out.println("food");
    }

    public void letsee(){
        System.out.println("we just looking");
    }

    @Override
    public void sleep(){
        System.out.println("sleeping in cat");
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Cat");
        cat.eat();
//        System.out.println(cat.name);
        Animal animal = cat;


        animal.eat();


        cat.sleep();
        animal.sleep();

        Object catAsObject = cat;

        Cat u = (Cat) catAsObject;

        u.letsee();


        System.out.println(cat.leg);
        System.out.println(animal.leg);
    }
}
