package com.g19.breakout;

import com.g19.breakout.elements.*;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.*;
import com.g19.breakout.Arena;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.w3c.dom.Text;

import java.io.IOException;


public class View {
    private Arena arena;
    private TerminalScreen screen;
    private final String backgroundColor = "#000000";
    private final String playerBarColor = "#FFFFFF";

    public View(Arena arena) throws IOException {
        this.arena = arena;
        TerminalSize terminalSize = new TerminalSize(arena.getWidth(), arena.getHeight());
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(terminalSize);

        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    public void draw() throws IOException {
        screen.clear();

        TextGraphics graphics = screen.newTextGraphics();

        drawBackground(graphics);

        drawPlayerBar(graphics, arena.getPlayerBar());

        screen.refresh();
    }

    private void drawPlayerBar(TextGraphics graphics, PlayerBar playerBar){
        graphics.setForegroundColor(TextColor.Factory.fromString(playerBarColor));

        Position playerBarPosition = playerBar.getPosition();
        graphics.putString(playerBarPosition.getX(), playerBarPosition.getY(), "---");
    }

    private void drawBackground(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString(backgroundColor));
        graphics.fillRectangle(
                new TerminalPosition(0,0),
                new TerminalSize(arena.getWidth(), arena.getHeight()),
                ' ');
    }
}
