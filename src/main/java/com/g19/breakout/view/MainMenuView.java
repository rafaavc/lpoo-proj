package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;


public class MainMenuView extends SuperView<View> implements View {
    private final Graphics graphics;
    private final Dimensions gameDimensions;

    public MainMenuView(Graphics graphics, Dimensions gameDimensions) {
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;
    }

    public void draw() {
        Position prevOffset = graphics.setOffset(new Position(0, 0));

        graphics.drawRectangle(new Position(0, 0), gameDimensions, ' ', "#000000");
        graphics.drawString(new Position(10, 10), "Main menu", "#ffffff", "#000000");

        drawViews();

        graphics.setOffset(prevOffset);
    }
}
