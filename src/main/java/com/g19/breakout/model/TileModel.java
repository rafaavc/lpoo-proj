package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;

public class TileModel extends ElementModel {
    int life;

    public TileModel(Position position, Dimensions dim, int life) {
        super(position, dim);
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
