package com.cert.fundamentals.enums;

public enum Seasons {

    SUMMER("cold"){
        @Override
        public String getSeasonName() {
            return "summer";
        }
    },WINTER("cold"){
        public String getSeasonName() {
            return "winter";
        }
    }, SPRING("high"){
        public String getSeasonName() {
            return "spring";
        }
    };

    private String season_name;
    private Seasons(String name){
        this.season_name = name;
    }

    public String getSeason_name() {
        return season_name;
    }

    public abstract String getSeasonName();
}
