package com.g19.breakout.view.graphics;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.GameView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaAdapter implements Graphics {
    private final TerminalScreen screen;
    private TextGraphics textGraphics;
    private Position offset;

    public LanternaAdapter(Dimensions dimensions) throws IOException {
        this.offset = new Position(0, 0);
        TerminalSize terminalSize = new TerminalSize(dimensions.getDiscreteX(), dimensions.getDiscreteY());

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(terminalSize);

        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    public void startDrawing() {
        textGraphics = screen.newTextGraphics();
    }

    public void stopDrawing() throws IOException {
        screen.refresh();
    }

    public void drawString(Position pos, String text, String foreColor) {
        pos = getPositionWithOffset(pos);
        textGraphics.setForegroundColor(TextColor.Factory.fromString(foreColor));
        textGraphics.putString(pos.getDiscreteX(), pos.getDiscreteY(), text);
    }

    public void drawCenteredString(Position pos, String text, String foreColor){
        drawString(new Position(pos.getX()-(text.length()/2.), pos.getY()), text, foreColor);
    }

    public void drawString(Position pos, String text, String foreColor, String backColor) {
        pos = getPositionWithOffset(pos);
        textGraphics.setForegroundColor(TextColor.Factory.fromString(foreColor));
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(backColor));
        textGraphics.putString(pos.getDiscreteX(), pos.getDiscreteY(), text);
    }

    public void drawCenteredString(Position pos, String text, String foreColor, String backColor){
        drawString(new Position(pos.getX()-(text.length()/2.), pos.getY()), text, foreColor, backColor);
    }

    public void drawRectangle(Position leftUpperCorner, Dimensions size, char fill, String backColor) {
        leftUpperCorner = getPositionWithOffset(leftUpperCorner);
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(backColor));
        textGraphics.fillRectangle(
            new TerminalPosition(leftUpperCorner.getDiscreteX(),leftUpperCorner.getDiscreteY()),
            new TerminalSize(size.getDiscreteX(), size.getDiscreteY()),
            fill);
    }

    public Position setOffset(Position offset) {
        Position prevOffset = this.offset;
        this.offset = offset;
        return prevOffset;
    }

    private Position getPositionWithOffset(Position pos) {
        return new Position(pos.getDiscreteX() + offset.getDiscreteX(), pos.getDiscreteY() + offset.getDiscreteY());
    }

    public GameView.Keys readInput() throws IOException {
        KeyStroke key = screen.pollInput();
        if (key != null) {
            KeyType keyType = key.getKeyType();
            if (keyType == KeyType.ArrowLeft) return GameView.Keys.ARROWLEFT;
            if (keyType == KeyType.ArrowRight) return GameView.Keys.ARROWRIGHT;
            if (keyType == KeyType.EOF) return GameView.Keys.EOF;
            if (key.getCharacter() == 'P' || key.getCharacter() == 'p') return GameView.Keys.PKEY;
        }
        return GameView.Keys.NONE;
    }
}

