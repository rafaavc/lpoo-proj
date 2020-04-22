package com.g19.breakout.elements;

public class PlayerBar extends Element {
    public PlayerBar(Position position) {
        super(position);
    }

    public String getStringRep() {
        return "██████";
    }

    public String getColor() {
        return "#ffffff";
    }
}
