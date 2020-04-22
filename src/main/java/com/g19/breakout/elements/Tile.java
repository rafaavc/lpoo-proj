package com.g19.breakout.elements;

public class Tile extends Element {
    int life;

    public Tile(Position position, String stringRep, String color, int life) {
        super(position, stringRep, color);
        this.life = life;
    }

    // returns true if hit killed the tile
    public boolean hit() {
        life--;
        return life == 0;
    }

    public int getLife() {
        return life;
    }
}
