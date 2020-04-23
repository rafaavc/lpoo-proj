package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.elements.Position;

public class CommandLeft implements Command {

    @Override
    public boolean execute(ArenaController controller, Position playerBarPosition) {
        controller.movePlayerBar(playerBarPosition.left());
        return true;
    }
}
