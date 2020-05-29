package com.g19.breakout.controller.commands;


import com.g19.breakout.controller.GameController;

public class CommandExit extends Command {
    public CommandExit(GameController controller) {
        super(controller);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
