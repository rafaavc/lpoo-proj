package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.factory.BasicViewFactory;
import com.g19.breakout.view.graphics.Graphics;

public class PauseView implements View {
    Graphics graphics;
    Dimensions gameDimensions;
    PlayerView playerView;
    PlayerModel playerModel;

    public PauseView(Graphics graphics, Dimensions gameDimensions) {
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;
    }

    public void setPlayerView(PlayerModel playerModel) {
        playerView = new BasicViewFactory().createPlayerView(playerModel, graphics);
        this.playerModel = playerModel;
    }

    public void draw() {
        String backColor = "#000000";
        Position prevOffset = graphics.setOffset(new Position(0, 0));

        graphics.drawRectangle(new Position(0, 0), gameDimensions, ' ', backColor);
        graphics.drawRectangle(new Position(0, gameDimensions.getDiscreteY()/2.),
                new Dimensions(gameDimensions.getDiscreteX()/2., gameDimensions.getDiscreteY()/2.),
                ' ', "#1da50b");
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/4., 3*gameDimensions.getDiscreteY()/4.),
                "Resume Game (P)", "#ffffff", "#1da50b");
        graphics.drawRectangle(new Position(gameDimensions.getDiscreteX()/2., gameDimensions.getDiscreteY()/2.),
                new Dimensions(gameDimensions.getDiscreteX()/2., gameDimensions.getDiscreteY()/2.),
                ' ', "#a30d0d");
        graphics.drawCenteredString(new Position(3*gameDimensions.getDiscreteX()/4., 3*gameDimensions.getDiscreteY()/4.),
                "Quit Game (Q)", "#ffffff", "#a30d0d");
        graphics.drawCenteredString(new Position(60, 12), "Game Paused", "#ffffff", backColor);
        playerView.drawWithoutArena(playerModel);

        graphics.setOffset(prevOffset);
    }
}
