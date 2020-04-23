package com.g19.breakout.controller;

import com.g19.breakout.controller.ball.*;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.ArenaView;

import java.io.IOException;

public class ArenaController {
    private final ArenaModel arena;
    private final ArenaView view;

    public enum COMMAND {NONE, EOF, RIGHT, LEFT}

    public ArenaController(ArenaModel arena, ArenaView view) {
        this.arena = arena;
        this.view = view;
    }

    public void start() throws IOException {
        Chronometer chrono = new Chronometer();
        do {
            view.draw(arena);
            update(chrono);
        }
        while ( getNextCommand(view) );
    }

    public void update(Chronometer chrono) {
        int elapsedTime = (int) chrono.getElapsedTime();

        BallModel ball = arena.getBall();
        double velocity = ball.getVelocity()*elapsedTime/1000;

        Position nextBallPosition = ball.getDirection().getNextPosition(
                ball.getPosition(),
                velocity);

        updateBallDirection(ball, nextBallPosition);

        nextBallPosition = ball.getDirection().getNextPosition(ball.getPosition(), velocity);

        moveBall(nextBallPosition);
    }

    private void updateBallDirection(BallModel ball, Position nextBallPosition){

        BallHit ballHit = arena.checkCollisions(nextBallPosition, ball.getDimensions());

        ballHit.updateDirection();
    }

    public boolean getNextCommand(ArenaView view) throws IOException {
        Command cmd = view.readInput();
        Position playerBarPosition = arena.getPlayerBar().getPosition();

        return cmd.execute(this, playerBarPosition);
    }

    public void moveBall(Position position) {
        if (arena.canMoveElement(position, arena.getBall().getDimensions())) {
            arena.getBall().setPosition(position);
        }
    }

    public void movePlayerBar(Position position){
        if (arena.canMoveElement(position, arena.getPlayerBar().getDimensions())){
            arena.getPlayerBar().setPosition(position);
        }
    }
}