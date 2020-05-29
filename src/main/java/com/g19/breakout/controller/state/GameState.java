package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;

public abstract class GameState implements State {
    protected final GameController controller;
    protected boolean readingText;
    protected StringBuilder textReader;

    public GameState(GameController controller) {
        this.controller = controller;
        readingText = false;
    }
}
