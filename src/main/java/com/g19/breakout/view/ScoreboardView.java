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
        String backColor = "#1f1f1f";
        String borderColor = "#151515";
        String textColor = "#ffffff";
        graphics.setOffset(new Position(0, 0));
        graphics.drawRectangle(new Position(0, 0), new Dimensions(120, 1), ' ', borderColor);
        graphics.drawRectangle(new Position(0, 1), new Dimensions(120, 3), ' ', backColor);
        graphics.drawRectangle(new Position(0, 4), new Dimensions(120, 1), ' ', borderColor);
        graphics.drawString(new Position(4, 2), "Press P to pause", textColor, backColor);
        graphics.drawCenteredString(new Position(60, 2), Integer.toString(arena.getPlayer().getPoints()), textColor, backColor);
    }
}
