package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.sun.tools.javac.util.Pair;

import java.util.PriorityQueue;

public class GameModel {
    private final Dimensions dimensions;
    private final BackgroundModel backgroundModel;
    private PriorityQueue<Pair<String, Integer>> leaderboard;

    public GameModel(Dimensions dimensions, BackgroundModel backgroundModel) {
        this.dimensions = dimensions;
        this.backgroundModel = backgroundModel;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setLeaderboard(PriorityQueue<Pair<String, Integer>> lb) {
        leaderboard = lb;
    }

    public PriorityQueue<Pair<String, Integer>> getLeaderboard() {
        return leaderboard;
    }

    public void addScore(Pair<String, Integer> p) {
        leaderboard.add(p);
    }

    public boolean isInsideGame(Position position, Dimensions dimension) {
        return position.getDiscreteX() >= dimension.getDiscreteX()/2 && position.getDiscreteX() <= dimensions.getDiscreteX() - dimension.getDiscreteX()/2
                && position.getDiscreteY() >= 0 && position.getDiscreteY() <= dimensions.getDiscreteY() - dimension.getDiscreteY()/2;
    }

    public BackgroundModel getBackgroundModel() {
        return backgroundModel;
    }
}
