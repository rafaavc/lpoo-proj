package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitTop implements BallHit {
    private BallModel ball;

    public BallHitTop(BallModel ball){
        this.ball = ball;
    }

    @Override
    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitTopOrBottom());
    }
}
