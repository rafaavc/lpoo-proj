package com.g19.breakout.controller;

import com.g19.breakout.elements.Position;

public class CommandNone implements Command {

    @Override
    public boolean execute(ArenaController controller, Position playerBarPosition) {
        return true;
    }
}
