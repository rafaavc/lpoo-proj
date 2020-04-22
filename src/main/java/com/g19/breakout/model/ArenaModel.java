package com.g19.breakout.model;

import com.g19.breakout.elements.*;

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

    public BallModel.HIT checkCollisions(Position position) {
        if (position.getDiscreteY() == -1) return BallModel.HIT.TOP;
        if (position.getDiscreteY() == height) return BallModel.HIT.BOTTOM;
        if (checkHitPlayerBarMiddle(position)) return BallModel.HIT.PLAYERBARMIDDLE;
        if (checkHitPlayerBarRight(position)) return BallModel.HIT.PLAYERBARRIGHT;
        if (checkHitPlayerBarLeft(position)) return BallModel.HIT.PLAYERBARLEFT;
        if (position.getDiscreteX() == 1) return BallModel.HIT.LEFT;
        if (position.getDiscreteX() == width - 1) return BallModel.HIT.RIGHT;
        checkHitScreenBorder(position);
        return BallModel.HIT.NOTHING;
    }

    private boolean checkHitPlayerBarMiddle(Position position){
        return position.getDiscreteY() == playerBar.getPosition().getDiscreteY() &&
                position.getDiscreteX() >= playerBar.getPosition().getDiscreteX() - 1 &&
                position.getDiscreteX() <= playerBar.getPosition().getDiscreteX() + 1;
    }

    private boolean checkHitPlayerBarRight(Position position){
        return position.getDiscreteY() == playerBar.getPosition().getDiscreteY() &&
                position.getDiscreteX() >= playerBar.getPosition().getDiscreteX() + 2 &&
                position.getDiscreteX() <= playerBar.getPosition().getDiscreteX() + 3;
    }

    private boolean checkHitPlayerBarLeft(Position position){
        return position.getDiscreteY() == playerBar.getPosition().getDiscreteY() &&
                position.getDiscreteX() >= playerBar.getPosition().getDiscreteX() - 3 &&
                position.getDiscreteX() <= playerBar.getPosition().getDiscreteX() - 2;
    }

    private boolean checkHitScreenBorder(Position position){
        return position.getDiscreteX() > 2 && position.getDiscreteX() < width - 2
                && position.getDiscreteY() >= 0 && position.getDiscreteY() <= height;
    }

    public boolean canMoveElement(Position position, Dimensions dimension) {
        return position.getDiscreteX() >= dimension.getDiscreteX()/2 && position.getDiscreteX() <= width - dimension.getDiscreteX()/2
                && position.getDiscreteY() >= 0 && position.getDiscreteY() <= height - dimension.getDiscreteY()/2;
    }
}