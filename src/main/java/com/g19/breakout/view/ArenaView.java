package com.g19.breakout.view;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.elements.*;
import com.g19.breakout.view.graphics.Graphics;

import java.util.ArrayList;
import java.util.List;


public class ArenaView implements View, SuperView {
    private final Graphics graphics;
    private final List<View> views;
    private String backgroundColor = "#000000";
    private final ScoreboardView scoreboard;
    private final ArenaModel arena;

    public ArenaView(Graphics graphics, ArenaModel arena) {
        this.graphics = graphics;
        this.views = new ArrayList<>();
        this.arena = arena;
        views.add(this);
        scoreboard = new ScoreboardView(graphics);
    }

    public void drawAll() {
        scoreboard.draw(arena);
        graphics.setOffset(arena.getTopLeftCorner());
        for (View v : views) v.draw(arena);
    }

    public void draw(ArenaModel arena){
        graphics.drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', getBGColor());
    }

    public void addView(View v) {
        views.add(v);
    }

    public String getBGColor() {
        return backgroundColor;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }
}
