package com.g19.breakout.controller;

import com.g19.breakout.controller.ball.*;
import com.g19.breakout.controller.commands.*;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.ArenaView;

import java.util.List;

public class Transformer {

    public BallHit toBallHit(List<BallModel.HIT> ballModelHits, BallModel ball, PlayerModel playerBar){
        BallHit previousBallHit = null;
        BallHit ballHit = null;

        for (BallModel.HIT ballModelHit: ballModelHits) {
            switch (ballModelHit) {
                case TOP:
                    ballHit = new BallHitHorizontal(ball ,previousBallHit);
                    previousBallHit = ballHit;
                    break;
                case BOTTOM:
                    ballHit = new BallHitBottom(ball ,previousBallHit);
                    previousBallHit = ballHit;
                    break;
                case PLAYERBAR:
                    ballHit = new BallHitPlayerBar(ball ,previousBallHit, playerBar);
                    previousBallHit = ballHit;
                    break;
                case SIDE:
                    ballHit = new BallHitVertical(ball ,previousBallHit);
                    previousBallHit = ballHit;
                    break;
                case NOTHING:
                default:
                    ballHit = new BallHitNothing(ball ,previousBallHit);
                    previousBallHit = ballHit;
                    break;
            }
        }

        return ballHit;
    }

    public Command toCommand(ArenaView.Keys key){
        switch (key){
            case ARROWLEFT:
                return new CommandLeft();
            case ARROWRIGHT:
                return new CommandRight();
            case EOF:
                return new CommandEXIT();
            case NONE:
            default:
                return new CommandNone();
        }
    }
}
