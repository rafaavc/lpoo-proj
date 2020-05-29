package com.g19.breakout.model;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TileModelTests {

    @Test
    public void hitTest(){
        TileModel tile = new TileModel(new Position(10, 10), new Dimensions(1, 1), 2, 1);

        tile.hit();
        assertEquals(1, tile.getLife());
        tile.hit();
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
