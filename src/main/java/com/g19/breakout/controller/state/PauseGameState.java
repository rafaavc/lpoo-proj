package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.view.PauseView;
import com.g19.breakout.view.factory.BasicViewFactory;

public class PauseGameState implements GameState {
    ArenaModel arena;
    PauseView view;
    GameController controller;
    PauseGameState(ArenaModel arena, PauseView view, GameController controller) {
        this.arena = arena;
        this.controller = controller;
        this.view = view;
    }

    public void update(Chronometer chrono) {

    }
    public void commandL() {

    }
    public void commandR() {

    }
    public void commandP() {
        controller.setState(new PlayingGameState(arena, new BasicViewFactory().createArenaView(arena, view.getGraphics()), controller));
    }

    @Override
    public PauseView getView() {
        return view;
    }
}
