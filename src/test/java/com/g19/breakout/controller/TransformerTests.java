package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.*;
import com.g19.breakout.view.GameView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransformerTests {

    @Test
    public void testToCommand(){
        Transformer transformer = new Transformer();

        Command command = transformer.toCommand(GameView.Keys.EOF);
        assertEquals(CommandEXIT.class, command.getClass());
        command = transformer.toCommand(GameView.Keys.ARROWRIGHT);
        assertEquals(CommandRight.class, command.getClass());
        command = transformer.toCommand(GameView.Keys.ARROWLEFT);
        assertEquals(CommandLeft.class, command.getClass());
        command = transformer.toCommand(GameView.Keys.NONE);
        assertEquals(CommandNone.class, command.getClass());
    }

}
