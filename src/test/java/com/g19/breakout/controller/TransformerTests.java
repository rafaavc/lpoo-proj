package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.*;
import com.g19.breakout.view.GameView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformerTests {

    @Test
    public void testToCommand(){
        Transformer transformer = new Transformer();
        GameController gameController = Mockito.mock(GameController.class);

        Command command = transformer.toCommand(gameController, GameView.Keys.EOF);
        assertEquals(CommandExit.class, command.getClass());
        command = transformer.toCommand(gameController, GameView.Keys.ARROWRIGHT);
        assertEquals(CommandRight.class, command.getClass());
        command = transformer.toCommand(gameController, GameView.Keys.ARROWLEFT);
        assertEquals(CommandLeft.class, command.getClass());
        command = transformer.toCommand(gameController, GameView.Keys.NONE);
        assertEquals(CommandNone.class, command.getClass());
    }

}
