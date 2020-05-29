package com.g19.breakout.controller.commands.input;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.commands.Command;

public abstract class GameCommand implements Command {
    GameController controller;

    public GameCommand(GameController controller) {
        this.controller = controller;
    }
}
