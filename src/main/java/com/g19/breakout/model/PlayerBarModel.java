package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;

public class PlayerBarModel extends ElementModel {
    public PlayerBarModel(Position position) {
        super(position, new Dimensions(6, 1));
    }

    public void moveRight() {
        position = new Position(position.getX()+1, position.getY());
    }

    public void moveLeft() {
        position = new Position(position.getX()-1, position.getY());
    }
}
