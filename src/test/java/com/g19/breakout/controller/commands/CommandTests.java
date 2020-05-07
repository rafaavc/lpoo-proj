package com.g19.breakout.controller.commands;

import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.PlayerModel;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CommandTests {
    ArenaController arenaController = Mockito.mock(ArenaController.class);
    @Test
    public void testCommandEXIT(){
        CommandEXIT commandEXIT = new CommandEXIT();
        assertFalse(commandEXIT.execute(arenaController));
    }

    @Test
    public void testCommandLeft(){
        Position position = Mockito.mock(Position.class);
        Mockito.when(position.left()).thenReturn(new Position(1, 1));

        PlayerModel playerBar = new PlayerModel(position);

        ArenaModel arena = Mockito.mock(ArenaModel.class);
        Mockito.when(arena.getPlayerBar()).thenReturn(playerBar);

        Mockito.when(arenaController.getArena()).thenReturn(arena);

        CommandLeft commandLeft = new CommandLeft();

        assertTrue(commandLeft.execute(arenaController));
        Mockito.verify(position, Mockito.times(1)).left();
    }

    @Test
    public void testCommandRight(){
        Position position = Mockito.mock(Position.class);
        Mockito.when(position.right()).thenReturn(new Position(3, 1));

        PlayerModel playerBar = new PlayerModel(position);

        ArenaModel arena = Mockito.mock(ArenaModel.class);
        Mockito.when(arena.getPlayerBar()).thenReturn(playerBar);

        Mockito.when(arenaController.getArena()).thenReturn(arena);

        CommandRight commandRight = new CommandRight();

        assertTrue(commandRight.execute(arenaController));
        Mockito.verify(position, Mockito.times(1)).right();

    }

    @Test
    public void testCommandNone(){
        CommandNone commandNone = new CommandNone();
        assertTrue(commandNone.execute(arenaController));
    }
}
