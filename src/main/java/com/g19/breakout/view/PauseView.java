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
    private final List<View> views;

    public PauseView(Graphics graphics, Dimensions gameDimensions, PlayerModel playerModel) {
        this.graphics = graphics;
        this.gameDimensions = gameDimensions;
        views = new ArrayList<>();
    }

    public void draw() {
        String backColor = "#000000";
        Position prevOffset = graphics.setOffset(new Position(0, 0));

        graphics.drawRectangle(new Position(0, 0), gameDimensions, ' ', backColor);
        graphics.drawCenteredString(new Position(60, 12), "Game Paused", "#ffffff", backColor);

        views.forEach(View::draw);

        graphics.setOffset(prevOffset);
    }

    public void addView(View view) {
        views.add(view);
    }
}
