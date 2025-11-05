package com.cert.play.review;

public class CandyCounter {

    static long addCandy(double fruits, float vegetables){
        return (int)(fruits+vegetables);
    }
    public static void main(String[] args) {
        System.out.println(addCandy((long)(int)(short)2,4));
    }
}
