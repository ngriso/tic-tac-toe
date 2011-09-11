package com.xebia.xke;

public class Game {

    public int[] grid = new int[9];
    int nbFieldTaken;

    public void run(Strategy s1, Strategy s2) {
        play(s1, s2, 1);
    }

    boolean play(Strategy s1, Strategy s2, int player) {
        int field = s1.play(this);
        play(field, player);
        return isBoardWinnning(field) || isGameOver() || play(s2, s1, -1 * player);
    }

    boolean isGameOver() {
        return nbFieldTaken == 9;
    }

    boolean isBoardWinnning(int field) {
        return isRowWinning(field / 3) || isColumnWinning(field % 3) || areDiagonalsWinning();
    }

    void play(int field, int player) {
        if (grid[field] != 0) {
            throw new IllegalArgumentException("field already taken");
        }
        nbFieldTaken++;
        grid[field] = player;
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

    public boolean isWinning(int sum) {
        return Math.abs(sum) == 3;
    }

    public static interface Strategy {
        int play(Game game);
    }
}