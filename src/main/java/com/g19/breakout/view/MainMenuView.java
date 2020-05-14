package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;

public class MainMenuView implements View {
    private final Graphics graphics;

    public MainMenuView(Graphics graphics) {
        this.graphics = graphics;
    }

    public void draw() {
        graphics.drawRectangle(new Position(0, 0), new Dimensions(120, 50), ' ', "#000000");
        graphics.drawString(new Position(10, 10), "Main menu", "#ffffff", "#000000");
    }
}
