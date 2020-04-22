package com.g19.breakout.elements;

public class PlayerBar extends Element {
    public PlayerBar(Position position) {
        super(position);
    }

    public void moveRight() {
        position = new Position(position.getX()+1, position.getY());
    }

    public void moveLeft() {
        position = new Position(position.getX()-1, position.getY());
    }

    public String getStringRep() {
        return "██████";
    }

    public String getColor() {
        return "#ffffff";
    }
}
