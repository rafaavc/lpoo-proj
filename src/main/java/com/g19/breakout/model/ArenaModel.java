package com.g19.breakout.model;

import com.g19.breakout.controller.ball.*;
import com.g19.breakout.elements.*;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel {
    private int height, width;

    private PlayerBarModel playerBar;
    private BallModel ball;
    private List<TileModel> tiles;


    public ArenaModel(int width, int height) {
        this.height = height;
        this.width = width;

        playerBar = new PlayerBarModel(new Position(width/2., height-8), "#ffffff");
        ball = new BallModel(new Position(width/2., height-9), "#0000ff");
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
        char c = '█';

        StringBuffer stringRep = new StringBuffer();
        for (int i = 0; i < tileWidth; i++) {
            stringRep.append(c);
        }
        tiles = new ArrayList<>();
        for (int i = 0; i < nHorizontal; i++) {
            for (int j = 0; j < nVertical; j++) {
                Position pos = new Position(margin + tileWidth/2 + i*horizontalFreeSpaceEach, margin/2 + j*verticalFreeSpaceEach);
                tiles.add(new TileModel(pos, stringRep.toString(), "#00ff00", tileHeight, 4));
            }
        }
    }


    public BallHit checkCollisions(Position position, Dimensions dimensions) {
        if (position.getDiscreteY() == -1) return new BallHitTop(ball);
        if (position.getDiscreteY() == height - dimensions.getDiscreteY() + 1) return new BallHitBottom(ball);
        if (checkHitPlayerBar(position)) {
            if (checkHitPlayerBarMiddle(position)) return new BallHitPlayerBarMiddle(ball);
            if (checkHitPlayerBarRight(position)) return new BallHitPlayerBarRight(ball);
            if (checkHitPlayerBarLeft(position)) return new BallHitPlayerBarLeft(ball);
        }

        if (position.getDiscreteX() == dimensions.getDiscreteX()/2. - 1 || position.getDiscreteX() == width - dimensions.getDiscreteX()/2. + 1) return new BallHitSide(ball);
        return new BallHitNothing(ball);
    }

    private boolean checkHitPlayerBar(Position position) {
        return position.getDiscreteY() == playerBar.getPosition().getDiscreteY();
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