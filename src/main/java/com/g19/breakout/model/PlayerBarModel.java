package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;

public class PlayerBarModel extends ElementModel {
    public PlayerBarModel(Position position) {
        super(position, new Dimensions(10, 1));
    }

    // this will hold the player points and lives left, as well as any other info about the player
}
