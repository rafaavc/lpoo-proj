package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.view.MainMenuView;
import com.g19.breakout.view.View;

public class MainMenuGameState implements GameState {
    private final MainMenuView mainMenuView;
    private final GameController controller;
    private final StateFactory stateFactory;

    public MainMenuGameState(GameController controller, MainMenuView mainMenuView, StateFactory stateFactory) {
        this.mainMenuView = mainMenuView;
        this.controller = controller;
        this.stateFactory = stateFactory;
    }

    public boolean commandL() {
        return true;
    }

    public boolean commandR() {
        return true;
    }

    public boolean commandQ() {
        return false;
    }

    public boolean commandP() {
        controller.setState(stateFactory.createPlayingGameState(controller), new Chronometer());
        return true;
    }

    public View getView() {
        return mainMenuView;
    }
}
