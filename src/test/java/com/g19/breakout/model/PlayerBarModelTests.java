package com.g19.breakout.model;

import com.g19.breakout.elements.Position;
import com.g19.breakout.model.PlayerBarModel;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class PlayerBarModelTests {

    @Test
    public void playerBarConstructor(){
        PlayerBarModel playerBar = new PlayerBarModel(new Position(10, 5), "#ffffff");

        assertEquals(10, playerBar.getPosition().getDiscreteX());
        assertEquals(5, playerBar.getPosition().getDiscreteY());
    }

    @Test
    public void playerBarMovementRight(){
        PlayerBarModel playerBar = new PlayerBarModel(new Position(10, 10), "#ffffff");

        Position positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.right()).thenReturn(new Position(11, 10));

        playerBar.moveRight();
        Position position = playerBar.getPosition();
        assertEquals(11, position.getDiscreteX());
        assertEquals(10, position.getDiscreteY());

    }

    @Test
    public void playerBarMovementLeft(){
        PlayerBarModel playerBar = new PlayerBarModel(new Position(10, 10), "#ffffff");

        Position positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.right()).thenReturn(new Position(9, 10));

        playerBar.moveLeft();
        Position position = playerBar.getPosition();
        assertEquals(9, position.getDiscreteX());
        assertEquals(10, position.getDiscreteY());
    }
}
