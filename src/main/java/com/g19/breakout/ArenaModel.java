package com.g19.breakout;

import com.g19.breakout.elements.*;

import java.util.List;

public class ArenaModel {
    private int height;
    private int width;

    private PlayerBar playerBar;
    private Ball ball;
    private List<Tile> tiles;


    public ArenaModel(int width, int height) {
        this.height = height;
        this.width = width;

        playerBar = new PlayerBar(new Position(width/2., height-8));
        ball = new Ball(new Position(width/2., height-9));

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public PlayerBar getPlayerBar() {
        return playerBar;
    }

    public Ball getBall() {
        return ball;
    }

    public void moveBall(Position position) {
        ball.setPosition(position);
    }

    public Ball.HIT checkCollisions(Position position) {
        if (position.getDiscreteY() == -1) return Ball.HIT.TOP;
        if (position.getDiscreteY() == height) return Ball.HIT.BOTTOM;
        if (checkHitPlayerBarMiddle(position)) return Ball.HIT.PLAYERBARMIDDLE;
        if (checkHitPlayerBarRight(position)) return Ball.HIT.PLAYERBARRIGHT;
        if (checkHitPlayerBarLeft(position)) return Ball.HIT.PLAYERBARLEFT;
        if (position.getDiscreteX() == 1) return Ball.HIT.LEFT;
        if (position.getDiscreteX() == width - 1) return Ball.HIT.RIGHT;
        checkHitScreenBorder(position);
        return Ball.HIT.NOTHING;
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

    public void movePlayerBar(Position position){
        if (canMovePlayerBar(position)){
            playerBar.setPosition(position);
        }
    }

    private boolean canMovePlayerBar(Position position){
        return position.getDiscreteX() > 3 && position.getDiscreteX() < width - 3;
    }
}