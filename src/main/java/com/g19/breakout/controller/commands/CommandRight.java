package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.PlayerBarModel;

public class CommandRight implements Command{

    @Override
    public boolean execute(ArenaController controller) {
        PlayerBarModel playerBar = controller.getArena().getPlayerBar();
        controller.moveElement(playerBar.getPosition().right(), playerBar);
        return true;
    }
}
