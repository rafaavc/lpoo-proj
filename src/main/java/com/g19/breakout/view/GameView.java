package com.g19.breakout.view;

import com.g19.breakout.view.graphics.Graphics;

import java.io.IOException;

public class GameView {
    Graphics graphics;
    View view;

    public enum Keys {ARROWLEFT, ARROWRIGHT, EOF, NONE, PKEY};

    public GameView(Graphics graphics) {
        this.graphics = graphics;
    }

    public void draw() throws IOException {
        graphics.startDrawing();

        view.draw();

        graphics.stopDrawing();
    }

    public void setView(View view) {
        this.view = view;
    }

    public Keys readInput() throws IOException {
        return graphics.readInput();
    }

    public Graphics getGraphics() {
        return graphics;
    }
}
