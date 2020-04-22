package com.g19.breakout.elements;

public abstract class Element {
    Position position;
    Dimensions dimensions;
    String stringRep, color;

    Element(Position position, String stringRep, String color) {
        this.position = position;
        this.stringRep = stringRep;
        this.color = color;
        dimensions = new Dimensions(stringRep.length(), 1);
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
