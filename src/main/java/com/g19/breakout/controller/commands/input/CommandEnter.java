package com.g19.breakout.controller.commands.input;


import com.g19.breakout.controller.GameController;

public class CommandEnter extends GameCommand {
    public CommandEnter(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        controller.getState().commandEnter();
    }
}
