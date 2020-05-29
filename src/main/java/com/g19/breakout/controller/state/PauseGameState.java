package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.PauseView;
import com.g19.breakout.view.View;


public class PauseGameState extends MenuGameState {
    private final PlayingGameState playingGameState;
    private final PauseView view;
    private final StateFactory stateFactory;

    public PauseGameState(PlayingGameState playingGameState, PlayerModel playerModel, PauseView view, GameController controller, MenuController menu, StateFactory stateFactory) {
        super(controller, playerModel, menu);
        this.playingGameState = playingGameState;
        this.view = view;
        this.stateFactory = stateFactory;
    }

    @Override
    public void commandP() {
        controller.setState(playingGameState);
    }

    @Override
    public void commandQ() {
        controller.setState(stateFactory.createMainMenuGameState(controller));
    }

    public View getView() {
        return view;
    }
}
