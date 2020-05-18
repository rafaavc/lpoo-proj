package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameModelTests {

    @Test
    public void isInsideGameTest(){
        GameModel gameModel = new GameModel(new Dimensions(100, 50));
        assertEquals(new Dimensions(100, 50), gameModel.getDimensions());
        assertFalse(gameModel.isInsideGame(new Position(100, 30), new Dimensions(2, 1)));
        assertTrue(gameModel.isInsideGame(new Position(10, 10), new Dimensions(10, 10)));
    }
}
