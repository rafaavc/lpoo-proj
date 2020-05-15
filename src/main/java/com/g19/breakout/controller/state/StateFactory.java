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
import com.g19.breakout.model.factory.BasicArenaModelFactory;
import com.g19.breakout.view.*;
import com.g19.breakout.view.factory.BasicViewFactory;

public class StateFactory {
    // TODO change functions in this class to receive the factory classes in the arguments
    public MainMenuGameState createMainMenuGameState(GameController controller) {
        Dimensions gameDimensions = controller.getModel().getDimensions();

        BasicViewFactory viewFactory = new BasicViewFactory();

        MenuView menuView = viewFactory.createMenuView(
                new Dimensions(gameDimensions.getDiscreteX(), gameDimensions.getDiscreteY() - gameDimensions.getDiscreteY()/2.),
                new Position(0, gameDimensions.getDiscreteY()/2.)
        );
        MenuController menu = new MenuController(gameDimensions, menuView);

        menu.addButton(new CommandP(), viewFactory.createMenuButtonView("Start Game (P)", "#1da50b", controller.getView().getGraphics()));
        menu.addButton(new CommandL(), viewFactory.createMenuButtonView("Leaderboard (L)", "#e0b20b", controller.getView().getGraphics()));
        menu.addButton(new CommandQ(), viewFactory.createMenuButtonView("Quit Game (Q)", "#a30d0d", controller.getView().getGraphics()));

        MainMenuView view = new BasicViewFactory().createMainMenuView(controller.getView().getGraphics(), controller.getModel().getDimensions());
        view.addView(menuView);

        return new MainMenuGameState(controller, view, this);
    }

    public PlayingGameState createPlayingGameState(GameController gameController) {
        ArenaModel arena = new BasicArenaModelFactory().createArenaModel(gameController.getModel().getDimensions());
        ArenaView arenaView = new BasicViewFactory().createArenaView(arena, gameController.getModel().getDimensions(), gameController.getView().getGraphics());
        return new PlayingGameState(arena, arenaView, gameController, this);
    }

    public PauseGameState createPauseGameState(PlayingGameState playingGameState, GameController controller) {
        Dimensions gameDimensions = controller.getModel().getDimensions();

        Position playerPosition = new Position(playingGameState.getArena().getPlayer().getPosition().getDiscreteX(), gameDimensions.getDiscreteY() - 4);
        PlayerModel playerModel = new BasicArenaModelFactory().createPlayerModel(playerPosition);

        BasicViewFactory viewFactory = new BasicViewFactory();
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
