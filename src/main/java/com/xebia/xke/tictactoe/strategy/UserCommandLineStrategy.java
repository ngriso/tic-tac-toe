package com.xebia.xke.tictactoe.strategy;

import com.xebia.xke.tictactoe.Game;
import com.xebia.xke.tictactoe.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserCommandLineStrategy implements Game.Strategy {
    public int play(Game.Board board) {

        System.out.println("\nHere is the board: ");
        Utils.printBoard(board);
        System.out.print("It's your go: ");

        while (true) {
            String input = readInput();
            try {
                int field = Integer.parseInt(input);
                if (field < 0 || field > 8) {
                    System.out.println("input should be a number between 0 and 8 (inclusive)");
                } else {
                    return field;
                }
            } catch (NumberFormatException e) {
                System.out.println("input should be a number between 0 and 8 (inclusive)");
            }
        }
    }

    private String readInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(1);
        }
        return input;
    }
}
