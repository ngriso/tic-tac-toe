package com.xebia.xke.tictactoe.strategy;

import com.xebia.xke.tictactoe.Game;
import com.xebia.xke.tictactoe.Game;

public class LastFieldEmptyStrategy implements Game.Strategy {
    public int play(Game.Board board) {
        for (int x = 8; x >= 0; x--) {
            if (board.grid[x] == 0) {
                return x;
            }
        }
        throw new IllegalArgumentException("no empty field");
    }
}
