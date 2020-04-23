package com.g19.breakout.view;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.elements.*;
import com.g19.breakout.view.graphics.Graphics;

import java.io.IOException;


public class ArenaView {
    private final Graphics graphics;
    private String backgroundColor = "#000000";
    private final ArenaModel arena;
    private final BallView ballView;
    private final PlayerBarView playerBarView;


    public enum Keys {ARROWLEFT, ARROWRIGHT, EOF, NONE};

    public ArenaView(ArenaModel arena, Graphics graphics) throws IOException {
        this.graphics = graphics;
        this.arena = arena;
        this.ballView = new BallView(arena.getBall(), graphics, "#0000ff", '█');
        this.playerBarView = new PlayerBarView(arena.getPlayerBar(), graphics, "#ffffff", '█');
    }

    public void draw() throws IOException {
        graphics.startDrawing();

        drawBackground(arena);
        playerBarView.draw();
        ballView.draw();

        graphics.stopDrawing();
    }

    public void drawBackground(ArenaModel arena) {
        graphics.drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', getBGColor());
    }

    public ArenaView.Keys readInput() throws IOException {
        return graphics.readInput();
    }

    public String getBGColor() {
        return backgroundColor;
    }
}
