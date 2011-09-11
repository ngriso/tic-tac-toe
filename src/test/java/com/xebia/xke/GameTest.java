package com.xebia.xke;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void can_take_field_if_not_taken() {
        final Game game = new Game();
        game.grid = new int[]{
                1, 1, -1,
                -1, 1, -1,
                0, -1, 1};
        game.play(6, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_take_field_if_taken() {
        final Game game = new Game();
        game.grid = new int[]{
                1, 1, -1,
                -1, 1, -1,
                0, -1, 1};
        game.play(1, 1);
    }

    @Test
    public void player_wins_if_row1_is_taken(){
        final Game game = new Game();
        game.grid = new int[]{
                1, 1, 0,
                -1, -1, 0,
                0, 0, 0};
        boolean hasWon = game.isBoardWinnning(2);
        assertTrue(hasWon);
    }

    @Test
    public void player_wins_if_row2_is_taken(){
        final Game game = new Game();
        game.grid = new int[]{
                1, 1, 0,
                -1, -1, 0,
                0, 0, 0};
        boolean hasWon = game.isBoardWinnning(5);
        assertTrue(hasWon);
    }

    @Test
    public void player_wins_if_row3_is_taken(){
        final Game game = new Game();
        game.grid = new int[]{
                0, 0, 0,
                -1, -1, 0,
                1, 1, 0};
        boolean hasWon = game.isBoardWinnning(8);
        assertTrue(hasWon);
    }

    @Test
    public void player_wins_if_col1_is_taken(){
        final Game game = new Game();
        game.grid = new int[]{
                1, -1, 0,
                1, -1, 0,
                0, 0, 0};
        boolean hasWon = game.isBoardWinnning(6);
        assertTrue(hasWon);
    }

    @Test
    public void player_wins_if_col2_is_taken(){
        final Game game = new Game();
        game.grid = new int[]{
                1, -1, 0,
                1, -1, 0,
                0, 0, 0};
        boolean hasWon = game.isBoardWinnning(7);
        assertTrue(hasWon);
    }

    @Test
    public void player_wins_if_col3_is_taken(){
        final Game game = new Game();
        game.grid = new int[]{
                0, -1, 1,
                0, -1, 1,
                0, 0, 0};
        boolean hasWon = game.isBoardWinnning(8);
        assertTrue(hasWon);
    }

    @Test
    public void player_wins_if_diag1_is_taken(){
        final Game game = new Game();
        game.grid = new int[]{
                1, -1, -1,
                0, 1, 0,
                0, 0, 0};
        boolean hasWon = game.isBoardWinnning(8);
        assertTrue(hasWon);
    }

    @Test
    public void player_wins_if_diag2_is_taken(){
        final Game game = new Game();
        game.grid = new int[]{
                1, 1, -1,
                0, -1, 0,
                0, 0, 0};
        boolean hasWon = game.isBoardWinnning(6);
        assertTrue(hasWon);
    }

    @Test
    public void should_be_over_when_player_owns_column() {
        final Game game = new Game();
        game.grid = new int[]{
                1, 0, -1,
                1, -1, 0,
                1, 0, -1};
        assertTrue(game.isBoardWinnning(0));
    }

    @Test
    public void should_be_over_when_player_owns_rows() {
        final Game game = new Game();
        game.grid = new int[]{
                1, 1, 1,
                -1, 1, -1,
                0, -1, 0};
        assertTrue(game.isBoardWinnning(0));
    }

    @Test
    public void should_be_over_when_player_owns_diagonal() {
        final Game game = new Game();
        game.grid = new int[]{
                1, 1, -1,
                -1, 1, -1,
                0, -1, 1};
        assertTrue(game.isBoardWinnning(0));
    }

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

    public static void print(Game game) {
        for (int i = 0; i < game.grid.length; i++) {
            System.out.print(game.grid[i]);
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }

        }
    }
}
