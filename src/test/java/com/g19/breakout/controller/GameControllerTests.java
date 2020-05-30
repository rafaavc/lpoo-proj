package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.input.CommandQ;
import com.g19.breakout.controller.state.MainMenuGameState;
import com.g19.breakout.controller.state.StateFactory;
import com.g19.breakout.model.BackgroundModel;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.GameModel;
import com.g19.breakout.model.factory.ModelFactory;
import com.g19.breakout.view.GameView;
import com.g19.breakout.view.View;
import com.g19.breakout.view.factory.ViewFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class GameControllerTests {
    GameView view = Mockito.mock(GameView.class);
    View v = Mockito.mock(View.class);
    GameModel model = Mockito.mock(GameModel.class);
    StateFactory stateFactory = Mockito.mock(StateFactory.class);
    ViewFactory viewFactory = Mockito.mock(ViewFactory.class);
    ModelFactory modelFactory = Mockito.mock(ModelFactory.class);
    MainMenuGameState mainMenuGameState = Mockito.mock(MainMenuGameState.class);
    int FPS = 30;
    GameController gameController;

    @BeforeEach
    public void setup() throws IOException{
        Mockito.doNothing().when(view).setView(any(View.class));
        Mockito.when(stateFactory.createMainMenuGameState(any(GameController.class))).thenReturn(mainMenuGameState);
        Mockito.when(mainMenuGameState.getView()).thenReturn(v);
        gameController = new GameController(view, model ,new Chronometer(), stateFactory, FPS);
    }

    @Test
    public void getNextCommandTest() throws IOException {
        Mockito.when(view.readInput()).thenReturn(GameView.Keys.QKEY);

        CommandQ commandQ = new CommandQ(gameController);

        Transformer transformer = Mockito.mock(Transformer.class);
        Mockito.when(transformer.toCommand(gameController, GameView.Keys.QKEY)).thenReturn(commandQ);

        gameController.getNextCommand(transformer);
        Mockito.verify(view, Mockito.times(1)).readInput();
        Mockito.verify(transformer, Mockito.times(1)).toCommand(gameController, GameView.Keys.QKEY);
        Mockito.verify(mainMenuGameState, Mockito.times(1)).commandQ();
    }

    @Test
    public void moveElementTest(){
        Position position = new Position(10, 10);
        BallModel ball = new BallModel(position, 1);
        Mockito.when(model.isInsideGame(position.right(), ball.getDimensions())).thenReturn(true);

        gameController.moveElement(position.right(), ball);

        assertEquals(position.right(), ball.getPosition());
    }

    @Test
    public void frameTimeTest() throws IOException, InterruptedException {
        Mockito.doNothing().when(view).draw();
        Mockito.doNothing().when(mainMenuGameState).update(any(Integer.class));
        GameController gameControllerSpy = Mockito.spy(gameController);
        Mockito.doNothing().when(gameControllerSpy).getNextCommand(any(Transformer.class));
        Mockito.doNothing().when(view).exit();
        FileManager fileManager = Mockito.mock(FileManager.class);
        Mockito.doNothing().when(fileManager).writeLeaderboard(any(PriorityQueue.class));

        BackgroundModel bgModel = Mockito.mock(BackgroundModel.class);
        Mockito.doNothing().when(bgModel).generateParticles();
        Mockito.when(model.getBackgroundModel()).thenReturn(bgModel);

        gameControllerSpy.gameIsRunning = false;
        long initial_time = System.currentTimeMillis();
        gameControllerSpy.start(new Transformer(), fileManager);
        long elapsed_time = System.currentTimeMillis() - initial_time;
        long expected_time = 1000/FPS;
        assertTrue(elapsed_time >= expected_time);
        assertTrue(elapsed_time <= expected_time + 5);
    }
}
