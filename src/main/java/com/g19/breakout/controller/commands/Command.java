package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.GameController;

public interface Command {
    boolean execute(GameController controller);
}
