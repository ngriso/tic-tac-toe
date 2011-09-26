package com.xebia.xke.tictactoe.strategy;

import com.xebia.xke.tictactoe.Game;

public class OddFieldsStrategy implements Game.Strategy {
    public int play(Game.Board board) {
        for (int x = 1; x < 9; x+=2) {
            if (board.grid[x] == 0) {
                return x;
            }
        }
        // fallback
        return new FirstFieldEmptyStrategy().play(board);
    }
}
