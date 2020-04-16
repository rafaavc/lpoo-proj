package com.g19.breakout.elements;

public class PlayerBar extends Element {
    PlayerBar(Position position) {
        super(position);
    }

    public void moveRight() {
        this.setPosition(this.getPosition().right());
    }

    public void moveLeft() {
        this.setPosition(this.getPosition().left());
    }
}
