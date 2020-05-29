package com.g19.breakout.controller.commands.input;

import com.g19.breakout.controller.GameController;

public class CommandRight extends GameCommand {
    public CommandRight(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        controller.getState().commandRight();
    }
}
