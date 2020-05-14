package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.*;
import com.g19.breakout.view.GameView;

import java.util.List;

public class Transformer {

    public Command toCommand(GameView.Keys key){
        switch (key){
            case ARROWLEFT:
                return new CommandLeft();
            case ARROWRIGHT:
                return new CommandRight();
            case EOF:
                return new CommandEXIT();
            case PKEY:
                return new CommandP();
            case QKEY:
                return new CommandQ();
            case NONE:
            default:
                return new CommandNone();
        }
    }
}
