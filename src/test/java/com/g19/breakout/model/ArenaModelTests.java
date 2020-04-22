package com.g19.breakout.model;

import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import org.junit.Before;
import org.junit.Test;

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
        assertEquals(arena.getPlayerBar().getPosition(), new Position(width/2., height-8));
    }

    @Test
    public void testBall() {
        assertEquals(arena.getBall().getPosition(), new Position(width/2., height-9));
    }

    @Test
    public void testCanMoveElement() {
        assertFalse(arena.canMoveElement(new Position(width, 10), arena.getBall().getDimensions()));
        assertTrue(arena.canMoveElement(new Position(width-2, 10), arena.getBall().getDimensions()));
        assertTrue(arena.canMoveElement(new Position(width-4, 10), arena.getPlayerBar().getDimensions()));
        assertFalse(arena.canMoveElement(new Position(width-2, 10), arena.getPlayerBar().getDimensions()));
    }
}
