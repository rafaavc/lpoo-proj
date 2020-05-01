package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArenaModelTests {
    ArenaModel arena;
    Dimensions dimensions = new Dimensions(100, 120);

    @Before
    public void setup() {
        arena = new ArenaModel(dimensions);
    }

    @Test
    public void testWidthHeight() {
        assertEquals(arena.getHeight(), this.dimensions.getDiscreteY());
        assertEquals(arena.getWidth(), this.dimensions.getDiscreteX());
    }

    @Test
    public void testPlayerBar() {
        assertEquals(arena.getPlayerBar().getPosition(), new Position(this.dimensions.getDiscreteX()/2., this.dimensions.getDiscreteY()-4));
    }

    @Test
    public void testBall() {
        assertEquals(arena.getBall().getPosition(), new Position(this.dimensions.getDiscreteX()/2., this.dimensions.getDiscreteY()-5));
    }

    @Test
    public void testIsInsideArena() {
        assertFalse(arena.isInsideArena(new Position(this.dimensions.getDiscreteX(), 10), arena.getBall().getDimensions()));
        assertTrue(arena.isInsideArena(new Position(this.dimensions.getDiscreteX()-2, 10), arena.getBall().getDimensions()));
        assertTrue(arena.isInsideArena(new Position(this.dimensions.getDiscreteX()-4, 10), arena.getPlayerBar().getDimensions()));
        assertFalse(arena.isInsideArena(new Position(this.dimensions.getDiscreteX()-2, 10), arena.getPlayerBar().getDimensions()));
    }

    @Test
    public void testCheckCollisions(){
        Position nextPosition = new Position(this.dimensions.getDiscreteX() / 2., this.dimensions.getDiscreteY() - 4);
        Dimensions dimensions = new Dimensions(2, 1);

        ArenaModel arenaSpy = Mockito.spy(arena);

        List<BallModel.HIT> ballModelHits = arena.checkCollisions(nextPosition, dimensions);

        assertEquals(BallModel.HIT.PLAYERBAR, ballModelHits.get(0));

        nextPosition = new Position(this.dimensions.getDiscreteX() / 2., -1);
        ballModelHits = arenaSpy.checkCollisions(nextPosition, dimensions);

        assertEquals(BallModel.HIT.TOP, ballModelHits.get(0));
        Mockito.verify(arenaSpy).checkHitPlayerBar(nextPosition);
        Mockito.verify(arenaSpy).checkHitTile(nextPosition);

        nextPosition = new Position(this.dimensions.getDiscreteX() / 2., this.dimensions.getDiscreteY());
        ballModelHits = arenaSpy.checkCollisions(nextPosition, dimensions);

        assertEquals(BallModel.HIT.BOTTOM, ballModelHits.get(0));
        Mockito.verify(arenaSpy).checkHitPlayerBar(nextPosition);
        Mockito.verify(arenaSpy).checkHitTile(nextPosition);



        nextPosition = new Position(this.dimensions.getDiscreteX(), 1);
        ballModelHits = arenaSpy.checkCollisions(nextPosition, dimensions);

        assertEquals(BallModel.HIT.SIDE, ballModelHits.get(0));
        Mockito.verify(arenaSpy).checkHitPlayerBar(nextPosition);
        Mockito.verify(arenaSpy).checkHitTile(nextPosition);


        nextPosition = new Position(this.dimensions.getDiscreteX(), this.dimensions.getDiscreteY());
        ballModelHits = arenaSpy.checkCollisions(nextPosition, dimensions);

        assertEquals(BallModel.HIT.BOTTOM, ballModelHits.get(0));
        assertEquals(BallModel.HIT.SIDE, ballModelHits.get(1));
        Mockito.verify(arenaSpy).checkHitPlayerBar(nextPosition);
        Mockito.verify(arenaSpy).checkHitTile(nextPosition);


        nextPosition = new Position(this.dimensions.getDiscreteX() / 2., 11);
        ballModelHits = arenaSpy.checkCollisions(nextPosition, dimensions);

        assertEquals(BallModel.HIT.TOP, ballModelHits.get(0));
        Mockito.verify(arenaSpy).checkHitPlayerBar(nextPosition);
        Mockito.verify(arenaSpy).checkHitTile(nextPosition);
    }

    @Test
    public void testCheckHitTile(){
        Position position = new Position(this.dimensions.getDiscreteX() / 2., 11);
        List<TileModel> tiles = new ArrayList<>();
        TileModel expectedTile = new TileModel(new Position(this.dimensions.getDiscreteX()/2., 8), new Dimensions(10, 4), 5);
        tiles.add(expectedTile);
        tiles.add(new TileModel(new Position(this.dimensions.getDiscreteX()/2. + 20, 8), new Dimensions(10, 4), 5));
        arena.setTiles(tiles);

        TileModel actualTile = arena.checkHitTile(position);

        assertEquals(expectedTile.getLife(), actualTile.getLife());
        assertEquals(expectedTile.getDimensions(), actualTile.getDimensions());
        assertEquals(expectedTile.getPosition(), actualTile.getPosition());
    }

    @Test
    public void testCheckHitTopOrSide(){
        TileModel tile = Mockito.mock(TileModel.class);
        Mockito.when(tile.getDimensions()).thenReturn(new Dimensions(1, 1));
        Mockito.when(tile.getPosition()).thenReturn(new Position(10, 10));

        Position position = new Position(9, 10);
        arena.getBall().setPosition(position);
        assertEquals(BallModel.HIT.SIDE, arena.checkHitTopOrSideTile(tile));

        position = new Position(10, 11);
        arena.getBall().setPosition(position);
        assertEquals(BallModel.HIT.TOP, arena.checkHitTopOrSideTile(tile));
    }

    @Test
    public void testCheckHitPlayerBar(){
        Position nextPosition = new Position(this.dimensions.getDiscreteX() / 2., this.dimensions.getDiscreteY() - 4);

        assertTrue(arena.checkHitPlayerBar(nextPosition));

        nextPosition = new Position(1 ,1);
        assertFalse(arena.checkHitPlayerBar(nextPosition));
    }
}
