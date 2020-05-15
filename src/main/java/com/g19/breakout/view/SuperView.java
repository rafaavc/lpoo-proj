package com.g19.breakout.view;

import java.util.ArrayList;
import java.util.List;

public abstract class SuperView<T> {
    protected final List<T> views;

    public SuperView() {
        this.views = new ArrayList<>();
    }

    public void addView(T view) {
        this.views.add(view);
    }

    public void drawViews() {
        this.views.forEach(v -> ((View)v).draw());
    }
}