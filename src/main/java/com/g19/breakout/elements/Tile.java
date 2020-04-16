package com.g19.breakout.elements;

public class Tile extends Element {
    int life;

    public Tile(Position position, int life) {
        super(position);
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
