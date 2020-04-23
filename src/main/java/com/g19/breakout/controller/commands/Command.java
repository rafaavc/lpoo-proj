package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.elements.Position;

public interface Command {
    boolean execute(ArenaController controller, Position playerBarPosition);
}
