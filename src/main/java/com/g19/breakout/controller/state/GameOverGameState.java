package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.GameOverView;
import com.sun.tools.javac.util.Pair;

public class GameOverGameState extends MenuGameState {
    private final GameOverView view;
    private final StateFactory stateFactory;

    public GameOverGameState(PlayerModel playerModel, GameOverView view, GameController controller, MenuController menu, StateFactory stateFactory) {
        super(controller, playerModel, menu);
        this.view = view;
        this.stateFactory = stateFactory;
        this.readingText = true;
        this.textReader = new StringBuilder();
    }

    @Override
    public void update(int elapsedTime) {
        if (textReader.length() != playerModel.getName().length()) {
            playerModel.setName(textReader.toString());
        }
    }

    @Override
    public boolean commandENTER() {
        if (!readingText) return super.commandENTER();

        if (textReader.length() < 4) return true;

        readingText = false;
        playerModel.setName(textReader.toString());
        controller.getModel().addScore(new Pair<>(playerModel.getName(), playerModel.getPoints()));

        return true;
    }

    @Override
    public boolean commandP() {
        controller.setState(stateFactory.createPlayingGameState(controller));
        return true;
    }

    @Override
    public boolean commandQ() {
        controller.setState(stateFactory.createMainMenuGameState(controller));
        return true;
    }

    public GameOverView getView() {
        return view;
    }
}
