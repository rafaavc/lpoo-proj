package com.g19.breakout.elements;

abstract class Element {
    Position position;

    Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
