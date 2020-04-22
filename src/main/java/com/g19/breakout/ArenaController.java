package com.g19.breakout;

import com.g19.breakout.elements.Ball;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.elements.Position;

import java.io.IOException;

public class ArenaController {
    private final ArenaModel arena;
    private final ArenaView view;
    private Chronometer chrono;

    public enum COMMAND {NONE, EOF, RIGHT, LEFT}

    public ArenaController(ArenaModel arena, ArenaView view) {
        this.arena = arena;
        this.view = view;
    }

    public void start() throws IOException {
        chrono = new Chronometer();
        do {
            view.draw(view, arena);
            update();
        }
        while ( this.getNextCommand(view) );
    }

    private void update() {
        int elapsedTime = (int) chrono.getElapsedTime();
        Ball ball = arena.getBall();
        double velocity = ball.getVelocity()*elapsedTime/1000;

        Position nextBallPosition = ball.getDirection().getNextPosition(
                ball.getPosition(),
                velocity);

        Ball.HIT hit = arena.checkCollisions(nextBallPosition);

        switch(hit){
            case TOP:
            case PLAYERBARMIDDLE:
                ball.setDirection(ball.getDirection().hitTopOrBottom());
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

        arena.moveBall(nextBallPosition);
    }

    private boolean getNextCommand(ArenaView view) throws IOException {
        COMMAND cmd = view.readInput();
        if (cmd == COMMAND.EOF) return false;

        Position playerBarPosition = arena.getPlayerBar().getPosition();

        if (cmd == COMMAND.RIGHT) arena.movePlayerBar(playerBarPosition.right());
        else if (cmd == COMMAND.LEFT) arena.movePlayerBar(playerBarPosition.left());

        return true;
    }
}
