package com.g19.breakout.controller;

import com.g19.breakout.controller.ball.BallHitNothing;
import com.g19.breakout.elements.*;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerBarModel;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.ArenaView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ArenaControllerTests {
    ArenaView view;
    ArenaModel arena;

    @Before
    public void setup() {
        view = Mockito.mock(ArenaView.class);
        arena = Mockito.mock(ArenaModel.class);
    }

    @Test
    public void testStart() throws IOException {
        ArenaController controller = new ArenaController(arena, view);
        ArenaController controller1 = Mockito.spy(controller);
        Mockito.doReturn(false).when(controller1).getNextCommand(any(Transformer.class), any(ArenaView.class));
        Mockito.doNothing().when(controller1).update(any(Chronometer.class));

        controller1.start(new Transformer(), new Chronometer());

        verify(controller1, times(1)).update(any(Chronometer.class));
        verify(view, times(1)).draw();
    }

    @Test
    public void testUpdate() {
        ArenaController controller = new ArenaController(arena, view);
        Chronometer chrono = Mockito.mock(Chronometer.class);
        ArenaController controller1 = Mockito.spy(controller);

        Mockito.doReturn((long) 10).when(chrono).getElapsedTime();
        Mockito.doNothing().when(controller1).updateBall(anyInt());
        Mockito.doNothing().when(controller1).updateTiles();

        controller1.update(chrono);

        verify(chrono, times(1)).getElapsedTime();
        verify(controller1, times(1)).updateBall(10);
        verify(controller1, times(1)).updateTiles();
    }

    @Test
    public void testUpdateTiles() {
        List<TileModel> tiles = new ArrayList<>();

        tiles.add(new TileModel(new Position(10, 10), new Dimensions(1, 1), 0));
        tiles.add(new TileModel(new Position(10, 10), new Dimensions(1, 1), 1));
        tiles.add(new TileModel(new Position(10, 10), new Dimensions(1, 1), 0));
        tiles.add(new TileModel(new Position(10, 10), new Dimensions(1, 1), 2));

        Mockito.when(arena.getTiles()).thenReturn(tiles);

        ArenaController controller = new ArenaController(arena, view);
        controller.updateTiles();
        assertEquals(tiles.size(), 2);
    }

    @Test
    public void testUpdateBall() {
        Mockito.doReturn(new BallModel(new Position(10, 10), 20)).when(arena).getBall();
        ArenaController controller = new ArenaController(arena, view);

        ArenaController controller1 = Mockito.spy(controller);
        Position pos = new Position(10, 20);
        Mockito.doReturn(pos).when(controller1).updateBallPosition(anyDouble());
        Mockito.doNothing().when(controller1).moveBall(any(Position.class));

        controller1.updateBall(1000); // 1second elapsed time

        verify(controller1, times(1)).updateBallPosition(eq(20.));
        verify(controller1, times(1)).moveBall(pos);
    }

    @Test
    public void testUpdateBallPosition() {
        BallModel ball = Mockito.mock(BallModel.class);
        Direction dir = Mockito.mock(Direction.class);

        Mockito.when(ball.getDirection()).thenReturn(dir);
        Position nextPosition = new Position(20, 30);
        Mockito.doReturn(nextPosition).when(dir).getNextPosition(any(), anyDouble());

        Mockito.when(arena.getBall()).thenReturn(ball);

        ArenaController controller = new ArenaController(arena, view);
        ArenaController controller1 = Mockito.spy(controller);

        Mockito.doReturn(false).when(controller1).updateBallDirection(any(Transformer.class), any(BallModel.class), any(Position.class));

        Position res = controller1.updateBallPosition(20);
        assertEquals(res, nextPosition);
        verify(controller1, times(1)).updateBallDirection(any(Transformer.class), any(BallModel.class), any(Position.class));
    }

    @Test
    public void testUpdateBallDirection() {
        List<BallModel.HIT> hits = new ArrayList<>();
        hits.add(BallModel.HIT.NOTHING);

        arena = mock(ArenaModel.class);

        Mockito.doReturn(hits).when(arena).checkBallCollisions(any(), any());

        ArenaController controller = new ArenaController(arena, view);

        Transformer transformer = Mockito.mock(Transformer.class);
        BallHitNothing ballHit = Mockito.mock(BallHitNothing.class);

        Mockito.doNothing().when(ballHit).updateDirection();
        Mockito.doReturn(ballHit).when(transformer).toBallHit(any(), any(), any());

        BallModel ball = Mockito.mock(BallModel.class);
        Mockito.doReturn(new Direction(1, 1)).when(ball).getDirection();

        assertFalse(controller.updateBallDirection(transformer, ball, new Position(10, 10)));
    }

    @Test
    public void testGetNextCommand() throws IOException {
        ArenaController controller = new ArenaController(arena, view);

        Mockito.when(view.readInput()).thenReturn(ArenaView.Keys.ARROWLEFT);

        Position pos = Mockito.mock(Position.class);
        Mockito.when(arena.getPlayerBar()).thenReturn(new PlayerBarModel(pos));

        controller.getNextCommand(new Transformer(), view);
        verify(view, times(1)).readInput();
        verify(pos, times(1)).left();
    }

    @Test
    public void testMoveBall() {
        ArenaController controller = new ArenaController(arena, view);

        Mockito.when(arena.isInsideArena(any(Position.class), any(Dimensions.class))).thenReturn(true);

        BallModel ball = Mockito.mock(BallModel.class);
        Mockito.when(ball.getDimensions()).thenReturn(new Dimensions(2, 1));
        Mockito.when(arena.getBall()).thenReturn(ball);

        controller.moveBall(new Position(30, 30));
        verify(ball, times(1)).setPosition(new Position(30, 30));
    }

    @Test
    public void testMovePlayerBar() {
        ArenaController controller = new ArenaController(arena, view);

        Mockito.when(arena.isInsideArena(any(Position.class), any(Dimensions.class))).thenReturn(true);

        PlayerBarModel pb = Mockito.mock(PlayerBarModel.class);
        Mockito.when(pb.getDimensions()).thenReturn(new Dimensions(6, 1));
        Mockito.when(arena.getPlayerBar()).thenReturn(pb);

        controller.movePlayerBar(new Position(30, 30));
        verify(pb, times(1)).setPosition(new Position(30, 30));
    }
}
