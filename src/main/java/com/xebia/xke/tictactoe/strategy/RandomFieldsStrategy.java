package com.xebia.xke.tictactoe.strategy;

import com.xebia.xke.tictactoe.Game;
import com.xebia.xke.tictactoe.Game;

import java.util.Random;

public class RandomFieldsStrategy implements Game.Strategy {
    public int play(Game.Board board) {
        int x = new Random(System.currentTimeMillis()).nextInt(9);
        while (board.grid[x] != 0) {
            x = new Random(System.currentTimeMillis()).nextInt(9);
        }
        return x;
    }
}
