package com.g19.breakout.graphics;

import com.g19.breakout.elements.Position;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface Graphics {
    void init(int terminalWidth, int terminalHeight) throws IOException;
    void startDrawing();
    void stopDrawing() throws IOException;
    void drawString(Position pos, String text, String foreColor);
    void drawCenteredString(Position pos, String text, String foreColor);
    void drawString(Position pos, String text, String foreColor, String backColor);
    void drawCenteredString(Position pos, String text, String foreColor, String backColor);
    void drawRectangle(Position leftUpperCorner, Position size, char fill, String backColor);
    KeyStroke readInput() throws IOException;
}

