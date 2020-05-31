package com.g19.breakout.controller.commands.input;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.state.PlayingGameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameCommandTests {
    GameController gameController = Mockito.mock(GameController.class);
    PlayingGameState state = Mockito.mock(PlayingGameState.class);


    @BeforeEach
    public void setup(){
        Mockito.when(gameController.getState()).thenReturn(state);
    }

    @Test
    public void CommandEnterTest(){
        Mockito.doNothing().when(state).commandEnter();
        CommandEnter commandEnter = new CommandEnter(gameController);

        commandEnter.execute();
        Mockito.verify(state, Mockito.times(1)).commandEnter();
    }

    @Test
    public void CommandLeft(){
        Mockito.doNothing().when(state).commandLeft();
        CommandLeft commandLeft = new CommandLeft(gameController);

        commandLeft.execute();
        Mockito.verify(state, Mockito.times(1)).commandLeft();
    }

    @Test
    public void CommandL(){
        Mockito.doNothing().when(state).commandL();
        CommandL commandL = new CommandL(gameController);

        commandL.execute();
        Mockito.verify(state, Mockito.times(1)).commandL();
    }

    @Test
    public void CommandP(){
        Mockito.doNothing().when(state).commandP();
        CommandP commandP = new CommandP(gameController);

        commandP.execute();
        Mockito.verify(state, Mockito.times(1)).commandP();
    }

    @Test
    public void CommandQ(){
        Mockito.doNothing().when(state).commandQ();
        CommandQ commandQ = new CommandQ(gameController);

        commandQ.execute();
        Mockito.verify(state, Mockito.times(1)).commandQ();
    }

    @Test
    public void CommandRight(){
        Mockito.doNothing().when(state).commandRight();
        CommandRight commandRight = new CommandRight(gameController);

        commandRight.execute();
        Mockito.verify(state, Mockito.times(1)).commandRight();
    }
}
