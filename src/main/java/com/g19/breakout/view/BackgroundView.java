package com.g19.breakout.view;

import com.g19.breakout.model.GameModel;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.BackgroundModel;
import com.g19.breakout.view.graphics.Graphics;

public class BackgroundView implements View {
    private final Graphics graphics;
    private final Dimensions gameDimensions;
    private final BackgroundModel model;
    private final String backgroundColor;


    public BackgroundView(Graphics graphics, GameModel gameModel, String backgroundColor) {
        this.graphics = graphics;
        this.gameDimensions = gameModel.getDimensions();
        this.model = gameModel.getBackgroundModel();
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
