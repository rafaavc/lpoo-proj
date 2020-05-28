package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitNothing extends BallHit {

    public BallHitNothing(BallModel ball) {
        super(ball);
    }

    @Override
    public void updateDirection() {
        super.updateDirection();
    }
}
