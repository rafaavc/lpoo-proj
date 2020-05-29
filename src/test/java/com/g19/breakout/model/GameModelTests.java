package com.g19.breakout.model;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class GameModelTests {

    @Test
    public void isInsideGameTest(){
        BackgroundModel bgModel = Mockito.mock(BackgroundModel.class);
        GameModel gameModel = new GameModel(new Dimensions(100, 50), bgModel);
        assertEquals(new Dimensions(100, 50), gameModel.getDimensions());
        assertFalse(gameModel.isInsideGame(new Position(100, 30), new Dimensions(2, 1)));
        assertTrue(gameModel.isInsideGame(new Position(10, 10), new Dimensions(10, 10)));
    }
}
