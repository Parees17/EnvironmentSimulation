package com.example.safarisimulator;

public class Disaster {

    String disasterName;
    double populationHit;
    long disasterTime;

    public Disaster(String name, double healthDecr){
        this.disasterName = name;
        this.populationHit = healthDecr;


    }

    public String getDisasterName(){
        return disasterName;
    }
    public double getPopulationHit(){
        return populationHit;
    }

    public void setPopulationHit(int inp) {
        populationHit= inp;
    }

    public void resetDisasterTime() {
        disasterTime = System.nanoTime();
    }


}
