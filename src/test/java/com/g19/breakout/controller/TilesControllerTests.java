package com.g19.breakout.controller;

import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

public class TilesControllerTests {
    TilesController tilesController;
    List<TileModel> tiles;

    @Mock
    Chronometer chrono;

    @Mock
    PlayerModel playerModel;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        tiles = new ArrayList<>();
        tiles.add(new TileModel(new Position(10, 10), new Dimensions(5, 2), 10, 0));
        tiles.add(new TileModel(new Position(20, 10), new Dimensions(5, 2), 5, 1));
        tiles.add(new TileModel(new Position(30, 10), new Dimensions(5, 2), 0, 2));
        tilesController = new TilesController(tiles, chrono);
        Mockito.when(chrono.end()).thenReturn((long)900);
    }

    @Test
    public void updateTest() {
        tilesController.update();
        assertEquals(tiles.size(), 2);
    }

    @Test
    public void tileWasHitTest() {
        tilesController.tileWasHit(tiles.get(0), playerModel);
        Mockito.verify(playerModel, times(1)).addPoints(12);
        assertEquals(tiles.get(0).getLife(), 9);
    }
}
