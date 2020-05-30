package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.GameOverView;
import com.g19.breakout.view.View;
import com.sun.tools.javac.util.Pair;

public class GameOverGameState extends MenuGameState {
    private final GameOverView view;
    private final StateFactory stateFactory;

    public GameOverGameState(PlayerModel playerModel, GameOverView view, GameController controller, MenuController menu, StateFactory stateFactory) {
        super(controller, playerModel, menu);
        this.view = view;
        this.stateFactory = stateFactory;
        startReadingPlayerName();
    }

    @Override
    public void update(int elapsedTime) {
        if (readingText && textReader.length() != playerModel.getName().length()-1) {
            playerModel.setName(textReader.toString() + "_");
        }
    }

    public void startReadingPlayerName() {
        readingText = true;
        textReader = new StringBuilder();
        playerModel.setName("_");
    }

    public void stopReadingPlayerName() {
        readingText = false;
        playerModel.setName(textReader.toString());

        if (playerModel.getName().length() == 0) return;

        controller.getModel().addScore(new Pair<>(playerModel.getName(), playerModel.getPoints()));
    }

    @Override
    public void commandEnter() {
        if (readingText) {
            stopReadingPlayerName();
        } else {
            super.commandEnter();
        }
    }

    @Override
    public void commandP() {
        controller.setState(stateFactory.createPlayingGameState(controller));
    }

    @Override
    public void commandQ() {
        controller.setState(stateFactory.createMainMenuGameState(controller));
    }

    @Override
    public View getView() {
        return view;
    }
}
