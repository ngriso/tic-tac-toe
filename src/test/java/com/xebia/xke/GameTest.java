package com.xebia.xke;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void run() {
        final Game game = new Game();
        game.run(new FirstFieldEmptyStrategy(), new FirstFieldEmptyStrategy());
        print(game);
    }

    @Test
    public void run2() {
        final Game game = new Game();
        game.run(new FirstFieldEmptyStrategy(), new LastFieldEmptyStrategy());
        print(game);
    }

    @Test
    public void run3() {
        final Game game = new Game();
        game.run(new FirstFieldEmptyStrategy(), new EvenFieldsStrategy());
        print(game);
    }

    public static void print(Game game) {
        for (int i = 0; i < game.board.grid.length; i++) {
            System.out.print(game.board.grid[i]);
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }

        }
    }
}
