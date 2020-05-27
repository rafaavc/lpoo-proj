package com.g19.breakout.view.graphics;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.GameView;

import java.io.IOException;

public interface Graphics {
    void startDrawing();
    void stopDrawing() throws IOException;
    void drawString(Position pos, String text, String foreColor);
    void drawCenteredString(Position pos, String text, String foreColor);
    void drawString(Position pos, String text, String foreColor, String backColor);
    void drawCenteredString(Position pos, String text, String foreColor, String backColor);
    void drawRectangle(Position leftUpperCorner, Dimensions size, char fill, String backColor);
    void exit() throws IOException;
    Position setOffset(Position offset);
    GameView.Keys readInput() throws IOException;
    GameView.Keys readTextInput(StringBuilder sb) throws IOException;
}

