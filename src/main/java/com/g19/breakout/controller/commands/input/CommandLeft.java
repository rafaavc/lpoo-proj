package com.g19.breakout.controller.commands.input;

import com.g19.breakout.controller.GameController;

public class CommandLeft extends GameCommand {
    public CommandLeft(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        controller.getState().commandLeft();
    }
}
