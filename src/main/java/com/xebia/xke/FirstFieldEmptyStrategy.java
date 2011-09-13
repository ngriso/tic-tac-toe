package com.xebia.xke;

public class FirstFieldEmptyStrategy implements Game.Strategy {
    public int play(Game.Board board) {
        for (int x = 0; x < 9; x++) {
            if (board.grid[x] == 0) {
                return x;
            }
        }
        throw new IllegalArgumentException("no empty field");
    }
}
