package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.factory.BasicModelFactory;
import com.g19.breakout.view.MainMenuView;
import com.g19.breakout.view.View;
import com.g19.breakout.view.factory.BasicViewFactory;

public class MainMenuGameState implements GameState {
    private final MainMenuView mainMenuView;
    private final GameController controller;
    private final StateFactory stateFactory;
    private final PlayerModel playerModel;
    private final MenuController menu;

    public MainMenuGameState(GameController controller, MainMenuView mainMenuView, MenuController menu, PlayerModel playerModel, StateFactory stateFactory) {
        this.mainMenuView = mainMenuView;
        this.controller = controller;
        this.stateFactory = stateFactory;
        this.playerModel = playerModel;
        this.menu = menu;
    }

    public boolean commandL() {
        controller.moveElement(playerModel.getPosition().left(), playerModel);
        return true;
    }

    public boolean commandR() {
        controller.moveElement(playerModel.getPosition().right(), playerModel);
        return true;
    }

    public boolean commandQ() {
        return false;
    }

    public boolean commandP() {
        controller.setState(stateFactory.createPlayingGameState(controller));
        return true;
    }

    public boolean commandENTER() {
        return menu.getCommand(playerModel.getPosition()).execute(controller);
    }

    public View getView() {
        return mainMenuView;
    }
}
