package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;

public class GameModel {
    private final Dimensions dimensions;

    public GameModel(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
