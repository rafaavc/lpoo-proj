package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public class CommandL extends Command {
    public CommandL(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return controller.getState().commandL();
    }
}
