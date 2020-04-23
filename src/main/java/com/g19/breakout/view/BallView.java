package com.g19.breakout.view;

import com.g19.breakout.model.BallModel;
import com.g19.breakout.view.graphics.Graphics;

public class BallView extends ElementView {
    BallView(BallModel ball, Graphics graphics, String color, char charRep) {
        super(ball, graphics, color, charRep);
    }
}
