package com.g19.breakout;

import com.g19.breakout.elements.*;
import com.g19.breakout.graphics.Graphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;


public class ArenaView {
    private ArenaModel arena;
    private final Graphics graphics;
    //private TerminalScreen screen;
    private final String backgroundColor = "#000000";
    private final String playerBarColor = "#FFFFFF";

    public ArenaView(ArenaModel arena, Graphics graphics) throws IOException {
        this.arena = arena;
        this.graphics = graphics;
        graphics.init(arena.getWidth(), arena.getHeight());
    }

    public void draw() throws IOException {
        graphics.startDrawing();

        drawBackground();
        drawPlayerBar(arena.getPlayerBar());

        graphics.stopDrawing();
    }

    private void drawPlayerBar(PlayerBar playerBar){
        graphics.drawCenteredString(playerBar.getPosition(), "------", playerBarColor);
    }

    private void drawBackground(){
        graphics.drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', backgroundColor);
    }

    public ArenaController.COMMAND readInput() throws IOException {
        KeyType key = graphics.readInput().getKeyType();
        if (key == KeyType.ArrowLeft) return ArenaController.COMMAND.LEFT;
        if (key == KeyType.ArrowRight) return ArenaController.COMMAND.RIGHT;
        if (key == KeyType.EOF) return ArenaController.COMMAND.EOF;
        return ArenaController.COMMAND.NONE;
    }
}
