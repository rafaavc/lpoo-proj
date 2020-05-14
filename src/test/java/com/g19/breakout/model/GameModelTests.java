package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameModelTests {

    @Test
    public void isInsideGameTest(){
        GameModel gameModel = new GameModel(new Dimensions(100, 50));
        assertFalse(gameModel.isInsideGame(new Position(100, 30), new Dimensions(2, 1)));
        assertTrue(gameModel.isInsideGame(new Position(10, 10), new Dimensions(10, 10)));
    }
}
