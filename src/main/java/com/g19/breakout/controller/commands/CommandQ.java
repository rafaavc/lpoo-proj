package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public class CommandQ extends Command {
    public CommandQ(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return controller.getState().commandQ();
    }
}
