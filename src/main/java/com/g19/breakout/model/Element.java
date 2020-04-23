package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;

public abstract class Element {
    Position position;
    Dimensions dimensions;
    String stringRep, color;

    public Element(Position position, String stringRep, String color, Dimensions dimensions) {
        this.position = position;
        this.stringRep = stringRep;
        this.color = color;
        this.dimensions = dimensions;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getStringRep() {
        return stringRep;
    }

    public String getColor() {
        return color;
    }
}
