package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;

public class MenuView extends SuperView<MenuButtonView> implements View {
    private final Dimensions dimensions;
    private final Position position;

    public MenuView(Dimensions dimensions, Position position) {
        this.dimensions = dimensions;
        this.position = position;
    }

    @Override
    public void addView(MenuButtonView view) {
        super.addView(view);
        updateViews();
    }

    public void updateViews() {
        int viewCount = views.size();
        int buttonWidth = dimensions.getDiscreteX() / viewCount;

        for (int i = 0; i < viewCount; i++) {
            views.get(i).setDimensions(new Dimensions(buttonWidth, dimensions.getDiscreteY()));
            views.get(i).setPosition(new Position(i*buttonWidth + position.getDiscreteX(), position.getDiscreteY()));
        }
    }

    public void draw() {
        drawViews();
    }
}
