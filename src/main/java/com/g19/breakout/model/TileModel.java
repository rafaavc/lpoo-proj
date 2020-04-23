package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;

public class TileModel extends ElementModel {
    int life;

    public TileModel(Position position, String stringRep, String color, int life) {
        super(position, new Dimensions(1, 1)/*, stringRep, color*/);
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
