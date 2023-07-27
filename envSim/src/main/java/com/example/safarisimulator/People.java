package com.example.safarisimulator;

import java.util.ArrayList;

public class People extends Animal {

    private long startTime;
    private long reproduceTime;
    private long hungerTime;

    public People(String name, int x, int y, int age, double thirst, double hunger, double aggressiveNature, double initialSurvivalProbability, int numAnimal){
        super(name, x,  y,  age,  thirst, hunger,aggressiveNature, initialSurvivalProbability,numAnimal);
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


    public long getHungerTime() {
        return hungerTime;
    }

    public void resetReproduceTime(){
        reproduceTime = System.nanoTime();
    }


    public boolean checkOppositeNeighborPerson(ArrayList<People> tempSpecies, int[][] tempGrid) {
        for(int i = 0; i < tempSpecies.size(); ++i) {
            if ((tempSpecies.get(i)).getxPos() >= this.xPos - 1 && (tempSpecies.get(i)).getxPos() <= this.xPos + 1 && (tempSpecies.get(i)).getyPos() >= this.yPos - 1
                    && (tempSpecies.get(i)).getyPos() <= this.yPos + 1 && (tempSpecies.get(i)).getxPos() != this.xPos
                    && (tempSpecies.get(i)).getyPos() != this.yPos && this.maleFemale != (tempSpecies.get(i)).getMaleFemale()) {
                return true;
            }
        }

        return false;
    }

}
