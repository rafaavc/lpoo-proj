package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public class CommandRight implements Command{

    @Override
    public boolean execute(GameController controller) {
        controller.getState().commandR();
        return true;
    }
}
