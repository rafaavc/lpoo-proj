package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.view.View;

public abstract class GameState {
    protected final GameController controller;

    public GameState(GameController controller) {
        this.controller = controller;
    }

    public void update(int elapsedTime) {}

    public boolean commandLeft() { return true; }

    public boolean commandRight() { return true; }

    public boolean commandP() { return true; }

    public boolean commandQ() { return true; }

    public boolean commandENTER() { return true; }

    public abstract View getView();
}
