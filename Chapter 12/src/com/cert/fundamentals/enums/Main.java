package com.cert.fundamentals.enums;

public class Main {

    public static void main(String[] args) {

        Seasons summer= Seasons.SUMMER;
        switch(summer){
            case SUMMER:
                System.out.println("Summer");
                break;
            case WINTER:
                System.out.println("Winter");
                break;
            default:
                System.out.println("default");

        }

        System.out.println(summer.getSeasonName());
        System.out.println(summer.getSeason_name());
    }
}
