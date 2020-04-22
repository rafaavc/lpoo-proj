package com.g19.breakout.controller;

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

        BallModel.HIT hit = arena.checkCollisions(nextBallPosition);

        switch(hit){
            case TOP:
                ball.setDirection(ball.getDirection().hitTopOrBottom());
                break;
            case PLAYERBARMIDDLE:
                ball.setDirection(new Direction(0, -1));
                break;
            case BOTTOM:
                ball.setDirection(new Direction(0, 0));
                break;
            case PLAYERBARLEFT:
                ball.setDirection(new Direction(-1, -1));
                break;
            case PLAYERBARRIGHT:
                ball.setDirection(new Direction(1, -1));
                break;
            case RIGHT:
            case LEFT:
                ball.setDirection(ball.getDirection().hitLeftOrRight());
                break;
            default:
                break;
        }

        nextBallPosition = ball.getDirection().getNextPosition(ball.getPosition(), velocity);

        moveBall(nextBallPosition);
    }

    public boolean getNextCommand(ArenaView view) throws IOException {
        COMMAND cmd = view.readInput();
        if (cmd == COMMAND.EOF) return false;

        Position playerBarPosition = arena.getPlayerBar().getPosition();

        if (cmd == COMMAND.RIGHT) movePlayerBar(playerBarPosition.right());
        else if (cmd == COMMAND.LEFT) movePlayerBar(playerBarPosition.left());

        return true;
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
