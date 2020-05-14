package com.g19.breakout.view;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;

import java.util.ArrayList;
import java.util.List;

public class MenuView implements View {
    private final List<MenuButtonView> views;
    private final Dimensions dimensions;
    private final Position position;

    public MenuView(Dimensions dimensions, Position position) {
        views = new ArrayList<>();
        this.dimensions = dimensions;
        this.position = position;
    }

    public void addView(MenuButtonView view) {
        views.add(view);
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
        views.forEach(MenuButtonView::draw);
    }
}
