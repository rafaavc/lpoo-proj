package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitTop implements BallHit {
    private BallModel ball;
    private BallHit ballHit;

    public BallHitTop(BallModel ball){
        this.ball = ball;
    }

    public BallHitTop(BallModel ball, BallHit ballHit) {
        this.ball = ball;
        this.ballHit = ballHit;
    }

    @Override
    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitTopOrBottom());
        if (ballHit != null) ballHit.updateDirection();
    }
}
