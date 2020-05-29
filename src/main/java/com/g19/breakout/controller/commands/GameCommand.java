package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public abstract class GameCommand implements Command {
    GameController controller;

    public GameCommand(GameController controller) {
        this.controller = controller;
    }
}
