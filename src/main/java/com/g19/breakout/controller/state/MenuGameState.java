package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.model.PlayerModel;

public abstract class MenuGameState extends GameState {
    protected final PlayerModel playerModel;
    private final MenuController menu;

    public MenuGameState(GameController controller, PlayerModel playerModel, MenuController menu) {
        super(controller);
        this.playerModel = playerModel;
        this.menu = menu;
    }

    @Override
    public boolean commandLeft() {
        controller.moveElement(playerModel.getPosition().left(), playerModel);
        return true;
    }

    @Override
    public boolean commandRight() {
        controller.moveElement(playerModel.getPosition().right(), playerModel);
        return true;
    }

    @Override
    public boolean commandENTER() {
        return menu.getCommand(playerModel.getPosition()).execute();
    }
}
