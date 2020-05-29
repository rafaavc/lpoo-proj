package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.ball.BallHit;
import com.g19.breakout.controller.CollisionChecker;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.ArenaView;
import com.g19.breakout.view.View;

import java.util.List;

public class PlayingGameState extends GameState {
    private final ArenaModel arena;
    private final ArenaView view;
    private final StateFactory stateFactory;
    private final CollisionChecker collisionChecker;

    public PlayingGameState(ArenaModel arena, ArenaView view, GameController controller, CollisionChecker collisionChecker, StateFactory stateFactory) {
        super(controller);
        this.arena = arena;
        this.view = view;
        this.stateFactory = stateFactory;
        this.collisionChecker = collisionChecker;
    }

    @Override
    public void update(int elapsedTime) {
        updateBall(elapsedTime);
        updateTiles();
        if (arena.getBall().getDirection().equals(new Direction(0, 0))) gameOver();
    }

    protected void updateTiles() {
        arena.getTiles().removeIf(t -> t.getLife() == 0);
    }

    protected void updateBall(int elapsedTime /*milliseconds*/) {
        BallModel ball = arena.getBall();

        double velocity = ball.getVelocity()*elapsedTime/1000;
        Position nextBallPosition = updateBallPosition(velocity);

        moveElement(nextBallPosition, this.arena.getBall());
    }

    protected Position updateBallPosition(double velocity) {
        BallModel ball = arena.getBall();

        Position nextBallPosition = ball.getDirection().getNextPosition(
                ball.getPosition(),
                velocity);

        if (updateBallDirection(ball, nextBallPosition))
            nextBallPosition = ball.getDirection().getNextPosition(
                    ball.getPosition(),
                    velocity);

        return nextBallPosition;
    }

    public boolean updateBallDirection(BallModel ball, Position nextBallPosition){
        List<BallHit> ballHits = collisionChecker.checkBallCollisions(nextBallPosition, ball.getDimensions());

        Direction ballDirection = ball.getDirection();

        for (BallHit ballHit: ballHits)
            ballHit.updateDirection();

        Direction newBallDirection = ball.getDirection();

        return !ballDirection.equals(newBallDirection);
    }

    public void moveElement(Position position, ElementModel element) {
        if (arena.isInsideArena(position, element.getDimensions())) {
            element.setPosition(position);
        }
    }

    public void gameOver() {
        controller.setState(stateFactory.createGameOverGameState(controller));
    }

    @Override
    public boolean commandLeft() {
        // maybe change to where the playerbar is moved based on velocity, the longer the key is pressed the faster it moves
        PlayerModel playerBar = arena.getPlayer();
        moveElement(playerBar.getPosition().left(), playerBar);
        return true;
    }

    @Override
    public boolean commandRight() {
        PlayerModel playerBar = arena.getPlayer();
        moveElement(playerBar.getPosition().right(), playerBar);
        return true;
    }

    @Override
    public boolean commandP() {
        controller.setState(this.stateFactory.createPauseGameState(controller));
        return true;
    }

    public View getView() {
        return view;
    }

    public ArenaModel getArena() {
        return arena;
    }
}
