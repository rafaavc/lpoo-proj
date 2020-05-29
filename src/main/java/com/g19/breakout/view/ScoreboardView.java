package com.g19.breakout.view;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.graphics.Graphics;

public class ScoreboardView implements View {
    private final Graphics graphics;
    private final PlayerModel playerModel;
    public ScoreboardView(Graphics graphics, PlayerModel player) {
        this.graphics = graphics;
        this.playerModel = player;
    }

    public void draw() {
        String backColor = "#1f1f1f";
        String borderColor = "#151515";
        String textColor = "#ffffff";

        Position prevOffset = graphics.setOffset(new Position(0, 0));

        graphics.drawRectangle(new Position(0, 0), new Dimensions(120, 1), ' ', borderColor);
        graphics.drawRectangle(new Position(0, 1), new Dimensions(120, 3), ' ', backColor);
        graphics.drawRectangle(new Position(0, 4), new Dimensions(120, 1), ' ', borderColor);
        graphics.drawString(new Position(4, 2), "Press P to pause", textColor, backColor);
        graphics.drawCenteredString(new Position(60, 2), Integer.toString(playerModel.getPoints()), textColor, backColor);

        graphics.setOffset(prevOffset);
    }


}
