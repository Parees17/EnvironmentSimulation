package com.example.safarisimulator;

import java.util.ArrayList;

public class Environment  {
    private int x;
    private int y;

    private long startTime;



    public Environment(int x, int y){

        this.x = x;
        this.y = y;
        startTime = System.nanoTime();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public long getStartTime() {
        return startTime;
    }


}
