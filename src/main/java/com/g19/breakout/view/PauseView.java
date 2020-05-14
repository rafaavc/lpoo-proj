package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.factory.ViewFactory;
import com.g19.breakout.view.graphics.Graphics;

import java.util.ArrayList;
import java.util.List;

public class PauseView implements View {
    private final Graphics graphics;
    private final Dimensions gameDimensions;
    private final PlayerView playerView;
    private final List<View> views;

    public PauseView(Graphics graphics, Dimensions gameDimensions, PlayerModel playerModel, ViewFactory viewFactory) {
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;
        playerView = viewFactory.createPlayerView(playerModel, graphics);
        views = new ArrayList<>();
    }

    public void draw() {
        String backColor = "#000000";
        Position prevOffset = graphics.setOffset(new Position(0, 0));

        graphics.drawRectangle(new Position(0, 0), gameDimensions, ' ', backColor);
        /*graphics.drawRectangle(new Position(0, gameDimensions.getDiscreteY()/2.),
                new Dimensions(gameDimensions.getDiscreteX()/2., gameDimensions.getDiscreteY()/2.),
                ' ', "#1da50b");
        graphics.drawCenteredString(new Position(gameDimensions.getDiscreteX()/4., 3*gameDimensions.getDiscreteY()/4.),
                "Resume Game (P)", "#ffffff", "#1da50b");
        graphics.drawRectangle(new Position(gameDimensions.getDiscreteX()/2., gameDimensions.getDiscreteY()/2.),
                new Dimensions(gameDimensions.getDiscreteX()/2., gameDimensions.getDiscreteY()/2.),
                ' ', "#a30d0d");
        graphics.drawCenteredString(new Position(3*gameDimensions.getDiscreteX()/4., 3*gameDimensions.getDiscreteY()/4.),
                "Give Up (Q)", "#ffffff", "#a30d0d");*/
        graphics.drawCenteredString(new Position(60, 12), "Game Paused", "#ffffff", backColor);
        views.forEach(View::draw);

        playerView.draw();

        graphics.setOffset(prevOffset);
    }

    public void addView(View view) {
        views.add(view);
    }

    public PlayerModel getPlayerModel() {
        return playerView.getPlayerModel();
    }
}
