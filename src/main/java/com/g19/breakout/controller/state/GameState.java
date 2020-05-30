package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;

public abstract class GameState implements State {
    protected final GameController controller;

    public GameState(GameController controller) {
        this.controller = controller;
    }
}
