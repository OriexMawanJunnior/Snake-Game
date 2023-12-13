package com.snakegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Draw {
    // Background color for playing area
    public void drawBackground(GraphicsContext gc, Board board){
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("363635"));
                } else {
                    gc.setFill(Color.web("595A4A"));
                }
                gc.fillRect(i * board.getCellSize(), j * board.getCellSize(), board.getCellSize(), board.getCellSize());
            }
        }
    }

    // Draw snake
    public void drawSnake(Snake snake){
        for (int i = snake.getBodySize() - 1; i >= 1; i--) {
            snake.bodyCells.get(i).x = snake.bodyCells.get(i - 1).x;
            snake.bodyCells.get(i).y = snake.bodyCells.get(i - 1).y;
        }
    }

    // Set snake's color and draw
    public void setSnakeColor(GraphicsContext gc, Board board, Snake snake){
        for (Cell c : snake.bodyCells) {
            gc.setFill(Color.YELLOW);
            gc.fillRect(c.x * board.getCellSize(), c.y * board.getCellSize(), board.getCellSize() - 1, board.getCellSize() - 1);
            gc.setFill(Color.ORANGE);
            gc.fillRect(c.x * board.getCellSize(), c.y * board.getCellSize(), board.getCellSize() - 3, board.getCellSize() - 3);
        }
    }

    // Draw moving snake
    public void moveSnake(Board board, Engine engine, Snake snake){
        // If snake's head hit playing area border, then the game is over
        switch (snake.getCurDirection()) {
            case UP -> {
                snake.bodyCells.get(0).y--;
                if (snake.bodyCells.get(0).y < 0) {
                    engine.setGameOver(true);
                    engine.setIsInGame(false);
                }
            }
            case DOWN -> {
                snake.bodyCells.get(0).y++;
                if (snake.bodyCells.get(0).y > board.getHeight()) {
                    engine.setGameOver(true);
                    engine.setIsInGame(false);

                }
            }
            case LEFT -> {
                snake.bodyCells.get(0).x--;
                if (snake.bodyCells.get(0).x < 0) {
                    engine.setGameOver(true);
                    engine.setIsInGame(false);

                }
            }
            case RIGHT -> {
                snake.bodyCells.get(0).x++;
                if (snake.bodyCells.get(0).x > board.getWidth()) {
                    engine.setGameOver(true);
                    engine.setIsInGame(false);

                }
            }
        }
    }

    // Snake's length increasing whenever ate a fruit
    public void increaseSnakeLength(Board board, Player playerGame, Snake snake, Fruit fruit){
        if (fruit.getX() == snake.bodyCells.get(0).x && fruit.getY() == snake.bodyCells.get(0).y) {
            snake.bodyCells.add(new Cell(-1, -1));  // New head for snake at index -1
            fruit.newFruit(board, snake, playerGame);
        }
    }

    // Game over when snake's head hitting its own body
    public void invalidSnakeMove(Engine engine, Snake snake){
        for (int i = 1; i < snake.getBodySize(); i++) {
            if (snake.bodyCells.get(0).x == snake.bodyCells.get(i).x && snake.bodyCells.get(0).y == snake.bodyCells.get(i).y) {
                engine.setGameOver(true);
            }
        }
    }

    // Draw fruit with randomized color
    public void drawFruit(GraphicsContext gc, Board board, Fruit fruit){
        // Randomize fruit's color
        Color cc = switch (fruit.getColor()) {
            case 0 -> Color.PURPLE;
            case 1 -> Color.LIGHTBLUE;
            case 2 -> Color.YELLOW;
            case 3 -> Color.PINK;
            case 4 -> Color.RED;
            default -> Color.WHITE;
        };

        // Draw fruit with randomized color
        gc.setFill(cc);
        gc.fillOval(fruit.getX() * board.getCellSize(), fruit.getY() * board.getCellSize(), board.getCellSize(), board.getCellSize());
    }

    // Showing player's current score
    public void drawPlayerScore(GraphicsContext gc, Player playerGame){
        gc.setFill(Color.CYAN);
        gc.setFont(new Font("Comic Sans MS", 30));
        gc.fillText("Score : " + playerGame.getScore(), 10, 30);
    }

    // Draw all components
    public void drawAllComponents(GraphicsContext gc, Engine engine, Board board, Player playerGame, Snake snake, Fruit fruit) {

        drawBackground(gc, board);

        setSnakeColor(gc, board, snake);
        drawSnake(snake);
        moveSnake(board, engine, snake);
        increaseSnakeLength(board, playerGame, snake, fruit);
        invalidSnakeMove(engine, snake);

        drawFruit(gc, board, fruit);

        drawPlayerScore(gc, playerGame);

    }
}