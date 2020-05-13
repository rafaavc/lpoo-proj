package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;

public class PauseView implements SuperView {
    Graphics graphics;

    public PauseView(Graphics graphics) {
        this.graphics = graphics;
    }

    public void drawAll() {
        graphics.setOffset(new Position(0, 0));
        graphics.drawRectangle(new Position(0, 0), new Dimensions(120, 50), ' ', "#000000");
        graphics.drawCenteredString(new Position(60, 20), "Pause", "#ffffff");
        graphics.drawCenteredString(new Position(60, 22), "Press P to return to the game", "#ffffff");
    }

    public Graphics getGraphics() {
        return graphics;
    }
}
