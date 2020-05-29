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
    public void commandQ() {
        controller.exit();
    }

    @Override
    public void commandL() {
        controller.setState(stateFactory.createLeaderboardState(controller));
    }

    @Override
    public void commandP() {
        controller.setState(stateFactory.createPlayingGameState(controller));
    }

    public View getView() {
        return mainMenuView;
    }
}
