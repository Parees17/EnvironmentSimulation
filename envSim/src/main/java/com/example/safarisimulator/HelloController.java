package com.example.safarisimulator;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class HelloController {
    int x = 40;
    int y = 50;
    Button[][] btn;
    int[][] gameGrid;
    ArrayList<Animal> totalPeople;
    ArrayList<Animal> totalWolves;
    ArrayList<Animal> totalPigs;
    ArrayList<Animal> totalRabbits;
    ArrayList<Animal> totalSalmon;
    ArrayList<Environment> lake;
    ArrayList<Environment> plains;
    ArrayList<Environment> cactus;
    ArrayList<Environment> trees;

    ArrayList<Disaster> totalDisasters;
    Disaster twister = new Disaster("twister", 0.4);
    Disaster earthquake = new Disaster("earthquake", 0.4);
    Disaster thunderLighting = new Disaster("thunder storm", 0.4);
    Disaster avalanche = new Disaster("avalanche", 0.4);
    Disaster hurricane = new Disaster("hurricane", 0.4);


    long disasterTime = -1;


    @FXML
    private AnchorPane aPane;
    @FXML
    private GridPane gPane;
    @FXML
    Label lblMalePeople,lblFemalePeople,lblRabbitFemale ,lblRabbitMale, lblWolvesFemale,lblWolvesMale, lblPigsFemale, lblPigsMale, lblSalmonMale, lblSalmonFemale;


    public HelloController() {
        btn = new Button[x][y];
        gameGrid = new int[x][y];
        totalPeople = new ArrayList();
        totalWolves = new ArrayList<>();
        totalPigs = new ArrayList<>();
        totalRabbits = new ArrayList<>();
        totalSalmon = new ArrayList<>();
        lake = new ArrayList<>();
        plains = new ArrayList<>();
        cactus = new ArrayList<>();
        trees = new ArrayList<>();
        totalDisasters = new ArrayList<>();



    }

    @FXML
    private void handleStart(ActionEvent event) {
        int i;
        int j;
        for (i = 0; i < btn.length; ++i) {
            for (j = 0; j < btn[0].length; ++j) {
                btn[i][j] = new Button();
                btn[i][j].setStyle("-fx-background-color:#000000");
                btn[i][j].setPrefWidth(25.0D);
                gPane.add(btn[i][j], j, i);
                gameGrid[i][j] = 0;
            }
        }

        gPane.setGridLinesVisible(true);
        gPane.setVisible(true);
        EventHandler z = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
            }
        };

        for (i = 0; i < btn.length; ++i) {
            for (j = 0; j < btn[0].length; ++j) {
                btn[i][j].setOnMouseClicked(z);
            }
        }

        for(int c = 35; c>21; c--){

            gameGrid[c][30] = 2;
            gameGrid[c][31] = 2;
            gameGrid[c][32] = 2;
            gameGrid[c][33] = 2;
            gameGrid[c][34] = 2;
            gameGrid[c][35] = 2;
            gameGrid[c][36] = 2;
            gameGrid[c][37] = 2;
            gameGrid[c][38] = 2;
            gameGrid[c][39] = 2;
            lake.add(new Environment(c, 30));
            lake.add(new Environment(c, 31));
            lake.add(new Environment(c, 32));
            lake.add(new Environment(c, 33));
            lake.add(new Environment(c, 34));
            lake.add(new Environment(c, 35));
            lake.add(new Environment(c, 36));
            lake.add(new Environment(c, 37));
            lake.add(new Environment(c, 38));
            lake.add(new Environment(c, 39));


        }

        for(int p = 19; p>4; p--){


            gameGrid[p][15] = 11;
            gameGrid[p][16] = 11;
            gameGrid[p][17] = 11;
            gameGrid[p][18] = 11;
            gameGrid[p][19] = 11;
            gameGrid[p][20] = 11;
            gameGrid[p][21] = 11;
            gameGrid[p][22] = 11;
            gameGrid[p][23] = 11;
            gameGrid[p][24] = 11;
            gameGrid[p][25] = 11;
            gameGrid[p][26] = 11;
            gameGrid[p][27] = 11;
            gameGrid[p][28] = 11;
            gameGrid[p][29] = 11;
            plains.add(new Environment(p, 15));
            plains.add(new Environment(p, 16));
            plains.add(new Environment(p, 17));
            plains.add(new Environment(p, 18));
            plains.add(new Environment(p, 19));
            plains.add(new Environment(p, 20));
            plains.add(new Environment(p, 21));
            plains.add(new Environment(p, 22));
            plains.add(new Environment(p, 23));
            plains.add(new Environment(p, 24));
            plains.add(new Environment(p, 25));
            plains.add(new Environment(p, 26));
            plains.add(new Environment(p, 27));
            plains.add(new Environment(p, 28));
            plains.add(new Environment(p, 29));


        }

        for (int m = 0; m < 8 ; m++) {
            int xCoord = (int) (Math.random() * 9) +1;
            int yCoord = (int) (Math.random() * 29) +1;
            gameGrid[xCoord][yCoord] = 12;
            cactus.add(new Environment(xCoord, yCoord));

        }

        for(int n = 7; n< 21; n++ ){
            int xCoor = (int) (Math.random() * 15) +1;
            int yCoor = (int) (Math.random() * 37) +1;
            gameGrid[xCoor][yCoor] = 13;
            trees.add(new Environment(xCoor, yCoor));
        }

        start();
    }

    public int getRandomInt(int min, int max) {

        int x = (int) (Math.floor(Math.random() * max + min));
        return x;
    }


    @FXML
    public void handleAdd() {


        totalPeople.add(new Animal("Person", 7, 8, 15, 10.0, 8.0, 0.05, 0.1, 1));

        totalWolves.add(new Animal("Wolf", 13, 12, 15, 10.0, 8.0, 0.35, 0.15, 3));
//
        totalRabbits.add(new Animal("Rabbit", 19, 23, 15, 10.0, 8.0, 0.02, 0.05, 5));
//
        totalPigs.add(new Animal("Pigs", 14 ,17, 15, 10.0, 10.0, 0.02, 0.07, 7));


        totalSalmon.add(new Animal("Salmon", 25, 34, 1, 10.0, 10.0, 0.02, 0.07, 9));



        for (int i = 0; i < totalPeople.size(); i++) {
            if (totalPeople.get(i).getMaleFemale() == 0) {
                gameGrid[(totalPeople.get(totalPeople.size() - 1)).getxPos()][(totalPeople.get(totalPeople.size() - 1)).getyPos()] = 1;
            } else if (totalPeople.get(i).getMaleFemale() == 1) {
                gameGrid[(totalPeople.get(totalPeople.size() - 1)).getxPos()][(totalPeople.get(totalPeople.size() - 1)).getyPos()] = 2;
            }
        }

        for (int j = 0; j < totalWolves.size(); j++) {
            if (totalWolves.get(j).getMaleFemale() == 0) {
                gameGrid[(totalWolves.get(totalWolves.size() - 1)).getxPos()][(totalWolves.get(totalWolves.size() - 1)).getyPos()] = 3;
            } else if (totalWolves.get(j).getMaleFemale() == 1) {
                gameGrid[(totalWolves.get(totalWolves.size() - 1)).getxPos()][(totalWolves.get(totalWolves.size() - 1)).getyPos()] = 4;
            }
        }

        for (int z = 0; z < totalRabbits.size(); z++) {

            if (totalRabbits.get(z).getMaleFemale() == 0) {
                gameGrid[(totalRabbits.get(totalRabbits.size() - 1)).getxPos()][(totalRabbits.get(totalRabbits.size() - 1)).getyPos()] = 5;
            } else if (totalRabbits.get(z).getMaleFemale() == 1) {
                gameGrid[(totalRabbits.get(totalRabbits.size() - 1)).getxPos()][(totalRabbits.get(totalRabbits.size() - 1)).getyPos()] = 6;
            }
        }

        for (int b = 0; b < totalPigs.size(); b++) {

            if (totalPigs.get(b).getMaleFemale() == 0) {
                gameGrid[(totalPigs.get(totalPigs.size() - 1)).getxPos()][(totalPigs.get(totalPigs.size() - 1)).getyPos()] = 7;
            } else if (totalPigs.get(b).getMaleFemale() == 1) {
                gameGrid[(totalPigs.get(totalPigs.size() - 1)).getxPos()][(totalPigs.get(totalPigs.size() - 1)).getyPos()] = 8;
            }
        }

        for (int b = 0; b < totalSalmon.size(); b++) {
            if (totalSalmon.get(b).getMaleFemale() == 0) {
                gameGrid[(totalSalmon.get(totalSalmon.size() - 1)).getxPos()][(totalSalmon.get(totalSalmon.size() - 1)).getyPos()] = 9;
            } else if (totalSalmon.get(b).getMaleFemale() == 1) {
                gameGrid[(totalSalmon.get(totalSalmon.size() - 1)).getxPos()][(totalSalmon.get(totalSalmon.size() - 1)).getyPos()] = 10;
            }
        }


        updateScreen();
    }



    public void updateScreen() {
        for (int i = 0; i < btn.length; ++i) {
            for (int j = 0; j < btn[0].length; ++j) {
                if (gameGrid[i][j] == 0) {
                    btn[i][j].setStyle("-fx-background-color:#d3d3d3");
                } else if (gameGrid[i][j] == 1) {
                    btn[i][j].setStyle("-fx-background-color:#ff0000");

                } else if (gameGrid[i][j] == 2) {
                    btn[i][j].setStyle("-fx-background-color:#194bc9");

                } else if (gameGrid[i][j] == 3) {
                    btn[i][j].setStyle("-fx-background-color:#1ec726");

                } else if (gameGrid[i][j] == 4) {
                    btn[i][j].setStyle("-fx-background-color:#ecbf0f");

                } else if (gameGrid[i][j] == 5) {
                    btn[i][j].setStyle("-fx-background-color:#0fcdd3");
                } else if (gameGrid[i][j] == 6) {
                    btn[i][j].setStyle("-fx-background-color:#5f14b0");
//                    System.out.println("purple ");
                } else if (gameGrid[i][j] == 7) {
                    btn[i][j].setStyle("-fx-background-color:#884312");
//                    System.out.println("brown");
                } else if (gameGrid[i][j] == 8) {
                    btn[i][j].setStyle("-fx-background-color:#131008");
//                    System.out.println("brown");
                }
                else if (gameGrid[i][j] == 9) {
                    btn[i][j].setStyle("-fx-background-color:#b94b81");
//                    System.out.println("brown");
                }
                else if (gameGrid[i][j] == 10) {
                    btn[i][j].setStyle("-fx-background-color:#fce5cd");
//                    System.out.println("brown");
                } else if (gameGrid[i][j] == 11) {
                    btn[i][j].setStyle("-fx-background-color:#8ad98e");
//                    System.out.println("brown");
                }else if (gameGrid[i][j] == 12) {
                    btn[i][j].setStyle("-fx-background-color:#da921f");
//
                }else if (gameGrid[i][j] == 13) {
                    btn[i][j].setStyle("-fx-background-color:#42513b");
//
                }

            }
        }


    }

    public void animalDeath(ArrayList<Animal> tempAnimal, int animalColor, int tempNum){

        if(tempAnimal.get(tempNum).getSurvivalProbability() <= 0){
            tempAnimal.remove(tempNum);

        }

    }

    public void start() {
        (new AnimationTimer() {
            public void handle(long now) {

                if(totalPeople.size()>0){
                    for (int i = 0; i < totalPeople.size(); ++i) {
                        if ((double) (now - (totalPeople.get(i)).getStartTime()) > 1500000000.0) {


                            checkCactus(totalPeople, i);

                            totalPeople.get(i).setAge(totalPeople.get(i).getAge() + 1);
                            totalPeople.get(i).ageSurvivalProbUpdate();
                            determinePlainMultipliers(totalPeople);



                            if (totalPeople.get(i).getThirst() < 6.0){
                                checkWater(totalPeople, i);
                                checkWaterNext(totalPeople, i);
                            }


                            if(totalPeople.get(i).getHunger()<7.0){

                                if(trees.size()> 0){
                                    chaseAppleTrees(totalPeople, i, i);
                                    checkAppleTree(totalPeople, i);
                                }
                                 if(totalPigs.size() > 0){
                                    checkNearestPig(totalPeople,i);
                                }else if(totalRabbits.size() > 0){
                                    checkNearestRabbit(totalPeople, i);
                                }

                            }else{
                                totalPeople.get(i).changeLoc(gameGrid, totalPeople.get(i).getNumAnimal()+ totalPeople.get(i).getMaleFemale());


                            }

                            if (totalPigs.size() != 0){
                                speciesInteraction(totalPeople, totalPigs, i );
                            }
                            if (totalWolves.size()!= 0){
                                speciesInteraction(totalPeople, totalWolves, i);
                            }
                            if (totalRabbits.size()!= 0){
                                speciesInteraction(totalPeople, totalRabbits, i);
                            }

                            totalPeople.get(i).resetStartTime();

                        }

                        if(now - totalPeople.get(i).getHungerTime() > 9000000000.0){
                            creatureHungerUpdate(totalPeople);
                            totalPeople.get(i).resetHungerTime();

                        }

                        if(now - totalPeople.get(i).getThirstTime() > 70000000000.0){
                            creatureThirstUpdate(totalPeople);
                            totalPeople.get(i).resetThirstTime();
                        }

                        if(now - totalPeople.get(i).getReproduceTime() > 1000000000.0){

                            reproducePerson(totalPeople, gameGrid,i);
                        }


                    }
                }


                if(totalPigs.size()>0){

                    for (int x = 0; x < totalPigs.size(); x++) {


                        if ((double) (now - (totalPigs.get(x)).getStartTime()) > 1500000000.0) {


                            checkCactus(totalPigs, x);

                            totalPigs.get(x).setAge(totalPigs.get(x).getAge() + 1);
                            totalPigs.get(x).ageSurvivalProbUpdate();
                            determinePlainMultipliers(totalPigs);

                            if (totalPigs.get(x).getThirst() < 8.0){
                                checkWater(totalPigs, x);
                                checkWaterNext(totalPigs, x);
                            }

                            if(totalPigs.get(x).getHunger()<7.0){

                                if(trees.size()> 0){
                                    chaseAppleTrees(totalPigs, x, x);
                                    checkAppleTree(totalPigs, x);
                                }else if(totalRabbits.size() > 0){
                                    checkNearestRabbit(totalPigs, x);
                                }

                            }else{
                                totalPigs.get(x).changeLoc(gameGrid, totalPigs.get(x).getNumAnimal()+ totalPigs.get(x).getMaleFemale());
                            }


                            if (totalPeople.size() != 0){
                                speciesInteraction(totalPigs, totalPeople, x );
                            }
                            if (totalWolves.size()!= 0){
                                speciesInteraction(totalPigs, totalWolves, x);
                            }


                            totalPigs.get(x).resetStartTime();

                        }

                        if(now - totalPigs.get(x).getHungerTime() > 9000000000.0){
                            creatureHungerUpdate(totalPigs);
                            totalPigs.get(x).resetHungerTime();

                        }

                        if(now - totalPigs.get(x).getThirstTime() > 7000000000.0){
                            creatureThirstUpdate(totalPigs);
                            totalPigs.get(x).resetThirstTime();
                        }



                        if(now - totalPigs.get(x).getReproduceTime() > 1000000000.0){

                            reproducePigs(totalPigs, gameGrid,x);
                        }


                    }
                }


                if(totalWolves.size()>0){
                    for (int k = 0; k < totalWolves.size(); k++) {

                        if ((double) (now - (totalWolves.get(k)).getStartTime()) > 1500000000.0) {

                            checkCactus(totalWolves, k);

                            totalWolves.get(k).setAge(totalWolves.get(k).getAge() + 1);
                            totalWolves.get(k).ageSurvivalProbUpdate();


                            if (totalWolves.get(k).getThirst() < 8.0){
                                checkWater(totalWolves, k);
                                checkWaterNext(totalWolves, k);
                            }

                            if(totalWolves.get(k).getHunger()< 7.0){

                                if(totalPigs.size()> 0){
                                    checkNearestPig(totalWolves, k);
                                }else if(totalRabbits.size() > 0){
                                    checkNearestRabbit(totalWolves, k);
                                }else if(totalPeople.size() > 0){
                                    checkNearestPerson(totalWolves,k);
                                }

                            }
                            else{
                                totalWolves.get(k).changeLoc(gameGrid, totalWolves.get(k).getNumAnimal()+ totalWolves.get(k).getMaleFemale());

                            }

                            if (totalPeople.size() != 0){
                                speciesInteraction(totalWolves, totalPeople, k );
                            }
                            if (totalPigs.size()!= 0){
                                speciesInteraction(totalWolves, totalPigs, k);
                            }

                            if (totalRabbits.size()!= 0){
                                speciesInteraction(totalWolves, totalRabbits, k);
                            }


                            totalWolves.get(k).resetStartTime();

                        }



                        if(now - totalWolves.get(k).getHungerTime() > 90000000000.0){
                            creatureHungerUpdate(totalWolves);
                            totalWolves.get(k).resetHungerTime();

                        }

                        if(now - totalWolves.get(k).getThirstTime() > 70000000000.0){
                            creatureThirstUpdate(totalWolves);
                            totalWolves.get(k).resetThirstTime();
                        }

                        if(now - totalWolves.get(k).getReproduceTime() > 4000000000.0){
                            reproduceWolf(totalWolves, gameGrid, k);
                        }



                    }

                }


                if(totalRabbits.size()>0){
                   for (int l = 0; l < totalRabbits.size(); l++) {

                        if ((double) (now - (totalRabbits.get(l)).getStartTime()) > 1500000000.0) {

                            checkCactus(totalRabbits, l);

                            totalRabbits.get(l).setAge(totalRabbits.get(l).getAge() + 1);
                            totalRabbits.get(l).ageSurvivalProbUpdate();

                            determinePlainMultipliers(totalRabbits);

                            if (totalRabbits.get(l).getThirst() < 8.0){
                                checkWater(totalRabbits, l);
                                checkWaterNext(totalRabbits, l);
                            }


                            if(totalRabbits.get(l).getHunger()<7.0){
                                if(trees.size()> 0){
                                    chaseAppleTrees(totalRabbits, l, l);
                                }

                            }else{
                                totalRabbits.get(l).changeLoc(gameGrid, totalRabbits.get(l).getNumAnimal() + totalRabbits.get(l).getMaleFemale());
                            }

                            if (totalPeople.size() != 0){
                                speciesInteraction(totalRabbits, totalPeople, l );
                            }
                            if (totalWolves.size()!= 0){
                                speciesInteraction(totalRabbits, totalWolves, l);
                            }


                            totalRabbits.get(l).resetStartTime();

                        }

                       if(now - totalRabbits.get(l).getHungerTime() > 9000000000.0){
                           creatureHungerUpdate(totalRabbits);
                           totalRabbits.get(l).resetHungerTime();

                       }

                       if(now - totalRabbits.get(l).getThirstTime() > 7000000000.0){
                           creatureThirstUpdate(totalRabbits);
                           totalRabbits.get(l).resetThirstTime();
                       }

                       if(now - totalRabbits.get(l).getReproduceTime() > 1000000000.0){

                           reproduceRabb(totalRabbits, gameGrid, l);
                       }
                    }
                }


                if(totalSalmon.size()>0){
                    for (int c = 0; c < totalSalmon.size(); c++) {

                        if ((double) (now - (totalSalmon.get(c)).getStartTime()) > 3000000000.0) {


                            restrictSalmonMovement();
                            totalSalmon.get(c).setAge(totalSalmon.get(c).getAge() + 1);



                            totalSalmon.get(c).ageSurvivalProbUpdate();
                            totalSalmon.get(c).resetStartTime();
                        }

                        if(now - totalSalmon.get(c).getHungerTime() > 9000000000.0){
                            creatureHungerUpdate(totalSalmon);
                            totalSalmon.get(c).resetHungerTime();

                        }

                        if(now - totalSalmon.get(c).getReproduceTime() > 1000000000.0){

                            reproduceRabb(totalSalmon, gameGrid, c);
                        }

                    }



                }




                updateScreen();
            }
        }).start();
    }

    public void determinePlainMultipliers(ArrayList<Animal> tempAnimal){

        for (int i = 0; i < tempAnimal.size(); i++) {
            for (int j = 0; j < plains.size(); j++) {
                if(tempAnimal.get(i).getxPos() == plains.get(j).getX() && tempAnimal.get(i).getyPos() == plains.get(j).getY()){
                    tempAnimal.get(i).setInitialSurvivalProbability(tempAnimal.get(i).getSurvivalProbability() * 2);
                    if(tempAnimal.get(i).getSurvivalProbability() > 1) {
                        tempAnimal.get(i).setInitialSurvivalProbability(1.0);
                    }
                    tempAnimal.get(i).setThirstBar(tempAnimal.get(i).getThirst() * 2);
                    tempAnimal.get(i).setHungerBar(tempAnimal.get(i).getHunger() * 2);
                    tempAnimal.get(i).setInitialSurvivalProbability(tempAnimal.get(i).getSurvivalProbability() * 1.5);

                }
            }

        }


    }

    private ArrayList<Location> tempLocs = new ArrayList<>();

    public boolean checkEmptyAroundMe(int i, int j){

        return gameGrid[i][j] == 0 || gameGrid[i][j] == 11 || gameGrid[i][j] == 12 || gameGrid[i][j] == 2
                ||gameGrid[i][j] == 4 ||gameGrid[i][j] == 3 ||gameGrid[i][j] == 5
                ||gameGrid[i][j] == 6 ||gameGrid[i][j] == 7 ||gameGrid[i][j] == 8 ||gameGrid[i][j] == 9 ||gameGrid[i][j] == 13;
    }

    public void reproducePerson(ArrayList<Animal> tempWolf, int tempGrid[][], int tempNum) {

        tempLocs.clear();
        for (int i = tempWolf.get(tempNum).getxPos() - 1; i < tempWolf.get(tempNum).getxPos() + 2; i++) {
            for (int j = tempWolf.get(tempNum).getyPos() - 1; j < tempWolf.get(tempNum).getyPos() + 2; j++) {
                if (tempWolf.get(tempNum).getxPos() < tempGrid.length && tempWolf.get(tempNum).getyPos() < tempGrid[0].length) {
                    if (checkEmptyAroundMe(i, j)) {

                        tempLocs.add(new Location(i, j));
                    }
                }
            }
        }
        if (tempWolf.get(tempNum).checkOppositeNeighbor(tempWolf, gameGrid)) {
            if (tempWolf.get(tempNum).getMaleFemale() == 1) {
                ///decides if animals will reproduce based off their reproduction probability that takes age, hunger, and thirst into account
                double reproductionDecider = Math.random();
                if (tempWolf.get(tempNum).getReproductionProbability() > reproductionDecider){
                    if (tempLocs.size() > 0) {
                        int newLoc = (int) (Math.random() * tempLocs.size());
                        tempWolf.add(new People("Person", tempLocs.get(newLoc).getX(), tempLocs.get(newLoc).getY(), 1, 20.0, 10.0, 0.05, 0.1, 1));
                        tempGrid[tempWolf.get(tempWolf.size() - 1).getxPos()][tempWolf.get(tempWolf.size() - 1).getyPos()] = 1;
                        tempWolf.get(tempNum).resetReproduceTime();
                    }

                }else if (tempWolf.get(tempNum).getReproductionProbability() <= reproductionDecider) {
                    /// animal does not reproduce
                    tempWolf.get(tempNum).resetReproduceTime();
                    }
            }
        }
    }

    public void reproduceWolf(ArrayList<Animal> tempWolf, int tempGrid[][], int tempNum){
        tempLocs.clear();

        for(int i = tempWolf.get(tempNum).getxPos() -1; i< tempWolf.get(tempNum).getxPos() +2;i++){
            for(int j = tempWolf.get(tempNum).getyPos()-1;j<tempWolf.get(tempNum).getyPos()+2;j++){
                if(tempWolf.get(tempNum).getxPos()<tempGrid.length && tempWolf.get(tempNum).getyPos() <tempGrid[0].length){
                    if(checkEmptyAroundMe(i,j)){


                        tempLocs.add(new Location(i,j));
                    }
                }
            }
        }

        if (tempWolf.get(tempNum).checkOppositeNeighbor(tempWolf, gameGrid)) {
            if (tempWolf.get(tempNum).getMaleFemale() == 1) {
                ///decides if animals will reproduce based off their reproduction probability that takes age, hunger, and thirst into account
                double reproductionDecider = Math.random();
                if (tempWolf.get(tempNum).getReproductionProbability() > reproductionDecider){
                    if (tempLocs.size() > 0) {
                        int newLoc = (int) (Math.random() * tempLocs.size());
                        tempWolf.add(new Animal("Wolf",  tempLocs.get(newLoc).getX(), tempLocs.get(newLoc).getY(), 1, 20.0, 10.0, 0.35, 0.1, 2));
                        lblWolvesMale.setText("Male Rabbits: " + tempWolf.size());
                        tempGrid[tempWolf.get(tempWolf.size() - 1).getxPos()][tempWolf.get(tempWolf.size() - 1).getyPos()] = tempWolf.get(tempNum).getNumAnimal();
                        tempWolf.get(tempNum).resetReproduceTime();
                    }

                }else if (tempWolf.get(tempNum).getReproductionProbability() <= reproductionDecider) {
                    /// animal does not reproduce
                    tempWolf.get(tempNum).resetReproduceTime();
                }
            }
        }

    }

    public void reproduceRabb(ArrayList<Animal> tempRab, int tempGrid[][], int tempNum) {

        tempLocs.clear();
        for (int i = tempRab.get(tempNum).getxPos() - 1; i < tempRab.get(tempNum).getxPos() + 2; i++) {
            for (int j = tempRab.get(tempNum).getyPos() - 1; j < tempRab.get(tempNum).getyPos() + 2; j++) {
                if (tempRab.get(tempNum).getxPos() < tempGrid.length && tempRab.get(tempNum).getyPos() < tempGrid[0].length) {
                    if (checkEmptyAroundMe(i, j)) {

                        tempLocs.add(new Location(i, j));
                    }
                }
            }
        }
        if (tempRab.get(tempNum).checkOppositeNeighbor(tempRab, gameGrid)) {
            if (tempRab.get(tempNum).getMaleFemale() == 1) {
                ///decides if animals will reproduce based off their reproduction probability that takes age, hunger, and thirst into account
                double reproductionDecider = Math.random();
                if (tempRab.get(tempNum).getReproductionProbability() > reproductionDecider){
                    if (tempLocs.size() > 0) {
                        int newLoc = (int) (Math.random() * tempLocs.size());
                        tempRab.add(new Animal("Rabbit",  tempLocs.get(newLoc).getX(), tempLocs.get(newLoc).getY(), 1, 10.0, 10.0, 0.02, 0.05, 5));
                        tempGrid[tempRab.get(tempRab.size() - 1).getxPos()][tempRab.get(tempRab.size() - 1).getyPos()] = 1;
                        tempRab.get(tempNum).resetReproduceTime();
                    }

                }else if (tempRab.get(tempNum).getReproductionProbability() <= reproductionDecider) {
                    /// animal does not reproduce
                    tempRab.get(tempNum).resetReproduceTime();
                }
            }
        }
    }

    public void reproducePigs(ArrayList<Animal> tempPig, int tempGrid[][], int tempNum){

        tempLocs.clear();
        for(int i = tempPig.get(tempNum).getxPos() -1; i< tempPig.get(tempNum).getxPos() +2;i++){
            for(int j = tempPig.get(tempNum).getyPos()-1;j<tempPig.get(tempNum).getyPos()+2;j++){
                if(tempPig.get(tempNum).getxPos()<tempGrid.length && tempPig.get(tempNum).getyPos() <tempGrid[0].length){
                    if(checkEmptyAroundMe(i,j)){

                        tempLocs.add(new Location(i,j));
                    }
                }
            }
        }
        if (tempPig.get(tempNum).checkOppositeNeighbor(tempPig, gameGrid)) {
            if (tempPig.get(tempNum).getMaleFemale() == 1) {
                ///decides if animals will reproduce based off their reproduction probability that takes age, hunger, and thirst into account
                double reproductionDecider = Math.random();
                if (tempPig.get(tempNum).getReproductionProbability() > reproductionDecider){
                    if (tempLocs.size() > 0) {
                        int newLoc = (int) (Math.random() * tempLocs.size());
                        tempPig.add(new Animal("Pigs", tempLocs.get(newLoc).getX(), tempLocs.get(newLoc).getY(), 1, 10.0, 10.0, 0.02, 0.07, 7));
                        lblPigsMale.setText("Male Pigs: " + tempPig.size());
                        tempGrid[tempPig.get(tempPig.size() - 1).getxPos()][tempPig.get(tempPig.size() - 1).getyPos()] = 1;
                        tempPig.get(tempNum).resetReproduceTime();
                    }

                }else if (tempPig.get(tempNum).getReproductionProbability() <= reproductionDecider) {
                    /// animal does not reproduce
                    tempPig.get(tempNum).resetReproduceTime();
                }
            }
        }
    }

    public void reproduceSalmon(ArrayList<Animal> tempPig, int tempGrid[][], int tempNum){

        tempLocs.clear();
        for(int i = tempPig.get(tempNum).getxPos() -1; i< tempPig.get(tempNum).getxPos() +2;i++){
            for(int j = tempPig.get(tempNum).getyPos()-1;j<tempPig.get(tempNum).getyPos()+2;j++){
                if(tempPig.get(tempNum).getxPos()<tempGrid.length && tempPig.get(tempNum).getyPos() <tempGrid[0].length){
                    if(checkEmptyAroundMe(i,j)){

                        tempLocs.add(new Location(i,j));
                    }
                }
            }
        }
        if (tempPig.get(tempNum).checkOppositeNeighbor(tempPig, gameGrid)) {
            if (tempPig.get(tempNum).getMaleFemale() == 1) {
                ///decides if animals will reproduce based off their reproduction probability that takes age, hunger, and thirst into account
                double reproductionDecider = Math.random();
                if (tempPig.get(tempNum).getReproductionProbability() > reproductionDecider){
                    if (tempLocs.size() > 0) {
                        int newLoc = (int) (Math.random() * tempLocs.size());
                        tempPig.add(new Animal("Salmon", tempLocs.get(newLoc).getX(), tempLocs.get(newLoc).getY(), 1, 10.0, 10.0, 0.02, 0.07, 9));

                        tempGrid[tempPig.get(tempPig.size() - 1).getxPos()][tempPig.get(tempPig.size() - 1).getyPos()] = 1;
                        tempPig.get(tempNum).resetReproduceTime();
                    }

                }else if (tempPig.get(tempNum).getReproductionProbability() <= reproductionDecider) {
                    /// animal does not reproduce
                    tempPig.get(tempNum).resetReproduceTime();
                }
            }
        }
    }



    // determines who survives in an interaction depending on their hunger
    public void speciesInteraction(ArrayList<Animal> animal1, ArrayList<Animal> animal2, int temp) {


        for(int i = 0; i<animal2.size(); i++){

            if (animal1.get(temp).checkOppositeNeighbor(animal2, gameGrid)) {
                if (animal1.get(temp).getHunger() > 12) {
                    if (animal1.get(temp).getSurvivalProbability() > animal2.get(i).getSurvivalProbability()) {
                        animal2.get(i).setInitialSurvivalProbability(0.0);
                        animal2.get(i).checkSurvivalProb(animal2,i,gameGrid);

                        System.out.println("deadAnimal");
                        animal1.get(temp).setHungerBar(animal1.get(temp).getHunger() + 5);
                    } else if (animal2.get(i).getSurvivalProbability() > animal1.get(temp).getSurvivalProbability()) {
                        animal1.get(temp).setInitialSurvivalProbability(0.0);
                        animal1.get(temp).checkSurvivalProb(animal1,temp, gameGrid);

                        System.out.println("deadAnimal2");
                        animal2.get(i).setHungerBar(animal2.get(i).getHunger() + 5);
                    }
                }
            }
        }


    }

    public void creatureThirstUpdate(ArrayList<Animal> animalUpdate) {

        for(int i = 0; i< animalUpdate.size(); i++){
            animalUpdate.get(i).setThirstBar(animalUpdate.get(i).getThirst() - 0.5);
            animalUpdate.get(i).resetThirstTime();
            ///thirst causes animal to have a lesser ability to reproduce along with becoming weaker
            if (animalUpdate.get(i).getThirst() < 10) {
                animalUpdate.get(i).setReproductionProbabilityDecrease();
                animalUpdate.get(i).setInitialSurvivalProbabilityDecrease();
            }
        }
        }


    public void creatureHungerUpdate(ArrayList<Animal> animalUpdate) {

        for(int i = 0; i<animalUpdate.size(); i++) {
            animalUpdate.get(i).setHungerBar(animalUpdate.get(i).getThirst() - 0.5);
            animalUpdate.get(i).resetHungerTime();
            ///thirst causes animal to have a lesser ability to reproduce along with becoming weaker
            if (animalUpdate.get(i).getHunger() < 7.5) {
                animalUpdate.get(i).setReproductionProbabilityDecrease();
                animalUpdate.get(i).setInitialSurvivalProbabilityDecrease();
            }
        }

    }


     public void checkCactus(ArrayList<Animal> tempAnimal, int tempNum){

        ///inflicts damage as it is next to cactus
             if (checkOppositeEnvironmentNeighbor(tempAnimal, cactus, gameGrid, tempNum)){
                 tempAnimal.get(tempNum).setInitialSurvivalProbability(tempAnimal.get(tempNum).getSurvivalProbability() - 0.10);
                 System.out.println(tempAnimal.get(tempNum).getAnimalName() + " was hurt by cactus");
             }

     }

    public void checkAppleTree(ArrayList<Animal> tempAnimal, int tempNum){

        for (int i = 0; i < trees.size() ; i++) {
            ///inflicts damage as it is next to cactus
            if (checkOppositeEnvironmentNeighbor(tempAnimal, trees, gameGrid, tempNum)){

                if(tempAnimal.get(tempNum).getHunger() < 9.0){
                    tempAnimal.get(tempNum).setHungerBar(tempAnimal.get(tempNum).getHunger() + 3.0);
                    trees.remove(i);
                }


            }
        }


    }

    public boolean checkOppositeEnvironmentNeighbor(ArrayList<Animal> animal1, ArrayList<Environment> tempSpecies, int[][] tempGrid, int tempNum) {
        for(int i = 0; i < tempSpecies.size(); ++i) {
            if ((tempSpecies.get(i)).getX() >= animal1.get(tempNum).getxPos() - 1 && (tempSpecies.get(i)).getX() <= animal1.get(tempNum).getxPos() + 1 && (tempSpecies.get(i)).getY() >= animal1.get(tempNum).getxPos() - 1
                    && (tempSpecies.get(i)).getY()<= animal1.get(tempNum).getyPos() + 1 && (tempSpecies.get(i)).getX() != animal1.get(tempNum).getxPos()
                    && (tempSpecies.get(i)).getY() != animal1.get(tempNum).getyPos()) {
                return true;
            }
        }

        return false;
    }

    public void chaseTrees(Environment tempTrees, int[][]gameGrid, ArrayList<Animal> tempAnimal, int temp){



        int animal = tempAnimal.get(temp).getNumAnimal() + tempAnimal.get(temp).getMaleFemale();
        int tempx = tempAnimal.get(temp).getxPos();
        int tempy = tempAnimal.get(temp).getyPos();
        if(tempx- tempTrees.getX() > 0){
            tempx--;
        }else if(tempx - tempTrees.getX() < 0){
            tempx++;
        }
        if(tempy- tempTrees.getY() > 0){
            tempy--;
        }else if(tempy - tempTrees.getY() < 0){
            tempy++;
        }

        gameGrid[tempx][tempy] = animal;

        if (tempAnimal.get(temp).getxPos() > 4 && tempAnimal.get(temp).getxPos()  <= 19 && tempAnimal.get(temp).getyPos() >= 15 && tempAnimal.get(temp).getyPos() <= 29) {
            gameGrid[tempAnimal.get(temp).getxPos()][tempAnimal.get(temp).getyPos()] = 11;
            System.out.println("HUBDKSIHL");

        } else {
            gameGrid[tempAnimal.get(temp).getxPos() ][tempAnimal.get(temp).getyPos()] = 0;
        }

        tempAnimal.get(temp).setxPos(tempx);
        tempAnimal.get(temp).setyPos(tempy);
        System.out.println("JHGABLIDH");

    }



        public void chaseAppleTrees(ArrayList<Animal> herbivore, int tempNum,int z ){

            int minDistance = 150;
            int position = tempNum;

            for(int j = 0; j<trees.size(); j++){

                int temp = distance(herbivore.get(tempNum).getxPos(),trees.get(j).getX(),herbivore.get(tempNum).getyPos(),trees.get(j).getY());
                if(temp<minDistance){
                    minDistance = temp;
                    position = j;
                }

            }
            // System.out.println(place);
            System.out.println("JHGABLIDH");
            chaseTrees(trees.get(position), gameGrid, herbivore, z);

        }

        public void checkNearestPig(ArrayList<Animal> tempAnimal,int i){

            int minDistance = 150;
            int position = i;

            for(int j = 0; j<totalPigs.size(); j++){

                int temp = distance(tempAnimal.get(i).getxPos(),totalPigs.get(j).getxPos(),tempAnimal.get(i).getyPos(),totalPigs.get(j).getyPos());
                if(temp<minDistance){
                    minDistance = temp;
                    position = j;
                }

            }

                tempAnimal.get(i).chase(totalPigs.get(position),gameGrid, tempAnimal.get(i).getNumAnimal() + tempAnimal.get(i).getMaleFemale());

            // System.out.println(place);

        }

        public void checkNearestPerson(ArrayList<Animal> tempAnimal,int i){

            int minDistance = 150;
            int position = i;

            for(int j = 0; j<totalPeople.size(); j++){

                int temp = distance(tempAnimal.get(i).getxPos(),totalPeople.get(j).getxPos(),tempAnimal.get(i).getyPos(),totalPeople.get(j).getyPos());
                if(temp<minDistance){
                    minDistance = temp;
                    position = j;
                }

            }

                tempAnimal.get(i).chase(totalPeople.get(position),gameGrid, tempAnimal.get(i).getNumAnimal() + tempAnimal.get(i).getMaleFemale());

            // System.out.println(place);

        }

        public void checkNearestRabbit(ArrayList<Animal> tempAnimal, int i){

            int minDistance = 150;
            int position = i;

            for(int j = 0; j<totalRabbits.size(); j++){

                int temp = distance(tempAnimal.get(i).getxPos(),totalRabbits.get(j).getxPos(),tempAnimal.get(i).getyPos(),totalRabbits.get(j).getyPos());

                if(temp<minDistance){
                    minDistance = temp;
                    position = j;
                }

            }

                tempAnimal.get(i).chase(totalRabbits.get(position),gameGrid, tempAnimal.get(i).getNumAnimal() + tempAnimal.get(i).getMaleFemale());


            // System.out.println(place);
        }




    public void checkWater(ArrayList<Animal> tempAnimal, int i){

        int minDistance = 225;
        int position = i;

        for(int j = 0; j<lake.size(); j++){

            int temp = distance(tempAnimal.get(i).getxPos(),lake.get(j).getX(),tempAnimal.get(i).getyPos(),lake.get(j).getY());

            if(temp<minDistance){
                minDistance = temp;
                position = j;
            }

        }

        tempAnimal.get(i).chaseWater(lake.get(position), gameGrid, tempAnimal, i, lake);


        // System.out.println(place);
    }

    public void checkWaterNext(ArrayList<Animal> tempAnimal, int tempNum){

        for (int i = 0; i < lake.size() ; i++) {
            ///inflicts damage as it is next to cactus
            if (checkOppositeEnvironmentNeighbor(tempAnimal, lake, gameGrid, tempNum)){

                if(tempAnimal.get(tempNum).getThirst() < 9.0){
                    tempAnimal.get(tempNum).setHungerBar(tempAnimal.get(tempNum).getThirst() + 4.0);

                }
            }
        }


    }


//    public long checkAmountOfTimeInWater(ArrayList<Animal> tempAnimal, int tempNum){
//
//
//
//            if( tempAnimal.get(tempNum).getxPos() > 21 && tempAnimal.get(tempNum).getyPos() >= 30 && tempAnimal.get(tempNum).getxPos() <= 30 && tempAnimal.get(tempNum).getyPos() <= 39){
//                tempAnimal.get(tempNum).resetSwimTime();
//            }else{
//
//                tempAnimal.get(tempNum).setSwimTime();
//            }
//
//
//
//
//        return tempAnimal.get(tempNum).getSwimTime();
//
//    }

    ///distance formula to calculate distance between animals
    public int distance(int x1, int x2, int y1, int y2){

        double d;
        d = sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        int temp = (int)d;
        return temp;
    }




        public void restrictSalmonMovement() {


            for (int i = 0; i < totalSalmon.size(); i++) {

                if (totalSalmon.get(i).getxPos() >= 22 && totalSalmon.get(i).getxPos() <= 30 && totalSalmon.get(i).getyPos() >= 31 && totalSalmon.get(i).getyPos() <= 39) {
                    int tempx = totalSalmon.get(i).getxPos();
                    int tempy = totalSalmon.get(i).getyPos();
                    if (Math.random() > 0.5D) {
                        ++tempx;
                    } else {
                        --tempx;
                    }


                    if (Math.random() > 0.5D) {
                        ++tempy;
                    } else {
                        --tempy;
                    }


                    if (tempx >= 21 && tempy >= 30 && tempx <= 30 && tempy <= 39) {
                        if (gameGrid[tempx][tempy] == 2) {

                            if (totalSalmon.get(i).getMaleFemale() == 0) {
                                gameGrid[tempx][tempy] = totalSalmon.get(i).getNumAnimal();
                                System.out.println("male: " + gameGrid[tempx][tempy]);
                            } else if ( totalSalmon.get(i).getMaleFemale() == 1) {
                                gameGrid[tempx][tempy] =  totalSalmon.get(i).getNumAnimal() + 1;
                                System.out.println("Female: " + gameGrid[tempx][tempy]);
                            }

                            gameGrid[totalSalmon.get(i).getxPos()][ totalSalmon.get(i).getyPos()] = 2;
                            totalSalmon.get(i).setxPos(tempx);
                            totalSalmon.get(i).setyPos(tempy);
                        }
                    }
                }


            }
        }




//
//    public void pieChartData(){
//
//
//        ObservableList<PieChart.Data> pieChartData =
//                FXCollections.observableArrayList(
//                        new PieChart.Data("People", 13),
//                        new PieChart.Data("Rabbits", 25),
//                        new PieChart.Data("Pigs", 10),
//                        new PieChart.Data("Salmon", 22),
//                        new PieChart.Data("Wolves", 30));
//
//        final PieChart chart = new PieChart(pieChartData);
//        chart.setTitle("Animals");
//
//    }
//
//


}


