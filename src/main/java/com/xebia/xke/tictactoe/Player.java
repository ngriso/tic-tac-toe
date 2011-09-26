package com.xebia.xke.tictactoe;

public class Player {

    public final String name;
    public final Game.Strategy strategy;

    public Player(String name, Game.Strategy strategy) {
        this.strategy = strategy;
        this.name = name;
    }
}
