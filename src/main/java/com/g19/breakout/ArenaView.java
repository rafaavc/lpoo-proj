package com.g19.breakout;

import com.g19.breakout.elements.*;
import com.g19.breakout.graphics.Graphics;

import java.io.IOException;


public class ArenaView {
    private final Graphics graphics;
    private final String backgroundColor = "#000000";

    public ArenaView(ArenaModel arena, Graphics graphics) throws IOException {
        this.graphics = graphics;
        graphics.init(arena.getWidth(), arena.getHeight());
    }

    public void draw(ArenaModel arena) throws IOException {
        graphics.startDrawing();

        drawBackground(arena);
        drawPlayerBar(arena.getPlayerBar());
        drawBall(arena.getBall());

        graphics.stopDrawing();
    }


    void drawBall(Ball ball) {
        graphics.drawElement(ball);
    }

    void drawPlayerBar(PlayerBar playerBar) {
        graphics.drawElement(playerBar);
    }

    void drawBackground(ArenaModel arena) {
        graphics.drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', getBGColor());
    }

    public ArenaController.COMMAND readInput() throws IOException {
        return graphics.readInput();
    }

    public String getBGColor() {
        return backgroundColor;
    }
}
