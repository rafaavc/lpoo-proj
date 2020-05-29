package com.g19.breakout.view;

import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.view.graphics.Graphics;

public abstract class ElementView {
    protected String color, stringRep;
    protected char charRep;
    protected Graphics graphics;

    ElementView(ElementModel model, Graphics graphics, String color, char charRep) {
        this.color = color;
        this.graphics = graphics;
        this.charRep = charRep;
        updateStringRep(model);
    }

    void updateStringRep(ElementModel model) {
        StringBuilder strBuffer = new StringBuilder();
        for (int i = 0; i < model.getDimensions().getDiscreteX(); i++) {
            strBuffer.append(charRep);
        }
        this.stringRep = strBuffer.toString();
    }

    void drawElementModel(ElementModel model) {
        for (int i = 0; i < model.getDimensions().getDiscreteY(); i++) {
            Position pos = new Position(
                model.getPosition().getDiscreteX(),
                model.getPosition().getDiscreteY() + i
            );
            graphics.drawCenteredString(pos, stringRep, color);
        }
    }
}
