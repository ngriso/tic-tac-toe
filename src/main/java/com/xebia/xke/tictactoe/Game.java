package com.xebia.xke.tictactoe;

import java.util.Arrays;

public class Game {

    Board board = new Board();

    public Result run(Player p1, Player p2) {

        System.out.println(p1.name + " is player 1");
        System.out.println(p2.name + " is player 2");

        return run(p1.strategy, p2.strategy);
    }

    public Result run(Strategy s1, Strategy s2) {
        board = new Board();
        Strategy winner = play(s1, s2, 1);

        if (!board.isBoardWinning) {
            return Result.NO_WINNER;
        }
        return winner == s1 ? Result.PLAYER1_WIN : Result.PLAYER2_WIN;
    }

    Strategy play(Strategy s1, Strategy s2, int currentPlayer) {
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
                throw new IllegalArgumentException(String.format("field %s is already taken", field));
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

    public enum Result {
        NO_WINNER,
        PLAYER1_WIN,
        PLAYER2_WIN
    }
}