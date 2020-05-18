package com.g19.breakout.controller;

import com.g19.breakout.controller.state.MainMenuGameState;
import com.g19.breakout.controller.state.StateFactory;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ElementModel;
import com.g19.breakout.model.GameModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.MainMenuView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
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

        assertTrue(mainMenuGameState.commandLeft());
        Mockito.verify(controller, Mockito.times(1)).moveElement(any(Position.class), any(ElementModel.class));
        assertTrue(mainMenuGameState.commandRight());
        Mockito.verify(controller, Mockito.times(1)).moveElement(any(Position.class), any(ElementModel.class));
    }
}
