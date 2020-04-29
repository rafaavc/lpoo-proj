package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.elements.Position;

public class CommandLeft implements Command {

    @Override
    public boolean execute(ArenaController controller) {
        controller.movePlayerBar(controller.getArena().getPlayerBar().getPosition().left());
        return true;
    }
}
