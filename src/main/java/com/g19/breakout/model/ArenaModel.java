package com.g19.breakout.model;

import com.g19.breakout.elements.*;
import com.g19.breakout.model.factory.ArenaModelFactory;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel {
    private final Dimensions dimensions;
    private final Position topLeftCorner;
    private final PlayerModel player;
    private final BallModel ball;
    private List<TileModel> tiles;


    public ArenaModel(Dimensions gameDimensions, ArenaModelFactory factory) {
        this.dimensions = new Dimensions(gameDimensions.getDiscreteX(), gameDimensions.getDiscreteY()-6);
        this.topLeftCorner = new Position(0, 6);
        player = factory.createPlayerModel(dimensions);
        ball = factory.createBallModel(dimensions);
    }



    public int getHeight() {
        return dimensions.getDiscreteY();
    }

    public int getWidth() {
        return dimensions.getDiscreteX();
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public BallModel getBall() {
        return ball;
    }

    public List<TileModel> getTiles() {
        return tiles;
    }

    public void setTiles(List<TileModel> tiles) {
        this.tiles = tiles;
    }

    public Position getTopLeftCorner() {
        return topLeftCorner;
    }
}