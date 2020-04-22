package com.g19.breakout;

import com.g19.breakout.elements.*;
import com.g19.breakout.graphics.Graphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;


public class ArenaView {
    private final Graphics graphics;
    //private TerminalScreen screen;
    private final String backgroundColor = "#000000";

    public ArenaView(ArenaModel arena, Graphics graphics) throws IOException {
        this.graphics = graphics;
        graphics.init(arena.getWidth(), arena.getHeight());
    }

    public void draw(ArenaView view, ArenaModel arena) throws IOException {
        view.graphics.startDrawing();

        view.drawBackground(arena);
        view.drawPlayerBar(arena.getPlayerBar());
        view.drawBall(arena.getBall());

        view.graphics.stopDrawing();
    }


    void drawBall(Ball ball) {
        graphics.drawCenteredString(ball.getPosition(), ball.getStringRep(), ball.getColor());
    }

    void drawPlayerBar(PlayerBar playerBar) {
        graphics.drawCenteredString(playerBar.getPosition(), playerBar.getStringRep(), playerBar.getColor());
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
