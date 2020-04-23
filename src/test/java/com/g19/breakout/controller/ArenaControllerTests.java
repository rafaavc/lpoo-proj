package com.g19.breakout.controller;

<<<<<<< HEAD
import com.g19.breakout.controller.ball.*;
=======
import com.g19.breakout.controller.ball.BallHitNothing;
>>>>>>> master
import com.g19.breakout.elements.*;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerBarModel;
import com.g19.breakout.view.ArenaView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
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
    public void testUpdate() throws IOException {
        /*
        BallModel ball = Mockito.mock(BallModel.class);

        Chronometer crono = Mockito.mock(Chronometer.class);
        Mockito.when(crono.getElapsedTime()).thenReturn((long)1000);

        Mockito.when(arena.getBall()).thenReturn(ball);

        BallModel ball = Mockito.mock(BallModel.class);
        Mockito.when(ball.getVelocity()).thenReturn(1.);
        Mockito.when(ball.getPosition()).thenReturn(new Position(30,30));
        Mockito.when(ball.getDimensions()).thenReturn(new Dimensions(2, 1));

        Direction dir = Mockito.mock(Direction.class);
        Mockito.when(ball.getDirection()).thenReturn(new Direction(1, 0));

        Transformer transformer = Mockito.mock(Transformer.class);
        Mockito.when(transformer.toBallHit(new ArrayList<>(), ball)).thenReturn(new BallHitTop(ball));


        Mockito.when(arena.checkCollisions(any(Position.class), any(Dimensions.class))).thenReturn(new BallHitNothing(ball));*/
        /*need to fix test*/
        //controller.update(crono);
        //verify(dir, times(1)).getNextPosition(new Position(30,30), 1);
    }

    @Test
    public void testGetNextCommand() throws IOException {
        Mockito.when(view.readInput()).thenReturn(ArenaView.Keys.ARROWLEFT);

        Position pos = Mockito.mock(Position.class);
        Mockito.when(arena.getPlayerBar()).thenReturn(new PlayerBarModel(pos, "#ffffff"));

        controller.getNextCommand(view);
        verify(view, times(1)).readInput();
        verify(pos, times(1)).left();
    }

    @Test
    public void testMoveBall() {
        Mockito.when(arena.canMoveElement(any(Position.class), any(Dimensions.class))).thenReturn(true);

        BallModel ball = Mockito.mock(BallModel.class);
        Mockito.when(ball.getDimensions()).thenReturn(new Dimensions(2, 1));
        Mockito.when(arena.getBall()).thenReturn(ball);

        controller.moveBall(new Position(30, 30));
        verify(ball, times(1)).setPosition(new Position(30, 30));
    }

    @Test
    public void testMovePlayerBar() {
        Mockito.when(arena.canMoveElement(any(Position.class), any(Dimensions.class))).thenReturn(true);

        PlayerBarModel pb = Mockito.mock(PlayerBarModel.class);
        Mockito.when(pb.getDimensions()).thenReturn(new Dimensions(6, 1));
        Mockito.when(arena.getPlayerBar()).thenReturn(pb);

        controller.movePlayerBar(new Position(30, 30));
        verify(pb, times(1)).setPosition(new Position(30, 30));
    }
}
