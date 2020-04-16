package com.g19.breakout;

import com.g19.breakout.elements.*;

import java.util.List;

public class Arena {
    private int height;
    private int width;

    private PlayerBar playerBar;
    private Ball ball;
    private List<Tile> tiles;


    public Arena(int width, int height) {
        this.height = height;
        this.width = width;

        playerBar = new PlayerBar(new Position(40, 40));

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
}
