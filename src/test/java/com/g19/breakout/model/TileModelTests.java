package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class TileModelTests {

    @Test
    public void hitTest(){
        TileModel tile = new TileModel(new Position(10, 10), new Dimensions(1, 1), 2);

        assertFalse(tile.hit());
        assertEquals(1, tile.getLife());
        assertTrue(tile.hit());
        assertEquals(0, tile.getLife());
    }

    @Test
    public void createTileArrayTest(){
        ArenaModel arena = Mockito.mock(ArenaModel.class);
        Mockito.when(arena.getWidth()).thenReturn(50);

        List<TileModel> tiles = TileModel.createTileArray(5, 5, arena);
        assertEquals(25, tiles.size());
        assertEquals(new Position(5, 1), tiles.get(0).getPosition());
    }
}
