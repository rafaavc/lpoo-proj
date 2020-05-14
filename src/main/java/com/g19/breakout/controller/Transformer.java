package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.*;
import com.g19.breakout.view.GameView;


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
            case ENTER:
                return new CommandENTER();
            case NONE:
            default:
                return new CommandNone();
        }
    }
}
