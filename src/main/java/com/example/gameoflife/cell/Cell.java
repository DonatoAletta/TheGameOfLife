package com.example.gameoflife.cell;

import lombok.*;


public class Cell {
    private int x;
    private int y;
    private boolean isAlive;
    private boolean nextState;

    public Cell(int x, int y, boolean isAlive, boolean nextState){
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
        this.nextState = nextState;
    }


    public void toggleLife(){
        isAlive = !isAlive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isNextState() {
        return nextState;
    }

    public void setNextState(boolean nextState) {
        this.nextState = nextState;
    }

    public void setState(boolean state){
        isAlive = state;
    }

    @Override
    public String toString() {
        return isAlive ? "x" : "0";
    }
}
