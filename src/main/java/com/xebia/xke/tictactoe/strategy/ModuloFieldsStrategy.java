package com.xebia.xke.tictactoe.strategy;

import com.xebia.xke.tictactoe.Game;
import com.xebia.xke.tictactoe.Game;

public class ModuloFieldsStrategy implements Game.Strategy {
    public int play(Game.Board board) {
        for (int x = 0; x < 9; x++) {
            if (x % 4 == 0 && board.grid[x]==0) {
                return x;
            }
        }
        // fallback
        return new FirstFieldEmptyStrategy().play(board);
    }
}
