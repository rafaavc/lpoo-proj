package com.g19.breakout.view;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.elements.*;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.graphics.Graphics;

import java.io.IOException;
import java.util.List;


public class ArenaView {
    private final Graphics graphics;
    private String backgroundColor = "#000000";
    private final ArenaModel arena;
    private final BallView ballView;
    private final PlayerBarView playerBarView;
    private final TilesView tilesView;


    public enum Keys {ARROWLEFT, ARROWRIGHT, EOF, NONE};

    public ArenaView(ArenaModel arena, Graphics graphics) throws IOException {
        this.graphics = graphics;
        this.arena = arena;
        this.ballView = new BallView(arena.getBall(), graphics, "#0000ff", '█');
        this.playerBarView = new PlayerBarView(arena.getPlayerBar(), graphics, "#ffffff", '█');
        this.tilesView = new TilesView(arena.getTiles().get(0), graphics, "#ff0000", '█');
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
