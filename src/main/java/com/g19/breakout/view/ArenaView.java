package com.g19.breakout.view;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.elements.*;
import com.g19.breakout.view.factory.ViewFactory;
import com.g19.breakout.view.graphics.Graphics;

import java.io.IOException;


public class ArenaView {
    private final Graphics graphics;
    private String backgroundColor = "#000000";
    private final ArenaModel arena;
    private final BallView ballView;
    private final PlayerBarView playerBarView;
    private final TilesView tilesView;


    public enum Keys {ARROWLEFT, ARROWRIGHT, EOF, NONE};

    public ArenaView(ArenaModel arena, Graphics graphics, ViewFactory factory) {
        this.graphics = graphics;
        this.arena = arena;
        this.ballView = factory.createBallView(arena.getBall(), graphics);
        this.playerBarView = factory.createPlayerBarView(arena.getPlayerBar(), graphics);
        this.tilesView = factory.createTilesView(arena.getTiles().get(0), graphics);
    }

    public void draw() throws IOException {
        graphics.startDrawing();

        drawBackground(arena);
        tilesView.draw(arena.getTiles());
        playerBarView.draw(arena.getPlayerBar());
        ballView.draw(arena.getBall());

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
