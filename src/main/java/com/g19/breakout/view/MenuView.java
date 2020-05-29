package com.g19.breakout.view;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.view.graphics.Graphics;

public class MenuView extends SuperView<MenuButtonView> {
    private final Dimensions dimensions;
    private final Position position;

    public MenuView(Graphics graphics, Dimensions dimensions, Position position) {
        super(graphics, new Position(0, 0));
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
}
