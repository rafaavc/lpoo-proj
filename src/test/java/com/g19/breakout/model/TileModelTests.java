package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TileModelTests {

    @Test
    public void testHit(){
        TileModel tile = new TileModel(new Position(10, 10), new Dimensions(1, 1), 2);

        tile.hit();
        assertEquals(1, tile.getLife());
        tile.hit();
        assertEquals(0, tile.getLife());
    }
}
