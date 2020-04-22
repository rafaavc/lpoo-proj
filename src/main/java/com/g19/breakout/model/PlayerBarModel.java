package com.g19.breakout.model;

import com.g19.breakout.elements.Position;

public class PlayerBarModel extends Element {
    public PlayerBarModel(Position position, String color) {
        super(position, "██████", color);
    }

    public void moveRight() {
        position = new Position(position.getX()+1, position.getY());
    }

    public void moveLeft() {
        position = new Position(position.getX()-1, position.getY());
    }
}
