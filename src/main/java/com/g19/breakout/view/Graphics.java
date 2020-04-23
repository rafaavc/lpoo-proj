package com.g19.breakout.view;

import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.controller.Command;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.Element;
import java.io.IOException;

public interface Graphics {
    void init(int terminalWidth, int terminalHeight) throws IOException;
    void startDrawing();
    void stopDrawing() throws IOException;
    void drawString(Position pos, String text, String foreColor);
    void drawCenteredString(Position pos, String text, String foreColor);
    void drawString(Position pos, String text, String foreColor, String backColor);
    void drawCenteredString(Position pos, String text, String foreColor, String backColor);
    void drawElement(Element element, String stringRep, String color);
    void drawRectangle(Position leftUpperCorner, Position size, char fill, String backColor);
    ArenaView.COMMAND readInput() throws IOException;
}

