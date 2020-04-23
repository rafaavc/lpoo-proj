package com.g19.breakout.view;

import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.view.graphics.Graphics;

public abstract class ElementView {
    String color, stringRep;
    char charRep;
    Graphics graphics;

    ElementView(ElementModel model, Graphics graphics, String color, char charRep) {
        this.color = color;
        this.graphics = graphics;
        this.charRep = charRep;
        updateStringRep(model);
    }

    // Maybe in the future this could be an observer that is
    // notified when the size of the ball changes and then updates the stringRep
    void updateStringRep(ElementModel model) {
        StringBuilder strBuffer = new StringBuilder();
        for (int i = 0; i < model.getDimensions().getDiscreteX(); i++) {
            strBuffer.append(charRep);
        }
        this.stringRep = strBuffer.toString();
    }

    void drawModel(ElementModel model) {
        for (int i = 0; i < model.getDimensions().getDiscreteY(); i++) {
            Position pos = new Position(
                model.getPosition().getDiscreteX(),
                model.getPosition().getDiscreteY() + i
            );
            graphics.drawCenteredString(pos, stringRep, color);
        }
    }
}
