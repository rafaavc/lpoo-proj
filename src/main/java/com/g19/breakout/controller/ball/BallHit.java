package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public abstract class BallHit {
    protected final BallModel ball;

    public BallHit(BallModel ball) {
        this.ball = ball;
    }

    public abstract void updateDirection();
}
