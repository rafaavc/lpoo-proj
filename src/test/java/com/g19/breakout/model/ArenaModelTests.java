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
}
