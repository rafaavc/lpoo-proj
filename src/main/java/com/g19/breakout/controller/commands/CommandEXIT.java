package com.g19.breakout.controller.commands;


import com.g19.breakout.controller.GameController;

public class CommandEXIT extends Command {
    public CommandEXIT(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
