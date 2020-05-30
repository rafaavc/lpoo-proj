package com.g19.breakout.model;

import com.g19.breakout.model.factory.BasicModelFactory;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class GameModelTests {

    @Property
    public void isInsideGameTest(@ForAll int x, @ForAll int y, @ForAll @IntRange(min = 1) int dx, @ForAll @IntRange(min = 1) int dy){
        GameModel gameModel = new BasicModelFactory().createGameModel(new Dimensions(100, 50));
        assertEquals(new Dimensions(100, 50), gameModel.getDimensions());

        Dimensions newDimensions = new Dimensions(dx, dy);
        Position position = new Position(x, y);
        assert(x >= newDimensions.getDiscreteX()/2 || !gameModel.isInsideGame(position, newDimensions));
        assert(y >= 0 || !gameModel.isInsideGame(position, newDimensions));
        assert(x <= gameModel.getDimensions().getDiscreteX() - newDimensions.getDiscreteX()/2 || !gameModel.isInsideGame(position, newDimensions));
        assert(y <= gameModel.getDimensions().getDiscreteY() - newDimensions.getDiscreteY() || !gameModel.isInsideGame(position, newDimensions));
    }
}
