package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.elements.Position;

public class CommandNone implements Command {

    @Override
    public boolean execute(ArenaController controller) {
        return true;
    }
}
