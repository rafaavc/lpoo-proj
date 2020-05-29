package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public class CommandP extends Command {
    public CommandP(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return controller.getState().commandP();
    }
}
