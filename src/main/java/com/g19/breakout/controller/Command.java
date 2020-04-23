package com.g19.breakout.controller;

import com.g19.breakout.elements.Position;

public interface Command {
    boolean execute(ArenaController controller, Position playerBarPosition);
}
