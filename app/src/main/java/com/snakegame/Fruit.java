package com.snakegame;

import java.util.Random;

public class Fruit {
    private int color;
    private int x, y;
    private Random rand;

    Fruit(){
        this.color = 0;
        this.x = 0;
        this.y = 0;
        this.rand = new Random();
    }

    // Generate new fruit
    public void newFruit(Board board, Snake snake, Player player) {
        start: while (true) {
            // Randomize fruit location inside playing area
            setX(rand.nextInt(board.getWidth()));
            setY(rand.nextInt(board.getHeight()));

            // Handling fruit location if occupied by snake's body
            for (Cell c : snake.bodyCells) {
                if (c.x == getX() && c.y == getY()) {
                    continue start;
                }
            }

            setColor();
            player.incrementScore();
            break;

        }
    }

    public void setColor(){
        this.color = rand.nextInt(5);
    }

    public int getColor(){
        return this.color;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

}