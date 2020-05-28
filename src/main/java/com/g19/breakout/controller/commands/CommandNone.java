package com.g19.breakout.controller.commands;

public class CommandNone extends Command {

    public CommandNone() {
        super(null);
    }

    @Override
    public boolean execute() {
        return true;
    }
}
