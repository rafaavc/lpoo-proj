package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;


public class MainMenuView extends SuperView<View> {
    private final Dimensions gameDimensions;
    private final String backgroundColor;

    public MainMenuView(Graphics graphics, Dimensions gameDimensions, String backgroundColor) {
        super(graphics, new Position(0, 0));
        this.gameDimensions = gameDimensions;
        this.backgroundColor = backgroundColor;
    }

    public void drawSelf() {
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 10), "Welcome to", "#ffffff", backgroundColor);
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 12), "BREAKOUT", "#ffffff", backgroundColor);
    }
}
