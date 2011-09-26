package com.xebia.xke.tictactoe;

import com.xebia.xke.tictactoe.strategy.EvenFieldsStrategy;
import com.xebia.xke.tictactoe.strategy.FirstFieldEmptyStrategy;
import com.xebia.xke.tictactoe.strategy.LastFieldEmptyStrategy;
import com.xebia.xke.tictactoe.strategy.ModuloFieldsStrategy;
import com.xebia.xke.tictactoe.strategy.OddFieldsStrategy;
import com.xebia.xke.tictactoe.strategy.RandomFieldsStrategy;
import org.junit.Test;

public class Runs {

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

    @Test
    public void run3_bis() {
        final Game game = new Game();
        game.run(new EvenFieldsStrategy(), new FirstFieldEmptyStrategy());
        print(game);
    }

    @Test
    public void run4() {
        final Game game = new Game();
        game.run(new EvenFieldsStrategy(), new EvenFieldsStrategy());
        print(game);
    }

    @Test
    public void run5() {
        final Game game = new Game();
        game.run(new OddFieldsStrategy(), new FirstFieldEmptyStrategy());
        print(game);
    }

    @Test
    public void run6() {
        final Game game = new Game();
        game.run(new ModuloFieldsStrategy(), new FirstFieldEmptyStrategy());
        print(game);
    }

    @Test
    public void run6_bis() {
        final Game game = new Game();
        game.run(new FirstFieldEmptyStrategy(), new ModuloFieldsStrategy());
        print(game);
    }

    @Test
    public void run7() {
        final Game game = new Game();
        game.run(new ModuloFieldsStrategy(), new ModuloFieldsStrategy());
        print(game);
    }

    @Test
    public void run8() {
        final Game game = new Game();
        game.run(new ModuloFieldsStrategy(), new LastFieldEmptyStrategy());
        print(game);
    }

    @Test
    public void run9() {
        final Game game = new Game();
        game.run(new RandomFieldsStrategy(), new ModuloFieldsStrategy());
        print(game);
    }

    @Test
    public void run10() {
        final Game game = new Game();
        game.run(new ModuloFieldsStrategy(), new LastFieldEmptyStrategy());
        while (game.board.isBoardWinning) {
            game.run(new RandomFieldsStrategy(), new RandomFieldsStrategy());
        }
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
