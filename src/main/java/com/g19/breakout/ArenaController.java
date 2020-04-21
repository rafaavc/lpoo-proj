package com.g19.breakout;

import com.g19.breakout.elements.PlayerBar;
import com.g19.breakout.elements.Position;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;
import java.nio.file.LinkPermission;

public class ArenaController {
    private ArenaModel arena;
    private ArenaView view;

    public enum COMMAND {NONE, EOF, RIGHT, LEFT}

    public ArenaController(ArenaModel arena, ArenaView view) {
        this.arena = arena;
        this.view = view;
    }

    public void start() throws IOException {
        do { view.draw(); }
        while ( this.getNextCommand(view) );
    }

    public boolean getNextCommand(ArenaView view) throws IOException {
        COMMAND cmd = view.readInput();

        if (cmd == COMMAND.EOF) return false;

        Position playerBarPosition = arena.getPlayerBar().getPosition();

        if (cmd == COMMAND.RIGHT) arena.movePlayerBar(playerBarPosition.right());
        else if (cmd == COMMAND.LEFT) arena.movePlayerBar(playerBarPosition.left());

        return true;
    }
}
