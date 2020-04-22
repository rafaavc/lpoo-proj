package com.g19.breakout;

import com.g19.breakout.elements.Chronometer;
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
            view.draw(arena);
            update();
        }
        while ( this.getNextCommand(view) );
    }

    private void update() {
        int elapsedTime = (int) chrono.getElapsedTime();
        Position nextBallPosition = arena.getBall().getDirection()
            .getNextPosition(arena.getBall().getPosition(), arena.getBall().getVelocity()*elapsedTime/1000);
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
