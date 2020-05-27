package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;

public class PlayerModel extends ElementModel {
    private int points;
    private String name;
    private boolean nameInputFinished;

    public PlayerModel(Position position) {
        super(position, new Dimensions(10, 1));
        points = 0;
        name = "";
        nameInputFinished = false;
    }

    public void setNameInputFinished(boolean nif) {
        nameInputFinished = nif;
    }

    public boolean getNameInputFinished() {
        return nameInputFinished;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPoints(int p) {
        points += p;
    }

    public int getPoints() {
        return points;
    }
}
