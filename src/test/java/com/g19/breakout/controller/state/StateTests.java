package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.controller.TextReader;
import com.g19.breakout.model.GameModel;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.GameOverView;
import com.g19.breakout.view.LeaderboardView;
import com.g19.breakout.view.MainMenuView;
import com.g19.breakout.view.PauseView;
import com.sun.tools.javac.util.Pair;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class StateTests {

    @Test
    public void MainMenuGameStateTest(){
        GameController controller = Mockito.mock(GameController.class);
        MainMenuView mainMenuView = Mockito.mock(MainMenuView.class);
        MenuController menu = Mockito.mock(MenuController.class);
        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        StateFactory stateFactory = Mockito.mock(StateFactory.class);
        MainMenuGameState mainMenuGameState = new MainMenuGameState(controller, mainMenuView, menu, playerModel, stateFactory);

        Mockito.when(playerModel.getPosition()).thenReturn(new Position(10, 10));

        Mockito.doNothing().when(controller).moveElement(any(Position.class), any(ElementModel.class));

        mainMenuGameState.commandLeft();
        mainMenuGameState.commandRight();
        Mockito.verify(controller, Mockito.times(2)).moveElement(any(Position.class), any(ElementModel.class));

        mainMenuGameState.commandQ();

        PlayingGameState playingGameState = Mockito.mock(PlayingGameState.class);

        Mockito.when(stateFactory.createPlayingGameState(any(GameController.class))).thenReturn(playingGameState);
        Mockito.doNothing().when(controller).setState(any(GameState.class));
        mainMenuGameState.commandP();
        Mockito.verify(controller, Mockito.times(1)).setState(any(GameState.class));
    }

    @Test
    public void PauseGameStateTest(){
        PlayingGameState playingGameState = Mockito.mock(PlayingGameState.class);
        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        PauseView view = Mockito.mock(PauseView.class);
        GameController controller = Mockito.mock(GameController.class);
        MenuController menu = Mockito.mock(MenuController.class);
        StateFactory stateFactory = Mockito.mock(StateFactory.class);
        PauseGameState pauseGameState = new PauseGameState(playingGameState, playerModel, view, controller, menu, stateFactory);


        MainMenuGameState mainMenuGameState = Mockito.mock(MainMenuGameState.class);

        Mockito.when(stateFactory.createMainMenuGameState(any(GameController.class))).thenReturn(mainMenuGameState);

        Mockito.doNothing().when(controller).setState(any(GameState.class));

        pauseGameState.commandP();
        pauseGameState.commandQ();
        Mockito.verify(controller, Mockito.times(2)).setState(any(GameState.class));
    }

    @Test
    public void LeaderboardGameStateTest(){
        GameController gameController = Mockito.mock(GameController.class);
        LeaderboardView leaderboardView = Mockito.mock(LeaderboardView.class);
        MenuController menuController = Mockito.mock(MenuController.class);
        PlayerModel playerModel = new PlayerModel(new Position(10, 10));
        StateFactory stateFactory = Mockito.mock(StateFactory.class);
        LeaderboardGameState leaderboardGameState = new LeaderboardGameState(gameController, leaderboardView, menuController, playerModel, stateFactory);

        Mockito.when(stateFactory.createMainMenuGameState(gameController)).thenReturn(Mockito.mock(MainMenuGameState.class));
        Mockito.doNothing().when(gameController).setState(any(GameState.class));

        leaderboardGameState.commandQ();
        Mockito.verify(gameController, Mockito.times(1)).setState(any(MainMenuGameState.class));
    }

    @Test
    public  void GameOverGameStateTest(){
        GameController gameController = Mockito.mock(GameController.class);
        GameOverView gameOverView = Mockito.mock(GameOverView.class);
        MenuController menuController = Mockito.mock(MenuController.class);
        PlayerModel playerModel = new PlayerModel(new Position(10, 10));
        StateFactory stateFactory = Mockito.mock(StateFactory.class);
        Mockito.when(stateFactory.createMainMenuGameState(gameController)).thenReturn(Mockito.mock(MainMenuGameState.class));
        Mockito.doNothing().when(gameController).setState(any(GameState.class));

        GameOverGameState gameOverGameState = new GameOverGameState(playerModel, gameOverView, gameController, menuController, stateFactory, new TextReader());


        Mockito.when(stateFactory.createPlayingGameState(gameController)).thenReturn(Mockito.mock(PlayingGameState.class));
        Mockito.when(stateFactory.createMainMenuGameState(gameController)).thenReturn(Mockito.mock(MainMenuGameState.class));
        Mockito.doNothing().when(gameController).setState(any(GameState.class));

        gameOverGameState.commandQ();
        Mockito.verify(gameController, Mockito.times(1)).setState(any(MainMenuGameState.class));

        gameOverGameState.commandP();
        Mockito.verify(gameController, Mockito.times(1)).setState(any(PlayingGameState.class));

    }

    @Property
    public void writingNameTest(@ForAll String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        GameController gameController = Mockito.mock(GameController.class);
        GameOverView gameOverView = Mockito.mock(GameOverView.class);
        MenuController menuController = Mockito.mock(MenuController.class);
        PlayerModel playerModel = new PlayerModel(new Position(10, 10));
        StateFactory stateFactory = Mockito.mock(StateFactory.class);
        TextReader textReader = Mockito.mock(TextReader.class);
        GameModel gameModel = Mockito.mock(GameModel.class);

        Mockito.when(stateFactory.createMainMenuGameState(gameController)).thenReturn(Mockito.mock(MainMenuGameState.class));
        Mockito.doNothing().when(gameController).setState(any(GameState.class));
        Mockito.doNothing().when(textReader).startReadingText(20);
        Mockito.when(textReader.isReadingText()).thenReturn(true);
        Mockito.when(textReader.getStringBuilder()).thenReturn(stringBuilder);
        Mockito.when(gameController.getModel()).thenReturn(gameModel);
        Mockito.doNothing().when(gameModel).addScore(any(Pair.class));
        Mockito.when(textReader.stopReadingText()).thenReturn(string);

        GameOverGameState gameOverGameState = new GameOverGameState(playerModel, gameOverView, gameController, menuController, stateFactory, textReader);

        gameOverGameState.startReadingPlayerName();
        assertEquals("_", playerModel.getName());

        gameOverGameState.update(10);
        String expected = string + "_";
        assertEquals(expected, playerModel.getName());

        gameOverGameState.commandEnter();
        assertEquals(string, playerModel.getName());
    }
}
