package com.g19.breakout.view;

import com.g19.breakout.elements.Position;
import com.g19.breakout.view.graphics.Graphics;

import java.util.ArrayList;
import java.util.List;

public abstract class SuperView<T extends View> implements View {
    protected final List<T> views;
    protected final Position offset;
    protected final Graphics graphics;

    public SuperView(Graphics graphics, Position offset) {
        this.views = new ArrayList<>();
        this.offset = offset;
        this.graphics = graphics;
    }

    public void addView(T view) {
        this.views.add(view);
    }

    public void drawSelf() {}

    public void draw() {
        Position prevOffset = graphics.setOffset(offset);

        this.views.forEach(View::draw);
        this.drawSelf();

        graphics.setOffset(prevOffset);
    }
}