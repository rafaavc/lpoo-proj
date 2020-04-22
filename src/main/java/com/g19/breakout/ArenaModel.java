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

    public boolean canMoveBall(Position position) {
        return position.getDiscreteX() > 0 && position.getDiscreteX() < width
                && position.getDiscreteY() >= 0 && position.getDiscreteY() <= height;
    }

    public boolean canMovePlayerBar(Position position){
        return position.getDiscreteX() > 3 && position.getDiscreteX() < width - 3;
    }
}