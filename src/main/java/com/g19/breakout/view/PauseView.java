package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;


public class PauseView extends SuperView<View> {
    private final Graphics graphics;
    private final Dimensions gameDimensions;
    private final String backgroundColor;

    public PauseView(Graphics graphics, Dimensions gameDimensions, String backgroundColor) {
        super(graphics, new Position(0, 0));
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;
        this.backgroundColor = backgroundColor;
    }

    public void drawSelf() {
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 12), "Game Paused", "#ffffff", backgroundColor);
    }
}
