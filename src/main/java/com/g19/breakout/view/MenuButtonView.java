package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;

public class MenuButtonView implements View {
    private final String text, color;
    private Position position;
    private Dimensions dimensions;
    private final Graphics graphics;

    public MenuButtonView(String text, String color, Graphics graphics) {
        this.text = text;
        this.color = color;
        this.graphics = graphics;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void draw() {
        graphics.drawRectangle(position, dimensions, ' ', color);
        Position stringPosition = new Position(
                dimensions.getDiscreteX()/2. + position.getDiscreteX(),
                dimensions.getDiscreteY()/3. + position.getDiscreteY()
        );
        graphics.drawCenteredString(stringPosition, text, "#ffffff", color);
    }
}
