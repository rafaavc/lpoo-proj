package com.g19.breakout.model;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class BackgroundModel {
    private final List<Position> particles;
    private final Dimensions gameDimensions;

    public BackgroundModel(Dimensions gameDimensions) {
        particles = new ArrayList<>();
        this.gameDimensions = gameDimensions;
    }

    public void generateParticles() {
        particles.clear();
        for (int i = 0; i < 100; i++) {
            particles.add(new Position(Math.random()*gameDimensions.getDiscreteX(), Math.random()*gameDimensions.getDiscreteY()));
        }
    }

    public List<Position> getParticles() {
        return particles;
    }
}
