package com.g19.breakout;

import com.g19.breakout.elements.PlayerBar;
import com.g19.breakout.elements.Position;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;
import java.nio.file.LinkPermission;

public class Controller {
    private Arena arena;

    public Controller(Arena arena) {
        this.arena = arena;
    }

    public boolean getNextCommand(View view) throws IOException {
        TerminalScreen screen = view.getScreen();
        KeyStroke key = screen.readInput();

        if (key.getKeyType() == KeyType.EOF) return false;

        Position playerBarPosition = arena.getPlayerBar().getPosition();

        if (key.getKeyType() == KeyType.ArrowRight)
            arena.movePlayerBar(playerBarPosition.right());
        else if (key.getKeyType() == KeyType.ArrowLeft)
            arena.movePlayerBar(playerBarPosition.left());

        return true;
    }
}
