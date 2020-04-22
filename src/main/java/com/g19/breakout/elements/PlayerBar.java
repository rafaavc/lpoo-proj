package com.g19.breakout.elements;

public class PlayerBar extends Element {
    public PlayerBar(Position position, String stringRep, String color) {
        super(position, stringRep, color);
    }

    public void moveRight() {
        position = new Position(position.getX()+1, position.getY());
    }

    public void moveLeft() {
        position = new Position(position.getX()-1, position.getY());
    }
}
