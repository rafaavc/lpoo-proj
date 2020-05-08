package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.Command;
import com.g19.breakout.controller.state.GameState;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.view.ArenaView;
import com.g19.breakout.view.GameView;

import java.io.IOException;

public class GameController {
    GameState state;
    GameView view;

    public GameController(GameView view) {
        this.view = view;
    }

    public void start(Transformer transformer, Chronometer chrono) throws IOException {
        do {
            view.draw();
            state.update(chrono);
        }
        while ( getNextCommand(transformer, view) );
    }

    public boolean getNextCommand(Transformer transformer, GameView view) throws IOException {
        GameView.Keys key = view.readInput();
        Command cmd = transformer.toCommand(key);
        return cmd.execute(this);
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
        view.setView(state.getView());
    }
}
