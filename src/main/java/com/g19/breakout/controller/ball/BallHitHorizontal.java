package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitHorizontal implements BallHit {
    private BallModel ball;
    private BallHit ballHit;

    public BallHitHorizontal(BallModel ball){
        this.ball = ball;
    }

    public BallHitHorizontal(BallModel ball, BallHit ballHit) {
        this.ball = ball;
        this.ballHit = ballHit;
    }

    @Override
    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitTopOrBottom());
        if (ballHit != null) ballHit.updateDirection();
    }
}
