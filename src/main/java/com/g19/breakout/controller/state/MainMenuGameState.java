package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.MainMenuView;
import com.g19.breakout.view.View;

public class MainMenuGameState extends MenuGameState {
    private final MainMenuView mainMenuView;
    private final StateFactory stateFactory;

    public MainMenuGameState(GameController controller, MainMenuView mainMenuView, MenuController menu, PlayerModel playerModel, StateFactory stateFactory) {
        super(controller, playerModel, menu);
        this.mainMenuView = mainMenuView;
        this.stateFactory = stateFactory;
    }

    @Override
    public boolean commandQ() {
        return false;
    }

    @Override
    public boolean commandL() {
        controller.setState(stateFactory.createLeaderboardState(controller));
        return true;
    }

    @Override
    public boolean commandP() {
        controller.setState(stateFactory.createPlayingGameState(controller));
        return true;
    }

    public View getView() {
        return mainMenuView;
    }
}
