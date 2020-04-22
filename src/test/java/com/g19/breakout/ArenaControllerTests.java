package com.g19.breakout;

import com.g19.breakout.elements.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ArenaControllerTests {
    ArenaController controller;
    ArenaView view;
    ArenaModel arena;

    @Before
    public void setup() {
        view = Mockito.mock(ArenaView.class);
        arena = Mockito.mock(ArenaModel.class);
        controller = new ArenaController(arena, view);
    }

    @Test
    public void testStart() throws IOException {
        /* Don't think this needs testing
        In doubt whether should make the controller as argument */
        /*ArenaController controller1 = Mockito.mock(ArenaController.class);
        controller.start(controller1);

        verify(view, times(1)).draw(view, arena);
        verify(controller1, times(1)).update(anyObject());
        verify(controller1, times(1)).getNextCommand(view);*/
    }

    @Test
    public void testUpdate() {
        Chronometer crono = Mockito.mock(Chronometer.class);
        Mockito.when(crono.getElapsedTime()).thenReturn((long)1000);

        Ball ball = Mockito.mock(Ball.class);
        Mockito.when(arena.getBall()).thenReturn(ball);

        Mockito.when(ball.getVelocity()).thenReturn(1.);
        Mockito.when(ball.getPosition()).thenReturn(new Position(30,30));

        Direction dir = Mockito.mock(Direction.class);
        Mockito.when(ball.getDirection()).thenReturn(dir);

        controller.update(crono);
        verify(dir, times(1)).getNextPosition(new Position(30,30), 1);
    }

    @Test
    public void testGetNextCommand() throws IOException {
        Mockito.when(view.readInput()).thenReturn(ArenaController.COMMAND.LEFT);

        Position pos = Mockito.mock(Position.class);
        Mockito.when(arena.getPlayerBar()).thenReturn(new PlayerBar(pos));

        controller.getNextCommand(view);
        verify(view, times(1)).readInput();
        verify(pos, times(1)).left();
    }

    @Test
    public void testMoveBall() {
        Mockito.when(arena.canMoveBall(anyObject())).thenReturn(true);

        Ball ball = Mockito.mock(Ball.class);
        Mockito.when(arena.getBall()).thenReturn(ball);

        controller.moveBall(new Position(30, 30));
        verify(ball, times(1)).setPosition(new Position(30, 30));
    }

    @Test
    public void testMovePlayerBar() {
        Mockito.when(arena.canMovePlayerBar(anyObject())).thenReturn(true);

        PlayerBar pb = Mockito.mock(PlayerBar.class);
        Mockito.when(arena.getPlayerBar()).thenReturn(pb);

        controller.movePlayerBar(new Position(30, 30));
        verify(pb, times(1)).setPosition(new Position(30, 30));
    }
}
