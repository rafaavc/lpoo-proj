package com.g19.breakout.controller;

import com.g19.breakout.controller.ball.*;
import com.g19.breakout.controller.commands.*;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.view.ArenaView;

import java.io.IOException;
import java.util.List;

public class ArenaController {
    private final ArenaModel arena;
    private final ArenaView view;

    public ArenaController(ArenaModel arena, ArenaView view) {
        this.arena = arena;
        this.view = view;
    }

    public void start(Transformer transformer, Chronometer chrono) throws IOException {
        do {
            view.draw();
            update(chrono);
        }
        while ( getNextCommand(transformer, view) );
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

        BallHit ballHit = transformer.toBallHit(ballModelHits, ball, arena.getPlayerBar());

        Direction ballDirection = ball.getDirection();
        ballHit.updateDirection();
        Direction newBallDirection = ball.getDirection();

        return !ballDirection.equals(newBallDirection);
    }

    public boolean getNextCommand(Transformer transformer, ArenaView view) throws IOException {
        ArenaView.Keys key = view.readInput();
        Command cmd = transformer.toCommand(key);
        return cmd.execute(this);
    }

    public void moveElement(Position position, ElementModel element) {
        if (arena.isInsideArena(position, element.getDimensions())) {
            element.setPosition(position);
        }
    }

    public ArenaModel getArena() {
        return arena;
    }
}
