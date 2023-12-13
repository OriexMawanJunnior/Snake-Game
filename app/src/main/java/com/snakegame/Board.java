package com.snakegame;

public class Board {
    int width;
    int height;
    int cellSize;   // Size of each cell inside playing area

    Board(){
        this.width = 100;
        this.height = 100;
        this.cellSize = 8;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public int getCellSize(){
        return this.cellSize;
    }
}