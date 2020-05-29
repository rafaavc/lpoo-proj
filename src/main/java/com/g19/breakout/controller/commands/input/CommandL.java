package com.g19.breakout.controller.commands.input;

import com.g19.breakout.controller.GameController;

public class CommandL extends GameCommand {
    public CommandL(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        controller.getState().commandL();
    }
}
