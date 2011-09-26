package com.xebia.xke.tictactoe;

import com.xebia.xke.tictactoe.strategy.FirstFieldEmptyStrategy;
import com.xebia.xke.tictactoe.strategy.UserCommandLineStrategy;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Game.Result result = game.run(new FirstFieldEmptyStrategy(), new UserCommandLineStrategy());

        System.out.println("\nResult = " + result);
        System.out.println("Final Board: ");
        Utils.printBoard(game.board);
    }
}
