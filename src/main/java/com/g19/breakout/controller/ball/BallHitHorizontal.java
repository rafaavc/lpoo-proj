package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitHorizontal extends BallHit {

    public BallHitHorizontal(BallModel ball) {
        super(ball);
    }

    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitHorizontal());
        if (ballHit != null) ballHit.updateDirection();
    }
}
