package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;

public class BallHitPlayerBarLeft implements BallHit{
    BallModel ball;

    public BallHitPlayerBarLeft(BallModel ball) {
        this.ball = ball;
    }

    @Override
    public void updateDirection() {
        ball.setDirection(new Direction(-1, -1));
    }
}
