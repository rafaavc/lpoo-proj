package com.g19.breakout.graphics;

import com.g19.breakout.elements.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaAdapter implements Graphics {
    private TerminalScreen screen;
    private TextGraphics textGraphics;

    public void init(int terminalWith, int terminalHeight) throws IOException {
        TerminalSize terminalSize = new TerminalSize(terminalWith, terminalHeight);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(terminalSize);

        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    public void startDrawing() {
        screen.clear();
        textGraphics = screen.newTextGraphics();
    }

    public void stopDrawing() throws IOException {
        screen.refresh();
    }

    public void drawString(Position pos, String text, String foreColor) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString(foreColor));
        textGraphics.putString(pos.getX(), pos.getY(), text);
    }

    public void drawString(Position pos, String text, String foreColor, String backColor) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString(foreColor));
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(backColor));
        textGraphics.putString(pos.getX(), pos.getY(), text);
    }

    public void drawRectangle(Position leftUpperCorner, Position size, char fill, String backColor) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(backColor));
        textGraphics.fillRectangle(
            new TerminalPosition(leftUpperCorner.getX(),leftUpperCorner.getY()),
            new TerminalSize(size.getX(), size.getY()),
            fill);
    }

    public KeyStroke readInput() throws IOException {
        return screen.readInput();
    }
}

