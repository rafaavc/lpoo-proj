package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public abstract class Command {
    GameController controller;

    public Command(GameController controller) {
        this.controller = controller;
    }

    public abstract boolean execute();  // returns false when the program ends
}
