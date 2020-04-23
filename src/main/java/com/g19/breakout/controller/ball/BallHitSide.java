package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitSide implements BallHit {
    BallModel ball;

    public BallHitSide(BallModel ball) {
        this.ball = ball;
    }

    @Override
    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitLeftOrRight());
    }
}
