package com.snakeladder;

/**
 * @PROJECT_NAME : LLDSnakeLadderGame
 * @PACKAGE_NAME : com.snakeladder
 * @CREATED_BY : nikhilupadhyay
 **/

public class Player {
    String id;
    int currentPosition;

    public Player(String id, int currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
