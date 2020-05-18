package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.factory.BasicModelFactory;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ModelFactoryTests {
    BasicModelFactory basicModelFactory = new BasicModelFactory();
    @Test
    public void createPlayerModelTest(){
        Dimensions dimensions = new Dimensions(10, 10);
        PlayerModel playerModel = basicModelFactory.createPlayerModel(dimensions);
        assertEquals(new Position(5, 6),playerModel.getPosition());
        assertEquals(new Dimensions(10, 1), playerModel.getDimensions());

        playerModel = basicModelFactory.createPlayerModel(new Position(8, 9));
        assertEquals(new Position(8, 9),playerModel.getPosition());
        assertEquals(new Dimensions(10, 1), playerModel.getDimensions());
    }

    @Test
    public void createBallModelTest(){
        Dimensions dimensions = new Dimensions(10, 10);
        BallModel ballModel = basicModelFactory.createBallModel(dimensions);
        assertEquals(new Position(5, 5), ballModel.getPosition());
        assertEquals(new Dimensions(2, 1), ballModel.getDimensions());
    }

    @Test
    public void createArenaModelTest(){
        Dimensions dimensions = new Dimensions(100, 100);
        BasicModelFactory basicModelFactorySpy = Mockito.spy(basicModelFactory);
        ArenaModel arenaModel = basicModelFactorySpy.createArenaModel(dimensions);

        assertEquals(new Dimensions(100, 94), arenaModel.getDimensions());
    }
}
