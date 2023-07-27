package com.example.safarisimulator;

public class Wolf extends Animal{

    private long startTime;
    private long reproduceTime;

    public Wolf(String name, int x, int y, int animalAge, double thirst, double hunger, double aggressiveNature, double initialSurvProbability, int numAnimal){
        super(name,x,y,animalAge,thirst,hunger,aggressiveNature,initialSurvProbability, numAnimal);
        startTime = System.nanoTime();
        reproduceTime = System.nanoTime();

    }


    public void resetStartTime() {
        startTime = System.nanoTime();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getReproduceTime() {
        return reproduceTime;
    }

    public void resetReproduceTime(){
        reproduceTime = System.nanoTime();
    }

}
