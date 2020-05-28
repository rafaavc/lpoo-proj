package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitVertical extends BallHit {

    public BallHitVertical(BallModel ball) {
        super(ball);
    }

    @Override
    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitVertical());
        super.updateDirection();
    }
}
