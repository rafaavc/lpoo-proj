package com.g19.breakout.controller.commands;


import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.elements.Position;

public class CommandEXIT implements Command {

    @Override
    public boolean execute(ArenaController controller) {
        return false;
    }
}
