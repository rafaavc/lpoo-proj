package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public abstract class BallHit {
    protected final BallModel ball;
    protected final BallHit ballHit;

    public BallHit(BallModel ball, BallHit ballHit) {
        this.ball = ball;
        this.ballHit = ballHit;
    }

    public abstract void updateDirection();

    public BallHit getBallHit() {
        return ballHit;
    }
}
