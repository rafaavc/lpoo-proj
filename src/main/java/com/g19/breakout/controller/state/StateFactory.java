package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.controller.commands.CommandL;
import com.g19.breakout.controller.commands.CommandP;
import com.g19.breakout.controller.commands.CommandQ;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.*;
import com.g19.breakout.view.factory.ViewFactory;

public class StateFactory {
    public MainMenuGameState createMainMenuGameState(GameController controller) {
        Dimensions gameDimensions = controller.getModel().getDimensions();
        ViewFactory viewFactory = controller.getViewFactory();
        PlayerModel playerModel = controller.getModelFactory().createPlayerModel(
                new Position(gameDimensions.getDiscreteX()/2., gameDimensions.getDiscreteY() - 4));

        MenuView menuView = viewFactory.createMenuView(
                new Dimensions(gameDimensions.getDiscreteX(), gameDimensions.getDiscreteY() - gameDimensions.getDiscreteY()/2.),
                new Position(0, gameDimensions.getDiscreteY()/2.)
        );
        MenuController menu = new MenuController(gameDimensions, menuView);

        menu.addButton(new CommandP(), viewFactory.createMenuButtonView("Start Game (P)", "#1da50b", controller.getView().getGraphics()));
        menu.addButton(new CommandL(), viewFactory.createMenuButtonView("Leaderboard (L)", "#e0b20b", controller.getView().getGraphics()));
        menu.addButton(new CommandQ(), viewFactory.createMenuButtonView("Quit Game (Q)", "#a30d0d", controller.getView().getGraphics()));

        MainMenuView view = viewFactory.createMainMenuView(controller.getView().getGraphics(), controller.getModel().getDimensions());
        view.addView(menuView);
        view.addView(viewFactory.createPlayerView(playerModel, controller.getView().getGraphics()));

        return new MainMenuGameState(controller, view, menu, playerModel, this);
    }

    public PlayingGameState createPlayingGameState(GameController gameController) {
        ArenaModel arena = gameController.getModelFactory().createArenaModel(gameController.getModel().getDimensions());
        ArenaView arenaView = gameController.getViewFactory().createArenaView(arena, gameController.getModel().getDimensions(), gameController.getView().getGraphics());
        return new PlayingGameState(arena, arenaView, gameController, this);
    }

    public PauseGameState createPauseGameState(GameController controller) {
        Dimensions gameDimensions = controller.getModel().getDimensions();

        PlayingGameState playingGameState = (PlayingGameState) controller.getState();
        ViewFactory viewFactory = controller.getViewFactory();

        Position playerPosition = new Position(playingGameState.getArena().getPlayer().getPosition().getDiscreteX(), gameDimensions.getDiscreteY() - 4);
        PlayerModel playerModel = controller.getModelFactory().createPlayerModel(playerPosition);

        PauseView pauseView = viewFactory.createPauseView(controller.getView().getGraphics(), gameDimensions);

        MenuView menuView = viewFactory.createMenuView(
                new Dimensions(gameDimensions.getDiscreteX(), gameDimensions.getDiscreteY() - gameDimensions.getDiscreteY()/2.),
                new Position(0, gameDimensions.getDiscreteY()/2.)
        );
        MenuController menu = new MenuController(gameDimensions, menuView);

        menu.addButton(new CommandP(), viewFactory.createMenuButtonView("Resume Game (P)", "#1da50b", controller.getView().getGraphics()));
        menu.addButton(new CommandQ(), viewFactory.createMenuButtonView("Give Up (Q)", "#a30d0d", controller.getView().getGraphics()));

        pauseView.addView(menu.getView());
        pauseView.addView(viewFactory.createPlayerView(playerModel, controller.getView().getGraphics()));

        return new PauseGameState(playingGameState, playerModel, pauseView, controller, menu, this);
    }
}
