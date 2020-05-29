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
        this.readingText = true;
        this.textReader = new StringBuilder();
        playerModel.setName("_");
    }

    @Override
    public void update(int elapsedTime) {
        if (readingText && textReader.length() != playerModel.getName().length()-1) {
            playerModel.setName(textReader.toString() + "_");
        }
    }

    @Override
    public boolean commandENTER() {
        if (!readingText) return super.commandENTER();

        readingText = false;
        playerModel.setName("");

        if (textReader.length() == 0) return true;

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

    @Override
    public View getView() {
        return view;
    }
}
