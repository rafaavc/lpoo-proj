package com.g19.breakout.controller.commands.input;

import com.g19.breakout.controller.GameController;

public class CommandQ extends GameCommand {
    public CommandQ(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        controller.getState().commandQ();
    }
}
