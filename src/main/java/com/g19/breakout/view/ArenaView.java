package com.g19.breakout.view;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.elements.*;
import com.g19.breakout.view.graphics.Graphics;


public class ArenaView extends SuperView<View> implements View {
    private final Graphics graphics;
    private String backgroundColor = "#000000";
    private final Dimensions gameDimensions;
    private final ArenaModel arena;

    public ArenaView(Graphics graphics, ArenaModel arena, Dimensions gameDimensions) {
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;
        this.arena = arena;
    }

    public void draw() {
        Position prevOffset = graphics.setOffset(arena.getTopLeftCorner());

        graphics.drawRectangle(new Position(0, 0), gameDimensions, ' ', getBGColor());
        drawViews();

        graphics.setOffset(prevOffset);
    }

    public String getBGColor() {
        return backgroundColor;
    }
}
