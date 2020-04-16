package com.g19.breakout;

import com.g19.breakout.elements.Position;
import com.g19.breakout.elements.Tile;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ModelTests {
    @Test
    public void test() {
        Tile t = new Tile(new Position(10, 10), 1);
        assertTrue(t.hit());
    }
}
