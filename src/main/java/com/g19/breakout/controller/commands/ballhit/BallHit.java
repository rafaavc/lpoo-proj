package com.g19.breakout.controller.commands.ballhit;

import com.g19.breakout.controller.commands.Command;
import com.g19.breakout.model.BallModel;

public abstract class BallHit implements Command {
    protected final BallModel ball;

    public BallHit(BallModel ball) {
        this.ball = ball;
    }
}
