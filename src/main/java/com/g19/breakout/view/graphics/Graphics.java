package com.g19.breakout.view.graphics;

import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.view.ArenaView;

import java.io.IOException;

public interface Graphics {
    void startDrawing();
    void stopDrawing() throws IOException;
    void drawString(Position pos, String text, String foreColor);
    void drawCenteredString(Position pos, String text, String foreColor);
    void drawRectangle(Position leftUpperCorner, Position size, char fill, String backColor);
    void setOffset(Position offset);
    ArenaView.Keys readInput() throws IOException;
}

