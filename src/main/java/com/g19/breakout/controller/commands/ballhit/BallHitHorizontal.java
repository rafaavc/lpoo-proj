package com.g19.breakout.controller.commands.ballhit;

import com.g19.breakout.model.BallModel;

public class BallHitHorizontal extends BallHit {
    public BallHitHorizontal(BallModel ball) {
        super(ball);
    }

    public void execute() {
        ball.setDirection(ball.getDirection().hitHorizontal());
    }
}
