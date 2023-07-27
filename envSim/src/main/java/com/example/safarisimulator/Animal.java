package com.example.safarisimulator;


import java.util.ArrayList;


public class Animal {

    String animalName;
    int xPos;
    int yPos;
    int age;
    int maleFemale=(int)(Math.random() * 2.0D);

    double initialSurvivalProbability;
    double reproductionProbability;
    private long startTime;
    private long reproduceTime;
    private long hungerTime;
    private long thirstTime;
    private ArrayList<Location> tempLocs = new ArrayList();
    double thirstBar = 20;
    double hungerBar = 10;
    int numAnimal;
    private int adaptiveAnimalMultiplier = 2;
    private double nonAdaptiveAnimalMultiplier = 0.5;
    double aggressiveness;

    private long swimTime;

    public Animal(String name, int x, int y, int animalAge, double thirst,double hunger, double aggressiveNature,double initialSurvivalProbability, int numAnimal) {
        this.animalName = name;
        this.xPos = x;
        this.yPos = y;
        this.age = animalAge;
        startTime = System.nanoTime();
        reproduceTime = System.nanoTime();

        initialSurvivalProbability = (Math.random()) / 2.0;
        this.thirstBar = thirst;
        this.hungerBar = hunger;
        this.aggressiveness = aggressiveNature;
        this.initialSurvivalProbability=initialSurvivalProbability;
        this.numAnimal = numAnimal;

    }

    public long getSwimTime(){
        return swimTime;
    }

    public void resetSwimTime(){
        swimTime = System.nanoTime();
    }
    public void setSwimTime(){
        swimTime = -1;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void changeLoc(int[][] gameGrid, int currAnimal) {

        boolean check = false;


        while(!check) {


            int tempx = this.xPos;
            int tempy = this.yPos;

            if (Math.random() > 0.5) {
                ++tempx;
            } else {
                --tempx;
            }

            if (Math.random() > 0.5) {
                ++tempy;

            } else {
                --tempy;
            }

            if (tempx >= 0 && tempy >= 0 && tempx <= 39 && tempy <= 49) {

                if (gameGrid[tempx][tempy] == 0 || gameGrid[tempx][tempy] == 11|| gameGrid[tempx][tempy] == 2
                        ||gameGrid[tempx][tempy] == 4 ||gameGrid[tempx][tempy] == 3 ||gameGrid[tempx][tempy] == 5
                        ||gameGrid[tempx][tempy] == 6 ||gameGrid[tempx][tempy] == 7 ||gameGrid[tempx][tempy] == 8 ||gameGrid[tempx][tempy] == 9 ) {

                    check = true;
                    gameGrid[tempx][tempy] = currAnimal;

                    if(xPos > 4 && xPos <= 19 && yPos >= 15 && yPos <= 29){
                        gameGrid[xPos][yPos] = 11;

                    }else if (xPos > 21 && yPos >= 30 && xPos <= 30 && yPos <= 39){
                        gameGrid[xPos][yPos] = 2;
                    }
                    else{
                        gameGrid[xPos][yPos] = 0;
                    }

                    xPos = tempx;
                    yPos = tempy;

                }
            }
        }



        }

    public void chase(Animal tempAnimal, int[][]gameGrid, int numAnimall){

        int tempx = xPos;
        int tempy = yPos;
        if(tempx- tempAnimal.getxPos() > 0){
            tempx--;
        }else if(tempx - tempAnimal.getxPos() < 0){
            tempx++;
        }
        if(tempy- tempAnimal.getyPos() > 0){
            tempy--;
        }else if(tempy - tempAnimal.getyPos() < 0){
            tempy++;
        }


        if (gameGrid[tempx][tempy] == 0 || gameGrid[tempx][tempy] == 11 || gameGrid[tempx][tempy] == 2
                ||gameGrid[tempx][tempy] == 4 ||gameGrid[tempx][tempy] == 3 ||gameGrid[tempx][tempy] == 5
                ||gameGrid[tempx][tempy] == 6 ||gameGrid[tempx][tempy] == 7 ||gameGrid[tempx][tempy] == 8 ||gameGrid[tempx][tempy] == 9
                ||gameGrid[tempx][tempy] == 12 ||gameGrid[tempx][tempy] == 13) {
            gameGrid[tempx][tempy] = numAnimall;


            if (xPos > 4 && xPos < 20 && yPos >= 15 && yPos <= 29) {
                gameGrid[xPos][yPos] = 11;


            } else {
                gameGrid[xPos][yPos] = 0;
            }

            xPos = tempx;
            yPos = tempy;

        }
    }

    public void chaseWater(Environment tempTrees, int[][]gameGrid, ArrayList<Animal> tempAnimal, int temp, ArrayList<Environment> tempLake) {


        int animal = tempAnimal.get(temp).getNumAnimal() + tempAnimal.get(temp).getMaleFemale();
        int tempx = xPos;
        int tempy = yPos;
        if (tempx - tempTrees.getX() > 0) {
            tempx--;
        } else if (tempx - tempTrees.getX() < 0) {
            tempx++;
        }
        if (tempy - tempTrees.getY() > 0) {
            tempy--;
        } else if (tempy - tempTrees.getY() < 0) {
            tempy++;
        }


        for (int i = 0; i <tempLake.size() ; i++) {

            if (tempx != tempLake.get(i).getX() && tempy != tempLake.get(i).getY()) {

                gameGrid[tempx][tempy] = animal;
                gameGrid[xPos][yPos] = 0;

                xPos = tempx;
                yPos = tempy;

                System.out.println("CCCCCCC");

            }
        }
    }

    public int getAnimalMultiplier(){
        return adaptiveAnimalMultiplier;
    }

    public double getNonAdaptiveAnimalMultiplier() {
        return nonAdaptiveAnimalMultiplier;
    }

    public void setAge(int input){
        age = input;
    }

    public int getAge() {
        return age;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {

        return yPos;
    }

    public int setxPos(int inp){
        xPos = inp;
        return xPos;
    }

    public int setyPos(int inp){
        yPos = inp;
        return yPos;
    }


    public int getNumAnimal(){
        return numAnimal;
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


    public long getThirstTime() {
        return thirstTime;
    }


    public void resetReproduceTime(){
        reproduceTime = System.nanoTime();
    }

    public void resetHungerTime(){
        hungerTime = System.nanoTime();
    }

    public void resetThirstTime(){
        thirstTime = System.nanoTime();
    }





    public boolean checkOppositeNeighbor(ArrayList<Animal> tempSpecies, int[][] tempGrid) {
        for(int i = 0; i < tempSpecies.size(); ++i) {
            if ((tempSpecies.get(i)).getxPos() >= this.xPos - 1 && (tempSpecies.get(i)).getxPos() <= this.xPos + 1 && (tempSpecies.get(i)).getyPos() >= this.yPos - 1
                    && (tempSpecies.get(i)).getyPos() <= this.yPos + 1 && (tempSpecies.get(i)).getxPos() != this.xPos
                    && (tempSpecies.get(i)).getyPos() != this.yPos && this.maleFemale != (tempSpecies.get(i)).getMaleFemale()) {
                return true;
            }
        }

        return false;
    }



    public double getSurvivalProbability(){

        return initialSurvivalProbability;
    }

    public void checkSurvivalProb(ArrayList<Animal> tempAnimal, int tempNum, int [][ ] gameGrid ){


        if (initialSurvivalProbability <= 0.0){

            if(tempAnimal.get(tempNum).getxPos() > 4 && tempAnimal.get(tempNum).getxPos() <= 19 && tempAnimal.get(tempNum).getyPos() >= 15 && tempAnimal.get(tempNum).getyPos() <= 29){
                gameGrid[tempAnimal.get(tempNum).getxPos()][tempAnimal.get(tempNum).getyPos()] = 11;
            }else if(tempAnimal.get(tempNum).getxPos() > 21 && tempAnimal.get(tempNum).getyPos() >= 30 && tempAnimal.get(tempNum).getxPos() <= 30 && tempAnimal.get(tempNum).getyPos() <= 39){
                gameGrid[tempAnimal.get(tempNum).getxPos()][tempAnimal.get(tempNum).getyPos()] = 2;
            }
            else {
                gameGrid[tempAnimal.get(tempNum).getxPos()][tempAnimal.get(tempNum).getyPos()] = 0;
            }

            tempAnimal.remove(tempNum);
        }


    }

    public double ageSurvivalProbUpdate(){

        if(age<20){
            initialSurvivalProbability = initialSurvivalProbability + 0.25;
        }else if(age >20 && age<50){
            initialSurvivalProbability = initialSurvivalProbability + 0.6;
        }else if(age>=50 && age<= 65){
            initialSurvivalProbability = initialSurvivalProbability + 0.3;
        }else if(age> 65 && age <= 99){
            initialSurvivalProbability = initialSurvivalProbability + 0.1;
        }else if(age>100){

            initialSurvivalProbability = 0.0;
        }

        return initialSurvivalProbability;
        }

    public double getReproductionProbability(){

        if(age<15){
            reproductionProbability = 0.02;
        }else if(age >15 && age<20) {
            reproductionProbability = 0.3;
        }else if(age >20 && age<=30){
            reproductionProbability = 0.9;
        }else if(age>31 && age<= 40){
            reproductionProbability = 0.8;
        }else if(age>40 && age<= 50){
            reproductionProbability = 0.6;
        }
        else if(age>50 && age<= 60){
            reproductionProbability = 0.4;
        } else if(age>60 && age<= 70){
            reproductionProbability = 0.1;
        }else if(age> 70){
            reproductionProbability = 0.05;
        }
        return reproductionProbability;
    }


    public void setReproductionProbabilityDecrease(){
        reproductionProbability = reproductionProbability - 0.5;
    }

    public void setInitialSurvivalProbabilityDecrease(){
        initialSurvivalProbability = initialSurvivalProbability - 0.10;

    }

    public void setInitialSurvivalProbability(double inp){
        initialSurvivalProbability = inp;
    }

    public double getAggressiveness() {
        return aggressiveness;
    }

    public double getThirst(){
        return thirstBar;
    }

    public void setThirstBar(double inp){
        thirstBar = inp;
    }

    public double getHunger(){
        return hungerBar;
    }

    public void setHungerBar(double input){

        hungerBar = input;
    }

    public int getMaleFemale() {

        return maleFemale;

    }



}



