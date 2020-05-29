package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public class CommandLeft extends GameCommand {
    public CommandLeft(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return controller.getState().commandLeft();
    }
}
