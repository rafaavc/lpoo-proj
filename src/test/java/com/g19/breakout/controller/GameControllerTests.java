package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.input.CommandQ;
import com.g19.breakout.controller.state.MainMenuGameState;
import com.g19.breakout.controller.state.StateFactory;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

public class GameControllerTests {
    GameView view = Mockito.mock(GameView.class);
    View v = Mockito.mock(View.class);
    GameModel model = Mockito.mock(GameModel.class);
    StateFactory stateFactory = Mockito.mock(StateFactory.class);
    ViewFactory viewFactory = Mockito.mock(ViewFactory.class);
    ModelFactory modelFactory = Mockito.mock(ModelFactory.class);
    GameController gameController;

    @BeforeEach
    public void setup() throws IOException{
        Mockito.doNothing().when(view).setView(any(View.class));
        MainMenuGameState mainMenuGameState = Mockito.mock(MainMenuGameState.class);
        Mockito.when(stateFactory.createMainMenuGameState(any(GameController.class))).thenReturn(mainMenuGameState);
        Mockito.when(mainMenuGameState.getView()).thenReturn(v);
        gameController = new GameController(view, model ,new Chronometer(), stateFactory, viewFactory, modelFactory, 30);
    }
    /*
    @Test
    public void getNextCommandTest() throws IOException {
        Mockito.when(view.readInput()).thenReturn(GameView.Keys.QKEY);

        CommandQ commandQ = Mockito.mock(CommandQ.class);
        Mockito.when(commandQ.execute()).thenReturn(true);

        Transformer transformer = Mockito.mock(Transformer.class);
        Mockito.when(transformer.toCommand(gameController, GameView.Keys.QKEY)).thenReturn(commandQ);


        assertTrue(gameController.getNextCommand(transformer));
    }*/

    @Test
    public void moveElementTest(){
        Position position = new Position(10, 10);
        BallModel ball = new BallModel(position, 1);
        Mockito.when(model.isInsideGame(position.right(), ball.getDimensions())).thenReturn(true);

        gameController.moveElement(position.right(), ball);

        assertEquals(position.right(), ball.getPosition());
    }
}
