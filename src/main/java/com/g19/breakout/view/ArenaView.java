package com.g19.breakout.view;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.view.graphics.Graphics;


public class ArenaView extends SuperView<View> {
    public ArenaView(Graphics graphics, ArenaModel arena) {
        super(graphics, arena.getTopLeftCorner());
    }
}
