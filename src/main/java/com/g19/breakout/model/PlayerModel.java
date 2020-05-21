package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;

public class PlayerModel extends ElementModel {
    private int points;
    public PlayerModel(Position position) {
        super(position, new Dimensions(10, 1));
        points = 0;
    }

    public void addPoints(int p) {
        points += p;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
