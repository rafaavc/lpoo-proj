package com.g19.breakout.controller.commands;


import com.g19.breakout.controller.GameController;

public class CommandENTER extends Command {
    public CommandENTER(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return controller.getState().commandENTER();
    }
}
