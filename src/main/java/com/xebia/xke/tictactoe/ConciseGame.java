package com.xebia.xke.tictactoe;

public class ConciseGame {

    public int[] grid = new int[9];
    public int nbFieldTaken;
    public boolean isBoardWinning;

    public void run(Strategy s1, Strategy s2) {
        grid = new int[9];
        nbFieldTaken = 0;
        isBoardWinning = false;
        Strategy winner = play(s1, s2, 1);
        System.out.println(isBoardWinning ? winner + " has won" : "Game over");
    }

    Strategy play(Strategy s1, Strategy s2, int currentPlayer) {
        int field = s1.play(this);
        if (grid[field] != 0) {
            throw new IllegalArgumentException("field already taken");
        }
        grid[field] = currentPlayer;
        isBoardWinning =
                Math.abs(grid[(field / 3 * 3)] + grid[1 + field / 3 * 3] + grid[2 + field / 3 * 3]) == 3 ||
                        Math.abs(grid[(field % 3)] + grid[3 + field % 3] + grid[6 + field % 3]) == 3 ||
                        Math.abs(grid[0] + grid[4] + grid[8]) == 3 ||
                        Math.abs(grid[6] + grid[4] + grid[2]) == 3;
        return isBoardWinning || ++nbFieldTaken == 9 ? s1 : play(s2, s1, currentPlayer * -1);
    }

    public static interface Strategy {
        int play(ConciseGame game);
    }
}