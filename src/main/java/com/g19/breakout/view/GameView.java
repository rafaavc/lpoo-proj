package com.g19.breakout.view;

import com.g19.breakout.view.graphics.Graphics;

import java.io.IOException;

public class GameView {
    private final Graphics graphics;
    private final BackgroundView backgroundView;
    private View view;

    public enum Keys {ARROWLEFT, ARROWRIGHT, EOF, NONE, PKEY, QKEY, LKEY, ENTER};

    public GameView(Graphics graphics, BackgroundView backgroundView) {
        this.graphics = graphics;
        this.backgroundView = backgroundView;
    }

    public void draw() throws IOException {
        graphics.startDrawing();

        backgroundView.draw();
        view.draw();

        graphics.stopDrawing();
    }

    public void setView(View view) {
        this.view = view;
    }

    public Keys readInput() throws IOException {
        return graphics.readInput();
    }

    public Keys readTextInput(StringBuilder sb) throws IOException {
        return graphics.readTextInput(sb);
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void exit() throws IOException {
        graphics.exit();
    }
}
