package com.cert.fundamentals.interfaces;

public interface IsWarmBlooded {

    public abstract boolean hasScales();

     default double getTemperature(){
        return 10.0;
    }



}
