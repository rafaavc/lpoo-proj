package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.factory.BasicArenaModelFactory;
import com.g19.breakout.view.ArenaView;
import com.g19.breakout.view.MainMenuView;
import com.g19.breakout.view.MenuView;
import com.g19.breakout.view.PauseView;
import com.g19.breakout.view.factory.BasicViewFactory;

public class StateFactory {
    public MainMenuGameState createMainMenuGameState(GameController gameController) {
        MainMenuView view = new BasicViewFactory().createMainMenuView(gameController.getView().getGraphics());
        return new MainMenuGameState(gameController, view, this);
    }

    public PlayingGameState createPlayingGameState(GameController gameController) {
        ArenaModel arena = new BasicArenaModelFactory().createArenaModel(gameController.getModel().getDimensions());
        ArenaView arenaView = new BasicViewFactory().createArenaView(arena, gameController.getView().getGraphics());
        return new PlayingGameState(arena, arenaView, gameController, this);
    }

    public PauseGameState createPauseGameState(PlayingGameState playingGameState, GameController controller) {
        Dimensions gameDimensions = controller.getModel().getDimensions();

        Position playerPosition = new Position(playingGameState.getArena().getPlayer().getPosition().getDiscreteX(), gameDimensions.getDiscreteY() - 4);
        PlayerModel playerModel = new BasicArenaModelFactory().createPlayerModel(playerPosition);

        PauseView pauseView = new BasicViewFactory().createPauseView(controller.getView().getGraphics(), gameDimensions, playerModel);

        MenuView menuView = new MenuView(
                new Dimensions(gameDimensions.getDiscreteX(), gameDimensions.getDiscreteY() - gameDimensions.getDiscreteY()/2.),
                new Position(0, gameDimensions.getDiscreteY()/2.)
        );
        MenuController menu = new MenuController(gameDimensions, menuView);

        return new PauseGameState(playingGameState, pauseView, controller, menu, this);
    }
}
