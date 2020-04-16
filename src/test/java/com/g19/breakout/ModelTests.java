package com.g19.breakout;

import com.g19.breakout.elements.Position;
import com.g19.breakout.elements.Tile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModelTests {
    @Test
    public void testTile() {
        Tile t = new Tile(new Position(10, 10), 1);
        assertTrue(t.hit());

        Tile t1 = new Tile(new Position(5, 5), 10);
        t1.hit();
        assertEquals(9, t1.getLife());
        assertEquals(new Position(5, 5), t1.getPosition());
    }
}
