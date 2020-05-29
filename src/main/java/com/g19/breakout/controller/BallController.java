package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.ballhit.BallHit;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.utilities.Position;

import java.util.List;

public class BallController {
    private final CollisionChecker collisionChecker;
    private final BallModel ball;

    public BallController(CollisionChecker collisionChecker) {
        this.ball = collisionChecker.getArena().getBall();
        this.collisionChecker = collisionChecker;
    }

    public Position update(int elapsedTime /*milliseconds*/) {
        double velocity = ball.getVelocity()*elapsedTime/1000;

        Position nextBallPosition = ball.getDirection().getNextPosition(
                ball.getPosition(),
                velocity);

        if (updateBallDirection(nextBallPosition))
            nextBallPosition = ball.getDirection().getNextPosition(
                    ball.getPosition(),
                    velocity);

        return nextBallPosition;
    }

    public boolean updateBallDirection(Position nextBallPosition){
        List<BallHit> ballHits = collisionChecker.checkBallCollisions(nextBallPosition, ball.getDimensions());

        ballHits.forEach(BallHit::execute);

        return ballHits.size() > 0;
    }
}
