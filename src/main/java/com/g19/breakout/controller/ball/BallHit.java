package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHit {
    protected final BallModel ball;
    protected BallHit ballHit;

    public BallHit(BallModel ball) {
        this.ball = ball;
    }

    public void updateDirection() {
        if (ballHit != null) ballHit.updateDirection();
    }

    public BallHit getBallHit() {
        return ballHit;
    }

    public void setBallHit(BallHit ballHit){
        if (this.ballHit == null) this.ballHit = ballHit;
        else this.ballHit.setBallHit(ballHit);
    }
}
