package com.xebia.xke;

public class FirstFieldEmptyStrategy implements Game.Strategy {
    public int play(Game game) {
        for (int x = 0; x < 9; x++) {
            if (game.grid[x] == 0) {
                return x;
            }
        }
        throw new IllegalArgumentException("no empty field");
    }
}
