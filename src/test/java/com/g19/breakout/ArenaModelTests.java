package com.g19.breakout;

import com.g19.breakout.elements.PlayerBar;
import com.g19.breakout.elements.Position;
import com.g19.breakout.elements.Tile;
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
    public void testCanMoveBall() {
        assertFalse(arena.canMoveBall(new Position(width, 10)));
        assertTrue(arena.canMoveBall(new Position(width-2, 10)));
    }

    @Test
    public void testCanPlayerBar() {
        assertTrue(arena.canMovePlayerBar(new Position(width-4, 10)));
        assertFalse(arena.canMovePlayerBar(new Position(width-2, 10)));
    }
}
