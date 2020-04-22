package com.g19.breakout;

import com.g19.breakout.elements.Ball;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Position;

import java.io.IOException;

public class ArenaController {
    private final ArenaModel arena;
    private final ArenaView view;

    public enum COMMAND {NONE, EOF, RIGHT, LEFT}

    public ArenaController(ArenaModel arena, ArenaView view) {
        this.arena = arena;
        this.view = view;
    }

    public void start(ArenaController controller) throws IOException {
        Chronometer chrono = new Chronometer();
        do {
            view.draw(view, arena);
            controller.update(chrono);
        }
        while ( controller.getNextCommand(view) );
    }

    void update(Chronometer chrono) {
        int elapsedTime = (int) chrono.getElapsedTime();

        Ball ball = arena.getBall();
        double velocity = ball.getVelocity()*elapsedTime/1000;

        Position nextBallPosition = ball.getDirection().getNextPosition(
                ball.getPosition(),
                velocity);

        moveBall(nextBallPosition);
    }

    boolean getNextCommand(ArenaView view) throws IOException {
        COMMAND cmd = view.readInput();
        if (cmd == COMMAND.EOF) return false;

        Position playerBarPosition = arena.getPlayerBar().getPosition();

        if (cmd == COMMAND.RIGHT) movePlayerBar(playerBarPosition.right());
        else if (cmd == COMMAND.LEFT) movePlayerBar(playerBarPosition.left());

        return true;
    }

    public void moveBall(Position position) {
        if (arena.canMoveBall(position)) {
            arena.getBall().setPosition(position);
        }
    }

    public void movePlayerBar(Position position){
        if (arena.canMovePlayerBar(position)){
            arena.getPlayerBar().setPosition(position);
        }
    }
}
