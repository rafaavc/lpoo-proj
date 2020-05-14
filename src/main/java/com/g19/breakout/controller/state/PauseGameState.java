package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.PauseView;

public class PauseGameState implements GameState {
    private final PlayingGameState playingGameState;
    private final PauseView view;
    private final GameController controller;
    private final StateFactory stateFactory;
    private final PlayerModel playerModel;

    PauseGameState(PlayingGameState playingGameState, PauseView view, GameController controller, StateFactory stateFactory) {
        this.playingGameState = playingGameState;
        this.controller = controller;
        this.view = view;
        this.stateFactory = stateFactory;
        this.playerModel = view.getPlayerModel();
    }

    public void commandL() {
        controller.moveElement(playerModel.getPosition().left(), playerModel);
    }

    public void commandR() {
        controller.moveElement(playerModel.getPosition().right(), playerModel);
    }

    public void commandP() {
        controller.setState(playingGameState, new Chronometer());
    }

    public void commandQ() {
        controller.setState(stateFactory.createMainMenuGameState(controller), new Chronometer());
    }

    public PauseView getView() {
        return view;
    }
}
