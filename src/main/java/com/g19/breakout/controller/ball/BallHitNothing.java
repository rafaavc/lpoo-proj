package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitNothing implements BallHit {
    BallModel ball;

    public BallHitNothing(BallModel ball) {
        this.ball = ball;
    }

    @Override
    public void updateDirection() {

    }
}
