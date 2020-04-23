package com.g19.breakout.view;

import com.g19.breakout.controller.Command;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.elements.*;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerBarModel;

import java.io.IOException;


public class ArenaView {
    private final Graphics graphics;
    private final String backgroundColor = "#000000";
    private final ArenaModel arena;
    private final BallView ballView;


    public enum COMMAND {NONE, EXIT, RIGHT, LEFT}

    public ArenaView(ArenaModel arena, Graphics graphics) throws IOException {
        this.graphics = graphics;
        this.arena = arena;
        graphics.init(arena.getWidth(), arena.getHeight());
        this.ballView = new BallView(arena.getBall(), graphics, "#0000ff", '█');
    }

    public void draw() throws IOException {
        graphics.startDrawing();

        drawBackground(arena);
        drawPlayerBar(arena.getPlayerBar());
        ballView.draw();

        graphics.stopDrawing();
    }

    public void drawPlayerBar(PlayerBarModel playerBar) {
        graphics.drawElement(playerBar, "██████", "#ffffff");
    }

    public void drawBackground(ArenaModel arena) {
        graphics.drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', getBGColor());
    }

    public COMMAND readInput() throws IOException {
        return graphics.readInput();
    }

    public String getBGColor() {
        return backgroundColor;
    }
}
