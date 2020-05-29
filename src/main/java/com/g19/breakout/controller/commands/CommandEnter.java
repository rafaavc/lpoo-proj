package com.g19.breakout.controller.commands;


import com.g19.breakout.controller.GameController;

public class CommandEnter extends Command {
    public CommandEnter(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return controller.getState().commandENTER();
    }
}
