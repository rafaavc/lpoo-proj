package com.g19.breakout.model;

import com.g19.breakout.elements.*;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel {
    private Dimensions dimensions;

    private final PlayerBarModel playerBar;
    private final BallModel ball;
    private List<TileModel> tiles;


    public ArenaModel(Dimensions dimensions) {
        this.dimensions = dimensions;

        playerBar = new PlayerBarModel(new Position(getWidth()/2., getHeight()-4));
        ball = new BallModel(new Position(getWidth()/2., getHeight()-5), 18);
        tilesInit(5, 4);
    }

    private void tilesInit(int nHorizontal, int nVertical) {
        int horizontalFreeSpace, horizontalFreeSpaceEach, verticalFreeSpaceEach, tileWidth, marginBetweenTiles, margin, tileHeight;

        horizontalFreeSpace = getWidth();
        horizontalFreeSpaceEach = horizontalFreeSpace/nHorizontal;
        verticalFreeSpaceEach = 5;
        marginBetweenTiles = 4;
        tileWidth = horizontalFreeSpaceEach-marginBetweenTiles;
        tileHeight = verticalFreeSpaceEach-(marginBetweenTiles/2);

        margin = (getWidth() - horizontalFreeSpaceEach*nHorizontal + marginBetweenTiles)/2;

        if (tileWidth%2 != 0) {
            tileWidth--;
            margin++;
        }

        tiles = new ArrayList<>();
        for (int i = 0; i < nHorizontal; i++) {
            for (int j = 0; j < nVertical; j++) {
                Position pos = new Position(margin + tileWidth/2. + i*horizontalFreeSpaceEach, margin/2. + j*verticalFreeSpaceEach);
                Dimensions dim = new Dimensions(tileWidth, tileHeight);
                tiles.add(new TileModel(pos, dim, 2 + nVertical - j));
            }
        }
    }


    public List<BallModel.HIT> checkCollisions(Position position, Dimensions dimensions) {
        List<BallModel.HIT> hits = new ArrayList<>();

        if (position.getDiscreteY() == -1) hits.add(BallModel.HIT.TOP);
        if (position.getDiscreteY() == getHeight() - dimensions.getDiscreteY() + 1) hits.add(BallModel.HIT.BOTTOM);
        if (checkHitPlayerBar(position)) hits.add(BallModel.HIT.PLAYERBAR);

        TileModel tile = checkHitTile(position);
        if (tile != null) {
            hits.add(checkHitTopOrSideTile(tile));
            tile.hit();
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

    protected boolean checkHitPlayerBar(Position position) {
        return position.getDiscreteY() == playerBar.getPosition().getDiscreteY() &&
                position.getDiscreteX() >= playerBar.getPosition().getDiscreteX() - 3 &&
                position.getDiscreteX() <= playerBar.getPosition().getDiscreteX() + 3;
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

    public PlayerBarModel getPlayerBar() {
        return playerBar;
    }

    public BallModel getBall() {
        return ball;
    }

    public List<TileModel> getTiles() {
        return tiles;
    }
}