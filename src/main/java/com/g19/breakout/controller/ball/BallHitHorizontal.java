package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitHorizontal extends BallHit {

    public BallHitHorizontal(BallModel ball) {
        super(ball);
    }

    @Override
    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitHorizontal());
        super.updateDirection();
    }
}
