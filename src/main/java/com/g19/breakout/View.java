package com.g19.breakout;

import com.g19.breakout.elements.*;
import com.g19.breakout.graphics.Graphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;


public class View {
    private Arena arena;
    private final Graphics graphics;
    //private TerminalScreen screen;
    private final String backgroundColor = "#000000";
    private final String playerBarColor = "#FFFFFF";

    public View(Arena arena, Graphics graphics) throws IOException {
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
        graphics.drawString(playerBar.getPosition(), "------", playerBarColor);
    }

    private void drawBackground(){
        graphics.drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', backgroundColor);
    }

    public KeyStroke readInput() throws IOException {
        return graphics.readInput();
    }
}
