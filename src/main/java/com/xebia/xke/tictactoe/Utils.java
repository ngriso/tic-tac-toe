package com.xebia.xke.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static void printBoard(Game.Board board) {
        for (int i = 0; i < board.grid.length; i++) {
            System.out.print(getSymbol(board.grid[i]));
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    public static String getSymbol(int fieldValue) {
        return symbols.get(fieldValue);
    }

    private static Map<Integer, String> symbols = new HashMap<Integer, String>() {{
        put(1, "x");
        put(-1, "o");
        put(0, ".");
    }};
}
