package com.g19.breakout.controller;

import com.g19.breakout.controller.ball.BallHitHorizontal;
import com.g19.breakout.controller.ball.BallHitVertical;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CollisionCheckerTests {
    Dimensions dimensions = new Dimensions(100, 120);
    ArenaModel arena;
    BallModel ball;
    CollisionChecker collisionChecker;

    @Before
    public void setup() {
        arena = Mockito.mock(ArenaModel.class);
        collisionChecker = new CollisionChecker(arena);
        ball = Mockito.mock(BallModel.class);
        Mockito.when(arena.getBall()).thenReturn(ball);
        Mockito.when(arena.getWidth()).thenReturn(100);
        Mockito.when(arena.getHeight()).thenReturn(120);
        Mockito.when(ball.getDimensions()).thenReturn(new Dimensions(2, 1));
    }

    @Test
    public void checkHitTileTest(){

        Position position = new Position(this.dimensions.getDiscreteX() / 2., 11);
        List<TileModel> tiles = new ArrayList<>();
        TileModel expectedTile = new TileModel(new Position(this.dimensions.getDiscreteX()/2., 8), new Dimensions(10, 4), 5);
        tiles.add(expectedTile);
        tiles.add(new TileModel(new Position(this.dimensions.getDiscreteX()/2. + 20, 8), new Dimensions(10, 4), 5));
        Mockito.when(arena.getTiles()).thenReturn(tiles);

        TileModel actualTile = collisionChecker.checkHitTile(position);


        assertEquals(expectedTile.getLife(), actualTile.getLife());
        assertEquals(expectedTile.getDimensions(), actualTile.getDimensions());
        assertEquals(expectedTile.getPosition(), actualTile.getPosition());
    }

    @Test
    public void checkHitTopOrSideTest(){

        TileModel tile = Mockito.mock(TileModel.class);
        Mockito.when(tile.getDimensions()).thenReturn(new Dimensions(1, 1));
        Mockito.when(tile.getPosition()).thenReturn(new Position(10, 10));

        Position position = new Position(9, 10);
        Mockito.when(ball.getPosition()).thenReturn(position);
        assertEquals(BallHitVertical.class, collisionChecker.checkHitTopOrSideTile(tile).getClass());

        position = new Position(10, 11);
        Mockito.when(ball.getPosition()).thenReturn(position);
        assertEquals(BallHitHorizontal.class, collisionChecker.checkHitTopOrSideTile(tile).getClass());
    }

    @Test
    public void checkHitPlayerBarTest(){

        Position nextPosition = new Position(60, 40);

        PlayerModel player = Mockito.mock(PlayerModel.class);
        Mockito.when(arena.getPlayer()).thenReturn(player);

        Position position = new Position(60, 40);
        Mockito.when(player.getPosition()).thenReturn(position);

        Dimensions dimensions = new Dimensions(10, 1);
        Mockito.when(player.getDimensions()).thenReturn(dimensions);

        assertTrue(collisionChecker.checkHitPlayer(nextPosition));

        nextPosition = new Position(1 ,1);
        assertFalse(collisionChecker.checkHitPlayer(nextPosition));
    }

    @Test
    public void isInsideArenaTest(){
        Position position = new Position(10, 15);
        Dimensions dimensions = new Dimensions(1, 2);
        assertTrue(collisionChecker.isInsideArena(position, dimensions));

        position = new Position(100, 15);
        dimensions = new Dimensions(2, 1);
        assertFalse(collisionChecker.isInsideArena(position, dimensions));

        position = new Position(15, 130);
        dimensions = new Dimensions(1, 10);
        assertFalse(collisionChecker.isInsideArena(position, dimensions));
    }
}
