package com.g19.breakout.view.graphics;

import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.view.ArenaView;

import java.io.IOException;

public interface Graphics {
    void init(int terminalWidth, int terminalHeight) throws IOException;
    void startDrawing();
    void stopDrawing() throws IOException;
    void drawString(Position pos, String text, String foreColor);
    void drawCenteredString(Position pos, String text, String foreColor);
    void drawString(Position pos, String text, String foreColor, String backColor);
    void drawCenteredString(Position pos, String text, String foreColor, String backColor);
    void drawElement(ElementModel element, String stringRep, String color);
    void drawRectangle(Position leftUpperCorner, Position size, char fill, String backColor);
    ArenaView.COMMAND readInput() throws IOException;
}

