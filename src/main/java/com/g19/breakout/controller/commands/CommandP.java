package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public class CommandP implements Command {
    public boolean execute(GameController controller) {
        return controller.getState().commandP();
    }
}
