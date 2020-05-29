package com.g19.breakout.view;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.BackgroundModel;
import com.g19.breakout.view.graphics.Graphics;

public class BackgroundView implements View {
    private final Graphics graphics;
    private final Dimensions gameDimensions;
    private final BackgroundModel model;
    private final String backgroundColor;


    public BackgroundView(Graphics graphics, Dimensions gameDimensions, BackgroundModel model, String backgroundColor) {
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;
        this.model = model;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void draw() {
        graphics.drawRectangle(new Position(0, 0), gameDimensions, ' ', backgroundColor);
        for (Position p : model.getParticles()) {
            graphics.drawString(p, ".", "#8e8e8e", backgroundColor);
        }
    }
}
