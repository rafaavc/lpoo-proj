package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.*;
import com.g19.breakout.view.GameView;


public class Transformer {
    public Command toCommand(GameController controller, GameView.Keys key){
        switch (key){
            case ARROWLEFT:
                return new CommandLeft(controller);
            case ARROWRIGHT:
                return new CommandRight(controller);
            case EOF:
                return new CommandExit(controller);
            case PKEY:
                return new CommandP(controller);
            case QKEY:
                return new CommandQ(controller);
            case LKEY:
                return new CommandL(controller);
            case ENTER:
                return new CommandEnter(controller);
            case NONE:
            default:
                return new CommandNone();
        }
    }
}
