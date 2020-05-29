package com.g19.breakout.model;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;


public abstract class ElementModel {
    private Position position;
    private Dimensions dimensions;

    public ElementModel(Position position, Dimensions dimensions) {
        this.position = position;
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

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
