package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.Command;
import com.g19.breakout.controller.state.GameState;
import com.g19.breakout.controller.state.StateFactory;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.model.GameModel;
import com.g19.breakout.model.factory.ModelFactory;
import com.g19.breakout.view.GameView;
import com.g19.breakout.view.factory.ViewFactory;

import java.io.IOException;

public class GameController {
    private final int FPS;
    private final GameView view;
    private final GameModel model;
    private final Chronometer chrono;
    private final ViewFactory viewFactory;
    private final ModelFactory modelFactory;
    private GameState state;

    public GameController(GameView view, GameModel model, Chronometer chrono, StateFactory stateFactory, ViewFactory viewFactory, ModelFactory modelFactory, int FPS) {
        this.chrono = chrono;
        this.view = view;
        this.model = model;
        this.viewFactory = viewFactory;
        this.modelFactory = modelFactory;
        this.FPS = FPS;
        setState(stateFactory.createMainMenuGameState(this));
    }

    public void start(Transformer transformer) throws IOException, InterruptedException {
        int frameDuration = 1000 / FPS;
        do {
            chrono.start();

            view.draw();
            state.update(frameDuration);

            long sleepAmount = 1000 / FPS - chrono.end();
            if (sleepAmount < 0) sleepAmount = 0;

            Thread.sleep(sleepAmount);
        }
        while ( getNextCommand(transformer) );
    }

    public void moveElement(Position position, ElementModel element) {
        if (model.isInsideGame(position, element.getDimensions())) {
            element.setPosition(position);
        }
    }

    public boolean getNextCommand(Transformer transformer) throws IOException {
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

    public GameModel getModel() {
        return model;
    }

    public GameView getView() {
        return view;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public ModelFactory getModelFactory() {
        return modelFactory;
    }
}
