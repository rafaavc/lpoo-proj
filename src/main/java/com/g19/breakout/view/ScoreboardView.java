package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.view.graphics.Graphics;

public class ScoreboardView implements View {
    Graphics graphics;
    ScoreboardView(Graphics graphics) {
        this.graphics = graphics;
    }
    public void draw(ArenaModel arena) {
        graphics.setOffset(new Position(0, 0));
        graphics.drawRectangle(new Position(0, 0), new Dimensions(120, 1), ' ', "#151515");
        graphics.drawRectangle(new Position(0, 1), new Dimensions(120, 3), ' ', "#1f1f1f");
        graphics.drawRectangle(new Position(0, 4), new Dimensions(120, 1), ' ', "#151515");
        graphics.drawCenteredString(new Position(60, 2), Integer.toString(arena.getPlayer().getPoints()), "#ffffff");
    }
}
