package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;


public class PauseView extends SuperView<View> implements View {
    private final Graphics graphics;
    private final Dimensions gameDimensions;

    public PauseView(Graphics graphics, Dimensions gameDimensions) {
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;
    }

    public void draw() {
        String backColor = "#000000";
        Position prevOffset = graphics.setOffset(new Position(0, 0));

        graphics.drawRectangle(new Position(0, 0), gameDimensions, ' ', backColor);
        graphics.drawCenteredString(new Position(60, 12), "Game Paused", "#ffffff", backColor);

        drawViews();

        graphics.setOffset(prevOffset);
    }
}
