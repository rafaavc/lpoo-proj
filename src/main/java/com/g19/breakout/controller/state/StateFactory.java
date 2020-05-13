package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.factory.BasicArenaModelFactory;
import com.g19.breakout.view.ArenaView;
import com.g19.breakout.view.PauseView;
import com.g19.breakout.view.factory.BasicViewFactory;

public class StateFactory {
    public PlayingGameState createPlayingGameState(GameController gameController) {
        ArenaModel arena = new BasicArenaModelFactory().createArenaModel(gameController.getModel().getDimensions());
        ArenaView arenaView = new BasicViewFactory().createArenaView(arena, gameController.getView().getGraphics());
        return new PlayingGameState(arena, arenaView, gameController, this);
    }

    public PauseGameState createPauseGameState(PlayingGameState playingGameState, GameController controller) {
        return new PauseGameState(playingGameState, new PauseView(controller.getView().getGraphics()), controller, this);
    }
}
