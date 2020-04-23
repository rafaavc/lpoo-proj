package com.g19.breakout.view;

import com.g19.breakout.elements.Position;
import com.g19.breakout.model.BallModel;

public class BallView {
    String color, stringRep;
    char charRep;
    Graphics graphics;
    BallModel ball;

    BallView(BallModel ball, Graphics graphics, String color, char charRep) {
        this.color = color;
        this.ball = ball;
        this.graphics = graphics;
        this.charRep = charRep;
        updateStringRep();
    }

    // Maybe in the future this could be an observer that is
    // notified when the size of the ball changes and then updates the stringRep
    void updateStringRep() {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < ball.getDimensions().getDiscreteX(); i++) {
            strBuffer.append(charRep);
        }
        this.stringRep = strBuffer.toString();
    }

    void draw() {
        for (int i = 0; i < ball.getDimensions().getDiscreteY(); i++) {
            Position pos = new Position(
                    ball.getPosition().getDiscreteX(),
                    ball.getPosition().getDiscreteY() + i
            );
            graphics.drawCenteredString(pos, stringRep, color);
        }
    }
}
