package com.xebia.xke.tictactoe;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void should_player_play_one_after_other_till_the_board_is_full_and_no_winner() {
        Game game = new Game();

        final LinkedList<Integer> fieldToBePlayed =
                new LinkedList<Integer>(Arrays.asList(0, 2, 1, 3, 5, 4, 6, 7, 8));
        Game.Strategy s1 = new Game.Strategy() {
            public int play(Game.Board board) {
                return fieldToBePlayed.pollFirst();
            }
        };
        Game.Strategy s2 = new Game.Strategy() {
            public int play(Game.Board board) {
                return fieldToBePlayed.pollFirst();
            }
        };
        Game.Result result = game.run(s1, s2);

        assertEquals(Game.Result.NO_WINNER, result);
        assertTrue(game.board.isFull);
        assertFalse(game.board.isBoardWinning);
        int[] expectedBoard = {
                1, 1, -1,
                -1, -1, 1,
                1, -1, 1};
        assertArrayEquals(expectedBoard, game.board.grid);
    }

    @Test
    public void should_player_play_one_after_other_till_one_wins() {
        Game game = new Game();

        final LinkedList<Integer> fieldToBePlayed =
                new LinkedList<Integer>(Arrays.asList(0, 8, 1, 7, 2));
        Game.Strategy s1 = new Game.Strategy() {
            public int play(Game.Board board) {
                return fieldToBePlayed.pollFirst();
            }
        };
        Game.Strategy s2 = new Game.Strategy() {
            public int play(Game.Board board) {
                return fieldToBePlayed.pollFirst();
            }
        };
        Game.Result result = game.run(s1, s2);

        assertEquals(Game.Result.PLAYER1_WIN, result);
        assertFalse(game.board.isFull);
        assertTrue(game.board.isBoardWinning);
        int[] expectedBoard = {
                1, 1, 1,
                0, 0, 0,
                0, -1, -1};
        assertArrayEquals(expectedBoard, game.board.grid);
    }
}
