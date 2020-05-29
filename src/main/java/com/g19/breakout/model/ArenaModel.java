package com.g19.breakout.model;

import com.g19.breakout.elements.*;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.factory.ModelFactory;

import java.util.List;

public class ArenaModel {
    private final Dimensions dimensions;
    private final Position topLeftCorner;
    private final PlayerModel player;
    private final BallModel ball;
    private List<TileModel> tiles;

    public ArenaModel(Dimensions gameDimensions, ModelFactory factory) {
        this.dimensions = new Dimensions(gameDimensions.getDiscreteX(), gameDimensions.getDiscreteY()-6);
        this.topLeftCorner = new Position(0, 6);
        player = factory.createPlayerModel(dimensions);
        ball = factory.createBallModel(dimensions);
    }

    public TileModel checkHitTile(Position position) {
        for (TileModel tile : tiles) {
            Position tilePos = tile.getPosition();
            int tileHeight = tile.getDimensions().getDiscreteY();
            int ballHeight = ball.getDimensions().getDiscreteY();

            boolean isInsideY = position.getY() + ballHeight > tilePos.getY() && position.getY() < tilePos.getY() + tileHeight;

            if (isInsideY) {
                int ballHWidth = ball.getDimensions().getDiscreteX()/2;
                int tileHWidth = tile.getDimensions().getDiscreteX()/2;
                if (position.getDiscreteX() + ballHWidth > tilePos.getDiscreteX() - tileHWidth &&
                        position.getDiscreteX() - ballHWidth < tilePos.getDiscreteX() + tileHWidth)  return tile;
            }
        }
        return null;
    }

    public boolean checkHitPlayer(Position position, PlayerModel player) {
        return position.getDiscreteY() == player.getPosition().getDiscreteY() &&
                position.getDiscreteX() >= player.getPosition().getDiscreteX() - player.getDimensions().getDiscreteX()/2 &&
                position.getDiscreteX() <= player.getPosition().getDiscreteX() + player.getDimensions().getDiscreteX()/2;
    }

    public boolean isInsideArena(Position position, Dimensions dimension) {
        return position.getDiscreteX() >= dimension.getDiscreteX()/2 && position.getDiscreteX() <= getWidth() - dimension.getDiscreteX()/2
                && position.getDiscreteY() >= 0 && position.getDiscreteY() <= getHeight() - dimension.getDiscreteY()/2;
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