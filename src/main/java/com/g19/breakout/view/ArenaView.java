package com.g19.breakout.view;

import com.g19.breakout.controller.Command;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.elements.*;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerBarModel;

import java.io.IOException;


public class ArenaView {
    private final Graphics graphics;
    private final String backgroundColor = "#000000";

    public enum COMMAND {NONE, EXIT, RIGHT, LEFT}

    public ArenaView(ArenaModel arena, Graphics graphics) throws IOException {
        this.graphics = graphics;
        graphics.init(arena.getWidth(), arena.getHeight());
    }

    public void draw(ArenaModel arena) throws IOException {
        graphics.startDrawing();

        /* inject the class iteself into these method to test the following calls? */
        drawBackground(arena);
        drawPlayerBar(arena.getPlayerBar());
        drawBall(arena.getBall());

        graphics.stopDrawing();
    }


    public void drawBall(BallModel ball) {
        graphics.drawElement(ball);
    }

    public void drawPlayerBar(PlayerBarModel playerBar) {
        graphics.drawElement(playerBar);
    }

    public void drawBackground(ArenaModel arena) {
        graphics.drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', getBGColor());
    }

    public COMMAND readInput() throws IOException {
        return graphics.readInput();
    }

    public String getBGColor() {
        return backgroundColor;
    }
}
