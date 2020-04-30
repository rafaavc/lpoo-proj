package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitVertical extends BallHit {

    public BallHitVertical(BallModel ball, BallHit ballHit) {
        super(ball, ballHit);
    }

    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitLeftOrRight());
        if (ballHit != null) ballHit.updateDirection();
    }
}
