package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class ArenaModelTests {
    ArenaModel arena;
    int height = 100, width = 120;

    @Before
    public void setup() {
        arena = new ArenaModel(width, height);
    }

    @Test
    public void testWidthHeight() {
        assertEquals(arena.getHeight(), height);
        assertEquals(arena.getWidth(), width);
    }

    @Test
    public void testPlayerBar() {
        assertEquals(arena.getPlayerBar().getPosition(), new Position(width/2., height-4));
    }

    @Test
    public void testBall() {
        assertEquals(arena.getBall().getPosition(), new Position(width/2., height-5));
    }

    @Test
    public void testIsInsideArena() {
        assertFalse(arena.isInsideArena(new Position(width, 10), arena.getBall().getDimensions()));
        assertTrue(arena.isInsideArena(new Position(width-2, 10), arena.getBall().getDimensions()));
        assertTrue(arena.isInsideArena(new Position(width-4, 10), arena.getPlayerBar().getDimensions()));
        assertFalse(arena.isInsideArena(new Position(width-2, 10), arena.getPlayerBar().getDimensions()));
    }

    @Test
    public void testCheckCollisions(){
        Position nextPosition = new Position(width / 2., height - 4);
        Dimensions dimensions = new Dimensions(2, 1);

        List<BallModel.HIT> ballModelHits = arena.checkCollisions(nextPosition, dimensions);

        assertEquals(BallModel.HIT.PLAYERBAR, ballModelHits.get(0));

        nextPosition = new Position(width / 2., -1);
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.TOP, ballModelHits.get(0));

        nextPosition = new Position(width / 2., height);
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.BOTTOM, ballModelHits.get(0));

        nextPosition = new Position(width, 1);
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.SIDE, ballModelHits.get(0));

        nextPosition = new Position(width, height);
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.BOTTOM, ballModelHits.get(0));
        assertEquals(BallModel.HIT.SIDE, ballModelHits.get(1));

        nextPosition = new Position(width / 2., 11);
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.TOP, ballModelHits.get(0));
    }
}
