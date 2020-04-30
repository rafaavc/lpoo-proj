package com.g19.breakout.controller;

import com.g19.breakout.controller.ball.*;
import com.g19.breakout.controller.commands.*;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.TileModel;
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

        moveBall(nextBallPosition);
    }

    protected Position updateBallPosition(double velocity) {
        BallModel ball = arena.getBall();
        Direction ballDirection = ball.getDirection();

        Position nextBallPosition = ballDirection.getNextPosition(
                ball.getPosition(),
                velocity);

        updateBallDirection(new Transformer(), ball, nextBallPosition);
        Direction newBallDirection = ball.getDirection();

        if (!ballDirection.equals(newBallDirection))
            nextBallPosition = ball.getDirection().getNextPosition(
                    ball.getPosition(),
                    velocity);

        return nextBallPosition;
    }

    private void updateBallDirection(Transformer transformer, BallModel ball, Position nextBallPosition){
        List<BallModel.HIT> ballModelHits = arena.checkCollisions(nextBallPosition, ball.getDimensions());

        BallHit ballHit = transformer.toBallHit(ballModelHits, ball, arena.getPlayerBar());

        ballHit.updateDirection();
    }

    public boolean getNextCommand(Transformer transformer, ArenaView view) throws IOException {
        ArenaView.Keys key = view.readInput();
        Command cmd = transformer.toCommand(key);
        return cmd.execute(this);
    }

    public void moveBall(Position position) {
        if (arena.isInsideArena(position, arena.getBall().getDimensions())) {
            arena.getBall().setPosition(position);
        }
    }

    public void movePlayerBar(Position position){
        if (arena.isInsideArena(position, arena.getPlayerBar().getDimensions())){
            arena.getPlayerBar().setPosition(position);
        }
    }

    public ArenaModel getArena() {
        return arena;
    }
}
