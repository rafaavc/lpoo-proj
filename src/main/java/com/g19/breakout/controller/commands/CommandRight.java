package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public class CommandRight extends Command {
    public CommandRight(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return controller.getState().commandRight();
    }
}
