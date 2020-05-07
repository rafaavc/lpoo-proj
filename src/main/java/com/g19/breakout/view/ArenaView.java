package com.g19.breakout.view;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.elements.*;
import com.g19.breakout.view.graphics.Graphics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArenaView implements View {
    private final Graphics graphics;
    private final List<View> views;
    private String backgroundColor = "#000000";
    private final ScoreboardView scoreboard;


    public enum Keys {ARROWLEFT, ARROWRIGHT, EOF, NONE};

    public ArenaView(Graphics graphics) {
        this.graphics = graphics;
        this.views = new ArrayList<>();
        views.add(this);
        scoreboard = new ScoreboardView(graphics);
    }

    public void drawArena(ArenaModel arena) throws IOException {
        graphics.startDrawing();

        scoreboard.draw(arena);
        graphics.setOffset(arena.getTopLeftCorner());
        for (View v : views) v.draw(arena);

        graphics.stopDrawing();
    }

    public void draw(ArenaModel arena){
        graphics.drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', getBGColor());
    }

    public void addView(View v) {
        views.add(v);
    }

    public ArenaView.Keys readInput() throws IOException {
        return graphics.readInput();
    }

    public String getBGColor() {
        return backgroundColor;
    }
}
