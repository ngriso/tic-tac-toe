package com.xebia.xke;

import java.util.Arrays;

public class Game {

    Board board = new Board();

    public void run(Strategy s1, Strategy s2) {
        Strategy winner = play(s1, s2, 1);
        System.out.println(board.isBoardWinning ? winner + " has won" : "Game over");
    }

    public Strategy play(Strategy s1, Strategy s2, int currentPlayer) {
        int field = s1.play(this.board.copy());
        board.play(field, currentPlayer);
        return board.isBoardWinning || board.isFull ? s1 : play(s2, s1, currentPlayer * -1);
    }

    public static class Board {
        public int[] grid = new int[9];
        public int nbFieldTaken;
        public boolean isBoardWinning;
        public boolean isFull;

        public void play(int field, int player) {
            if (grid[field] != 0) {
                throw new IllegalArgumentException("field already taken");
            }
            nbFieldTaken++;
            grid[field] = player;
            isBoardWinning =
                    Math.abs(grid[(field / 3 * 3)] + grid[1 + field / 3 * 3] + grid[2 + field / 3 * 3]) == 3 ||
                            Math.abs(grid[(field % 3)] + grid[3 + field % 3] + grid[6 + field % 3]) == 3 ||
                            Math.abs(grid[0] + grid[4] + grid[8]) == 3 ||
                            Math.abs(grid[6] + grid[4] + grid[2]) == 3;
            isFull = nbFieldTaken == 9;
        }

        public Board copy() {
            Board board = new Board();
            board.grid = Arrays.copyOf(this.grid, 9);
            board.nbFieldTaken = this.nbFieldTaken;
            board.isBoardWinning = this.isBoardWinning;
            board.isFull = this.isFull;
            return board;
        }
    }

    public static interface Strategy {
        int play(Board board);
    }
}