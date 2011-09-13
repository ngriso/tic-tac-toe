package com.xebia.xke;

import java.util.Arrays;

public class Game {

    public int[] grid = new int[9];
    int nbFieldTaken;
    private int currentPlayer;
    private int lastPlayedField;

    public Game copy() {
        Game game = new Game();
        game.grid = Arrays.copyOf(this.grid, 9);
        game.nbFieldTaken = this.nbFieldTaken;
        return game;
    }

    public void run(Strategy s1, Strategy s2) {
        currentPlayer = -1;
        play(s1, s2);
        boolean gameOver = isGameOver();
        if (gameOver) {
            System.out.println("Game over");
            return;
        }
        System.out.println(currentPlayer + " has won");
    }

    public boolean play(Strategy s1, Strategy s2) {
        currentPlayer *= -1;
        lastPlayedField = s1.play(this.copy());
        play();
        return isBoardWinnning() || isGameOver() || play(s2, s1);
    }

    public void play() {
        if (grid[lastPlayedField] != 0) {
            throw new IllegalArgumentException("field already taken");
        }
        nbFieldTaken++;
        grid[lastPlayedField] = currentPlayer;
    }

    public boolean isGameOver() {
        return nbFieldTaken == 9;
    }

    public boolean isBoardWinnning() {
        return isRowWinning(lastPlayedField / 3) || isColumnWinning(lastPlayedField % 3) || areDiagonalsWinning();
    }

    public boolean areDiagonalsWinning() {
        return isWinning(grid[0] + grid[4] + grid[8]) || isWinning(grid[6] + grid[4] + grid[2]);
    }

    public boolean isRowWinning(int y) {
        return isWinning(grid[y * 3] + grid[1 + y * 3] + grid[2 + y * 3]);
    }

    public boolean isColumnWinning(int x) {
        return isWinning(grid[x] + grid[3 + x] + grid[6 + x]);
    }

    private boolean isWinning(int sum) {
        return Math.abs(sum) == 3;
    }

    public static interface Strategy {
        int play(Game game);
    }
}