package com.g19.breakout.view;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.view.graphics.Graphics;

public class BallView extends ElementView implements View {
    public BallView(BallModel ball, Graphics graphics, String color, char charRep) {
        super(ball, graphics, color, charRep);
    }

    public void draw(ArenaModel arena) {
        drawModel(arena.getBall());
    }
}
