package com.snakeladder;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PROJECT_NAME : LLDSnakeLadderGame
 * @PACKAGE_NAME : com.snakeladder
 * @CREATED_BY : nikhilupadhyay

 **/

public class Game {
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Board board;
    Player winnerPlayer;

    public Game(){
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winnerPlayer = null;
        addPlayer();
    }

    private void addPlayer() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void startGame(){
        while (winnerPlayer == null){
            Player currentPlayer = findPlayerTurn();
            System.out.println("player turn is:" + currentPlayer.id + " current position is: " + currentPlayer.currentPosition);

            int diceCount = dice.rollDice();
            int playerNewPosition = currentPlayer.currentPosition + diceCount;
            playerNewPosition = checkJump(playerNewPosition);
            currentPlayer.currentPosition = playerNewPosition;

            System.out.println("player turn is:" + currentPlayer.id + " new Position is: " + playerNewPosition);

            if(playerNewPosition >= board.cells.length * board.cells.length-1){
                winnerPlayer = currentPlayer;
            }

        }
        System.out.println("WINNER IS:" + winnerPlayer.id);
    }

    private int checkJump(int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length - 1){
            return playerNewPosition;
        }
        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition){
            String jumpBy = cell.jump.start > cell.jump.end ? "Snake" : "Ladder";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }
}
