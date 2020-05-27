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

    public GameController(GameView view, GameModel model, Chronometer chrono, StateFactory stateFactory, ViewFactory viewFactory, ModelFactory modelFactory, int FPS) throws IOException {
        this.chrono = chrono;
        this.view = view;
        this.model = model;
        this.viewFactory = viewFactory;
        this.modelFactory = modelFactory;
        this.FPS = FPS;
        setState(stateFactory.createMainMenuGameState(this));
        setLeaderboard(new FileManager());
    }

    public void setLeaderboard(FileManager fm) throws IOException {
        model.setLeaderboard(fm.getLeaderboard());
    }

    public void start(Transformer transformer, FileManager fileManager) throws IOException, InterruptedException {
        int frameDuration = 1000 / FPS;
        int counter = 1;
        do {
            chrono.start();

            view.draw();
            if (counter % 20 == 0) model.getBackgroundModel().generateParticles();
            state.update(frameDuration);

            waitForNextFrame(frameDuration);
            counter++;
        }
        while ( getNextCommand(transformer) );

        view.exit();
        fileManager.writeLeaderboard(model.getLeaderboard());
    }

    public void waitForNextFrame(int frameDuration) throws InterruptedException {
        long sleepAmount = frameDuration - chrono.end();
        if (sleepAmount < 0) sleepAmount = 0;

        Thread.sleep(sleepAmount);
    }

    public void moveElement(Position position, ElementModel element) {
        if (model.isInsideGame(position, element.getDimensions())) {
            element.setPosition(position);
        }
    }

    public boolean getNextCommand(Transformer transformer) throws IOException {
        GameView.Keys key;
        if (state.isReadingText()) {
            key = view.readTextInput(state.getTextReader());
        } else {
            key = view.readInput();
        }
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
