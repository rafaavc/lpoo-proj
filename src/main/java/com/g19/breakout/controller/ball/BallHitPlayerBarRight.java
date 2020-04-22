package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;

public class BallHitPlayerBarRight implements BallHit{
    private BallModel ball;

    public BallHitPlayerBarRight(BallModel ball) {
        this.ball = ball;
    }

    @Override
    public void updateDirection() {
        ball.setDirection(new Direction(1, -1));
    }
}
