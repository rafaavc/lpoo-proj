package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.graphics.Graphics;

public class GameOverView extends SuperView<View> implements View {
    private final Graphics graphics;
    private final Dimensions gameDimensions;
    private final PlayerModel playerModel;

    public GameOverView(Graphics graphics, Dimensions gameDimensions, PlayerModel playerModel) {
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;
        this.playerModel = playerModel;
    }

    public void draw() {
        String backColor = "#000000";
        Position prevOffset = graphics.setOffset(new Position(0, 0));

        graphics.drawRectangle(new Position(0, 0), gameDimensions, ' ', backColor);
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 6), "Game Over", "#ffffff", backColor);

        String score = "Total score: " + playerModel.getPoints() + " points";
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 10), score, "#ffffff", backColor);

        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 13), "Insert your name, press ENTER when you're done", "#ffffff", backColor);

        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 15), playerModel.getName().equals("") ? "_" : playerModel.getName(), "#ffffff", backColor);

        drawViews();

        graphics.setOffset(prevOffset);
    }
}
