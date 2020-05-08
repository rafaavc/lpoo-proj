package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.view.PauseView;

public class PauseGameState implements GameState {
    PlayingGameState playingGameState;
    PauseView view;
    GameController controller;

    PauseGameState(PlayingGameState playingGameState, PauseView view, GameController controller) {
        this.playingGameState = playingGameState;
        this.controller = controller;
        this.view = view;
    }

    public void update(Chronometer chrono) {

    }
    public void commandL() {

    }
    public void commandR() {

    }
    public void commandP() {
        controller.setState(playingGameState, new Chronometer());
    }

    @Override
    public PauseView getView() {
        return view;
    }
}
