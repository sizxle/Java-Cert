package com.cert.fundamentals.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Animal {

    private String name;
    private boolean canSwim;
    private boolean canHop;

    public Animal(String name, boolean canSwim, boolean canHop) {
        this.name = name;
        this.canSwim = canSwim;
        this.canHop = canHop;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public String toString() {
        return name;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<Animal>();

        animals.add(new Animal("fish", true, false));
        animals.add(new Animal("kangaroo", true, true));
        animals.add(new Animal("rabbit", false, true));
        animals.add(new Animal("turtle", true, false));

        System.out.println("Animals that swim");
        print(animals,a->a.canSwim);
        System.out.println("--------------------------------------------");
        System.out.println("Animals that Hop");
        print(animals,( Animal a)->a.canHop);

        Predicate<Animal> isSwim = a->{ return a.canSwim; };
    }

    public static void print(List<Animal> animals, Predicate<Animal> checker) {

        for (Animal animal : animals) {
            if(checker.test(animal)) {
                System.out.println(animal);
            }
        }
    }
}
