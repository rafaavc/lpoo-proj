package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.Transformer;
import com.g19.breakout.controller.ball.BallHit;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.ArenaView;
import com.g19.breakout.view.PauseView;

import java.util.List;

public class PlayingGameState implements GameState {
    ArenaModel arena;
    ArenaView view;
    GameController controller;
    StateFactory stateFactory;

    public PlayingGameState(ArenaModel arena, ArenaView view, GameController controller, StateFactory stateFactory) {
        this.arena = arena;
        this.view = view;
        this.controller = controller;
        this.stateFactory = stateFactory;
    }

    public void update(Chronometer chrono) {
        int elapsedTime = (int) chrono.getElapsedTime();

        updateBall(elapsedTime);
        updateTiles();
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

        if (updateBallDirection(new Transformer(), ball, nextBallPosition))
            nextBallPosition = ball.getDirection().getNextPosition(
                    ball.getPosition(),
                    velocity);

        return nextBallPosition;
    }

    public boolean updateBallDirection(Transformer transformer, BallModel ball, Position nextBallPosition){
        List<BallModel.HIT> ballModelHits = arena.checkBallCollisions(nextBallPosition, ball.getDimensions());

        BallHit ballHit = transformer.toBallHit(ballModelHits, ball, arena.getPlayer());

        Direction ballDirection = ball.getDirection();
        ballHit.updateDirection();
        Direction newBallDirection = ball.getDirection();

        return !ballDirection.equals(newBallDirection);
    }

    public void moveElement(Position position, ElementModel element) {
        if (arena.isInsideArena(position, element.getDimensions())) {
            element.setPosition(position);
        }
    }

    public void commandL() {
        // maybe change to where the playerbar is moved based on velocity, the longer the key is pressed the faster it moves
        PlayerModel playerBar = arena.getPlayer();
        moveElement(playerBar.getPosition().left(), playerBar);
    }

    public void commandR() {
        PlayerModel playerBar = arena.getPlayer();
        moveElement(playerBar.getPosition().right(), playerBar);
    }

    public void commandP() {
        controller.setState(this.stateFactory.createPauseGameState(this, controller), new Chronometer());
    }

    @Override
    public ArenaView getView() {
        return view;
    }
}
