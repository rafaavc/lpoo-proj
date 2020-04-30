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

        List<BallModel.HIT> ballModelHits = arena.checkCollisions(nextPosition, dimensions);

        assertEquals(BallModel.HIT.PLAYERBAR, ballModelHits.get(0));

        nextPosition = new Position(this.dimensions.getDiscreteX() / 2., -1);
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.TOP, ballModelHits.get(0));

        nextPosition = new Position(this.dimensions.getDiscreteX() / 2., this.dimensions.getDiscreteY());
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.BOTTOM, ballModelHits.get(0));

        nextPosition = new Position(this.dimensions.getDiscreteX(), 1);
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.SIDE, ballModelHits.get(0));

        nextPosition = new Position(this.dimensions.getDiscreteX(), this.dimensions.getDiscreteY());
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.BOTTOM, ballModelHits.get(0));
        assertEquals(BallModel.HIT.SIDE, ballModelHits.get(1));

        nextPosition = new Position(this.dimensions.getDiscreteX() / 2., 11);
        ballModelHits = arena.checkCollisions(nextPosition, dimensions);
        assertEquals(BallModel.HIT.TOP, ballModelHits.get(0));
    }
}
