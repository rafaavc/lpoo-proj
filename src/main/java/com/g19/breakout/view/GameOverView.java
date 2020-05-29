package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.graphics.Graphics;

public class GameOverView extends SuperView<View> {
    private final Dimensions gameDimensions;
    private final PlayerModel playerModel;
    private final String backgroundColor;

    public GameOverView(Graphics graphics, Dimensions gameDimensions, PlayerModel playerModel, String backgroundColor) {
        super(graphics, new Position(0, 0));
        this.gameDimensions = gameDimensions;
        this.playerModel = playerModel;
        this.backgroundColor = backgroundColor;
    }

    public void drawSelf() {
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 6), "Game Over", "#ffffff", backgroundColor);

        String score = "Total score: " + playerModel.getPoints() + " points";
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 10), score, "#ffffff", backgroundColor);

        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 13), "Insert your name, press ENTER when you're done.", "#ffffff", backgroundColor);
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 14), "If you press enter without writing anything, the score won't be saved.", "#ffffff", backgroundColor);

        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/2., 16), playerModel.getName(), "#ffffff", backgroundColor);
    }
}
