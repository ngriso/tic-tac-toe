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
        Game.Result result = game.run(new FirstFieldEmptyStrategy(), new FirstFieldEmptyStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run2() {
        final Game game = new Game();
        Game.Result result = game.run(new FirstFieldEmptyStrategy(), new LastFieldEmptyStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run3() {
        final Game game = new Game();
        Game.Result result = game.run(new FirstFieldEmptyStrategy(), new EvenFieldsStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run3_bis() {
        final Game game = new Game();
        Game.Result result = game.run(new EvenFieldsStrategy(), new FirstFieldEmptyStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run4() {
        final Game game = new Game();
        Game.Result result = game.run(new EvenFieldsStrategy(), new EvenFieldsStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run5() {
        final Game game = new Game();
        Game.Result result = game.run(new OddFieldsStrategy(), new FirstFieldEmptyStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run6() {
        final Game game = new Game();
        Game.Result result = game.run(new ModuloFieldsStrategy(), new FirstFieldEmptyStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run6_bis() {
        final Game game = new Game();
        Game.Result result = game.run(new FirstFieldEmptyStrategy(), new ModuloFieldsStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run7() {
        final Game game = new Game();
        Game.Result result = game.run(new ModuloFieldsStrategy(), new ModuloFieldsStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run8() {
        final Game game = new Game();
        Game.Result result = game.run(new ModuloFieldsStrategy(), new LastFieldEmptyStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run9() {
        final Game game = new Game();
        Game.Result result = game.run(new RandomFieldsStrategy(), new ModuloFieldsStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }

    @Test
    public void run10() {
        final Game game = new Game();
        Game.Result result = game.run(new RandomFieldsStrategy(), new RandomFieldsStrategy());
        System.out.println("result = " + result);
        Utils.printBoard(game.board);
    }
}
