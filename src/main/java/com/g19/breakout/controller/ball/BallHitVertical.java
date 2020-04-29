package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitVertical implements BallHit {
    private BallModel ball;
    private BallHit ballHit = null;


    public BallHitVertical(BallModel ball) {
        this.ball = ball;
    }

    public BallHitVertical(BallModel ball, BallHit ballHit) {
        this.ball = ball;
        this.ballHit = ballHit;
    }

    @Override
    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitLeftOrRight());
        if (ballHit != null) ballHit.updateDirection();
    }
}
