package com.g19.breakout.controller.commands.ballhit;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;

public class BallHitBottom extends BallHit {
    public BallHitBottom(BallModel ball) {
        super(ball);
    }

    public boolean execute() {
        ball.setDirection(new Direction(0, 0));
        return true;
    }
}
