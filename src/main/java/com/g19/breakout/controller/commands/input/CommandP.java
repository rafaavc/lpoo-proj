package com.g19.breakout.controller.commands.input;

import com.g19.breakout.controller.GameController;

public class CommandP extends GameCommand {
    public CommandP(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return controller.getState().commandP();
    }
}
