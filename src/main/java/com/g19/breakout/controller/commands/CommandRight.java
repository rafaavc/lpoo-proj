package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.model.PlayerModel;

public class CommandRight implements Command{

    @Override
    public boolean execute(ArenaController controller) {
        PlayerModel playerBar = controller.getArena().getPlayerBar();
        controller.moveElement(playerBar.getPosition().right(), playerBar);
        return true;
    }
}
