package com.g19.breakout.controller.commands.ballhit;

import com.g19.breakout.model.BallModel;

public class BallHitVertical extends BallHit {
    public BallHitVertical(BallModel ball) {
        super(ball);
    }

    public boolean execute() {
        ball.setDirection(ball.getDirection().hitVertical());
        return true;
    }
}
