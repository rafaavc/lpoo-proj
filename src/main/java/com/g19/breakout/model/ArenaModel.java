package com.g19.breakout.model;

import com.g19.breakout.elements.*;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel {
    private int height, width;

    private final PlayerBarModel playerBar;
    private final BallModel ball;
    private List<TileModel> tiles;


    public ArenaModel(int width, int height) {
        this.height = height;
        this.width = width;

        playerBar = new PlayerBarModel(new Position(width/2., height-8));
        ball = new BallModel(new Position(width/2., height-9), 20);
        tilesInit(5, 4);
    }

    private void tilesInit(int nHorizontal, int nVertical) {
        int horizontalFreeSpace, horizontalFreeSpaceEach, verticalFreeSpaceEach, tileWidth, marginBetweenTiles, margin, tileHeight;

        horizontalFreeSpace = width-3;
        horizontalFreeSpaceEach = horizontalFreeSpace/nHorizontal;
        verticalFreeSpaceEach = 5;
        marginBetweenTiles = 4;
        tileWidth = horizontalFreeSpaceEach-marginBetweenTiles;
        tileHeight = verticalFreeSpaceEach-(marginBetweenTiles/2);

        margin = (width - horizontalFreeSpaceEach*nHorizontal + marginBetweenTiles)/2;

        tiles = new ArrayList<>();
        for (int i = 0; i < nHorizontal; i++) {
            for (int j = 0; j < nVertical; j++) {
                Position pos = new Position(margin + tileWidth/2 + i*horizontalFreeSpaceEach, margin/2 + j*verticalFreeSpaceEach);
                Dimensions dim = new Dimensions(tileWidth, tileHeight);
                tiles.add(new TileModel(pos, dim, 2 + nVertical - j));
            }
        }
    }


    public List<BallModel.HIT> checkCollisions(Position position, Dimensions dimensions) {
        List<BallModel.HIT> hits = new ArrayList<>();

        if (position.getDiscreteY() == -1) hits.add(BallModel.HIT.TOP);
        if (position.getDiscreteY() == height - dimensions.getDiscreteY() + 1) hits.add(BallModel.HIT.BOTTOM);
        if (checkHitPlayerBar(position)) {
            if (checkHitPlayerBarMiddle(position)) hits.add(BallModel.HIT.PLAYERBARMIDDLE);
            if (checkHitPlayerBarRight(position)) hits.add(BallModel.HIT.PLAYERBARRIGHT);
            if (checkHitPlayerBarLeft(position)) hits.add(BallModel.HIT.PLAYERBARLEFT);
        }

        TileModel tile = checkHitTile(position);
        if (tile != null) {
            hits.add(checkTopOrSide(position, tile));
        }

        if (position.getDiscreteX() == dimensions.getDiscreteX()/2. - 1 || position.getDiscreteX() == width - dimensions.getDiscreteX()/2. + 1) hits.add(BallModel.HIT.SIDE);
        if (hits.size() == 0) hits.add(BallModel.HIT.NOTHING);
        return hits;
    }

    private BallModel.HIT checkTopOrSide(Position pos, TileModel tile) {
        List<BallModel.HIT> res = new ArrayList<>();
        Position prevPos = ball.getPosition();
        Position tilePos = tile.getPosition();
        int ballHWidth = ball.getDimensions().getDiscreteX()/2;
        int tileHWidth = tile.getDimensions().getDiscreteX()/2;

        if (prevPos.getDiscreteX() + ballHWidth == tilePos.getDiscreteX() - tileHWidth || prevPos.getDiscreteX() - ballHWidth == tilePos.getDiscreteX() + tileHWidth) return BallModel.HIT.SIDE;
        return BallModel.HIT.TOP;
    }

    private TileModel checkHitTile(Position position) {
        for (TileModel tile : tiles) {
            Position tilePos = tile.getPosition();
            int tileHeight = tile.getDimensions().getDiscreteY();
            int ballHeight = ball.getDimensions().getDiscreteY();

            boolean isInsideY = position.getY() + ballHeight > tilePos.getY() && position.getY() < tilePos.getY() + tileHeight;

            if (isInsideY) {
                int ballHWidth = ball.getDimensions().getDiscreteX()/2;
                int tileHWidth = tile.getDimensions().getDiscreteX()/2;
                if (position.getDiscreteX() + ballHWidth > tilePos.getDiscreteX() - tileHWidth && position.getDiscreteX() - ballHWidth < tilePos.getDiscreteX() + tileHWidth) {
                    return tile;
                }
            }
        }
        return null;
    }

    private boolean checkHitPlayerBar(Position position) {
        return position.getDiscreteY() == playerBar.getPosition().getDiscreteY() &&
                position.getDiscreteX() >= playerBar.getPosition().getDiscreteX() - 3 &&
                position.getDiscreteX() <= playerBar.getPosition().getDiscreteX() + 3;
    }

    private boolean checkHitPlayerBarMiddle(Position position){
        return position.getDiscreteX() >= playerBar.getPosition().getDiscreteX() - 1 &&
                position.getDiscreteX() <= playerBar.getPosition().getDiscreteX() + 1;
    }

    private boolean checkHitPlayerBarRight(Position position){
        return position.getDiscreteX() >= playerBar.getPosition().getDiscreteX() + 2 &&
                position.getDiscreteX() <= playerBar.getPosition().getDiscreteX() + 3;
    }

    private boolean checkHitPlayerBarLeft(Position position){
        return position.getDiscreteX() >= playerBar.getPosition().getDiscreteX() - 3 &&
                position.getDiscreteX() <= playerBar.getPosition().getDiscreteX() - 2;
    }

    public boolean canMoveElement(Position position, Dimensions dimension) {
        return position.getDiscreteX() >= dimension.getDiscreteX()/2 && position.getDiscreteX() <= width - dimension.getDiscreteX()/2
                && position.getDiscreteY() >= 0 && position.getDiscreteY() <= height - dimension.getDiscreteY()/2;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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