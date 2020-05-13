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
        player = factory.createPlayerModel(this);
        ball = factory.createBallModel(this);
    }

    public List<BallModel.HIT> checkBallCollisions(Position position, Dimensions dimensions) {
        List<BallModel.HIT> hits = new ArrayList<>();

        if (position.getDiscreteY() == -1) hits.add(BallModel.HIT.TOP);
        if (position.getDiscreteY() == getHeight() - dimensions.getDiscreteY() + 1) hits.add(BallModel.HIT.BOTTOM);
        if (checkHitPlayer(position)) hits.add(BallModel.HIT.PLAYERBAR);

        TileModel tile = checkHitTile(position);
        if (tile != null) {
            hits.add(checkHitTopOrSideTile(tile));
            tile.hit();
            player.addPoints(10);
        }

        if (position.getDiscreteX() == dimensions.getDiscreteX()/2. - 1 ||
            position.getDiscreteX() == getWidth() - dimensions.getDiscreteX()/2. + 1) hits.add(BallModel.HIT.SIDE);

        if (hits.size() == 0) hits.add(BallModel.HIT.NOTHING);
        return hits;
    }

    protected BallModel.HIT checkHitTopOrSideTile(TileModel tile) {
        Position prevPos = ball.getPosition();
        Position tilePos = tile.getPosition();
        int ballHWidth = ball.getDimensions().getDiscreteX()/2;
        int tileHWidth = tile.getDimensions().getDiscreteX()/2;

        if (prevPos.getDiscreteX() + ballHWidth == tilePos.getDiscreteX() - tileHWidth ||
            prevPos.getDiscreteX() - ballHWidth == tilePos.getDiscreteX() + tileHWidth) return BallModel.HIT.SIDE;
        return BallModel.HIT.TOP;
    }

    protected TileModel checkHitTile(Position position) {
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

    protected boolean checkHitPlayer(Position position) {
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