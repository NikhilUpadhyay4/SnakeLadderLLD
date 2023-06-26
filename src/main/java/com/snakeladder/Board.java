package com.snakeladder;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @PROJECT_NAME : LLDSnakeLadderGame
 * @PACKAGE_NAME : com.snakeladder
 * @CREATED_BY : nikhilupadhyay
 **/

public class Board {
    Cell[][] cells;

    Board(int boardSize, int snakeNumber, int ladderNumber){
        initializeCells(boardSize);
        addSnakesLadders(snakeNumber, snakeNumber);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i = 0 ; i < boardSize ; i++){
            for(int j = 0 ; j < boardSize ; j++){
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }

    private void addSnakesLadders(int numberOfSnakes, int numberOfLadders){
        while(numberOfSnakes > 0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(snakeHead <= snakeTail) continue;;

            Jump snakeJump = new Jump();
            snakeJump.start = snakeHead;
            snakeJump.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeJump;

            numberOfSnakes--;

        }

        while(numberOfLadders > 0){
            int ladderHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(ladderHead >= ladderTail) continue;;

            Jump ladderJump = new Jump();
            ladderJump.start = ladderHead;
            ladderJump.end = ladderTail;

            Cell cell = getCell(ladderHead);
            cell.jump = ladderJump;

            numberOfLadders--;

        }
    }

     Cell getCell(int playerPosition){
        int boardCol = playerPosition%10;
        int boardRow = playerPosition/10;
        return cells[boardRow][boardCol];
    }


}
