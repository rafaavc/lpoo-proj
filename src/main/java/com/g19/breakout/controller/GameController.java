package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.Command;
import com.g19.breakout.controller.commands.input.GameCommand;
import com.g19.breakout.controller.state.State;
import com.g19.breakout.controller.state.StateFactory;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.model.GameModel;
import com.g19.breakout.view.GameView;

import java.io.IOException;

public class GameController {
    private final int FPS;
    private final GameView view;
    private final GameModel model;
    private final Chronometer chrono;
    private State state;
    protected boolean gameIsRunning;

    public GameController(GameView view, GameModel model, Chronometer chrono, StateFactory stateFactory, int FPS) throws IOException {
        this.chrono = chrono;
        this.view = view;
        this.model = model;
        this.FPS = FPS;
        this.gameIsRunning = true;
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
            update(frameDuration, counter);

            getNextCommand(transformer);

            waitForNextFrame(frameDuration);
            counter++;
        }
        while ( gameIsRunning );

        view.exit();
        fileManager.writeLeaderboard(model.getLeaderboard());
    }

    public void update(int frameDuration, int counter) {
        if (counter % 20 == 0) model.getBackgroundModel().generateParticles();
        state.update(frameDuration);
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

    public void getNextCommand(Transformer transformer) throws IOException {
        GameView.Keys key;
        if (state.isReadingText()) {
            key = view.readTextInput(state.getTextReader().getStringBuilder());
        } else {
            key = view.readInput();
        }
        GameCommand cmd = transformer.toCommand(this, key);
        cmd.execute();
    }

    public void exit() {
        gameIsRunning = false;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        view.setView(state.getView());
    }

    public GameModel getModel() {
        return model;
    }

    public GameView getView() {
        return view;
    }
}
