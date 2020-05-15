package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.PauseView;


public class PauseGameState extends MenuGameState {
    private final PlayingGameState playingGameState;
    private final PauseView view;
    private final StateFactory stateFactory;

    PauseGameState(PlayingGameState playingGameState, PlayerModel playerModel, PauseView view, GameController controller, MenuController menu, StateFactory stateFactory) {
        super(controller, playerModel, menu);
        this.playingGameState = playingGameState;
        this.view = view;
        this.stateFactory = stateFactory;
    }

    @Override
    public boolean commandP() {
        controller.setState(playingGameState);
        return true;
    }

    @Override
    public boolean commandQ() {
        controller.setState(stateFactory.createMainMenuGameState(controller));
        return true;
    }

    public PauseView getView() {
        return view;
    }
}
