package com.g19.breakout.elements;

public class PlayerBar extends Element {
    public PlayerBar(Position position, String color) {
        super(position, "██████", color);
    }

    public void moveRight() {
        position = new Position(position.getX()+1, position.getY());
    }

    public void moveLeft() {
        position = new Position(position.getX()-1, position.getY());
    }
}
