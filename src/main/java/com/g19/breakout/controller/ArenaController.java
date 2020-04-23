package com.g19.breakout.controller;

import com.g19.breakout.controller.ball.*;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.ArenaView;
import com.g19.breakout.view.ArenaView.COMMAND;

import java.io.IOException;
import java.util.List;

public class ArenaController {
    private final ArenaModel arena;
    private final ArenaView view;

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
        Direction ballDirection = ball.getDirection();

        double velocity = ball.getVelocity()*elapsedTime/1000;

        Position nextBallPosition = ballDirection.getNextPosition(
                ball.getPosition(),
                velocity);

        updateBallDirection(ball, nextBallPosition);
        Direction newBallDirection = ball.getDirection();

        if (!ballDirection.equals(newBallDirection)) {
            nextBallPosition = ball.getDirection().getNextPosition(ball.getPosition(), velocity);
        }

        moveBall(nextBallPosition);
    }

    private void updateBallDirection(BallModel ball, Position nextBallPosition){

        List<BallModel.HIT> ballModelHits = arena.checkCollisions(nextBallPosition, ball.getDimensions());

        BallHit ballHit = new Transformer().toBallHit(ballModelHits, ball);

        ballHit.updateDirection();
    }



    public boolean getNextCommand(ArenaView view) throws IOException {
        ArenaView.Keys key = view.readInput();
        Command cmd = new Transformer().toCommand(key);

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
