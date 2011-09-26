package com.xebia.xke.tictactoe;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class BoardTest {

    @Test(expected = IllegalArgumentException.class)
    public void cant_play_twice_on_the_same_field() {
        Game.Board board = new Game.Board();
        board.grid = new int[]{
                1, 0, 0,
                0, 0, 0,
                0, 0, 0
        };

        board.play(0, -1);
    }

    @Test
    public void board_should_be_full_when_all_field_are_played() {
        Game.Board board = new Game.Board();
        board.grid = new int[]{
                0, 0, 0,
                0, 0, 0,
                0, 0, 0
        };

        for (int i = 0; i < board.grid.length; i++) {
            board.play(i, 1);
        }

        assertTrue(board.isFull);
    }

    @Test
    public void should_be_a_winner_when_a_row_is_taken() {
        Game.Board board = new Game.Board();
        board.grid = new int[]{
                1, 1, 0,
                0, 0, 0,
                0, 0, 0
        };

        board.play(2, 1);
        assertTrue(board.isBoardWinning);
    }

    @Test
    public void should_be_a_winner_when_a_column_is_taken() {
        Game.Board board = new Game.Board();
        board.grid = new int[]{
                1, 0, 0,
                1, 0, 0,
                0, 0, 0
        };

        board.play(6, 1);
        assertTrue(board.isBoardWinning);
    }

    @Test
    public void should_be_a_winner_when_a_diagonal_is_taken() {
        Game.Board board = new Game.Board();
        board.grid = new int[]{
                1, 0, 0,
                0, 1, 0,
                0, 0, 0
        };

        board.play(8, 1);
        assertTrue(board.isBoardWinning);
    }
}
