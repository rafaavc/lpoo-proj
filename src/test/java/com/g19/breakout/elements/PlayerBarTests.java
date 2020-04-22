package com.g19.breakout.elements;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class PlayerBarTests {

    @Test
    public void playerBarConstructor(){
        PlayerBar playerBar = new PlayerBar(new Position(10, 5), "#ffffff");

        assertEquals(10, playerBar.getPosition().getDiscreteX());
        assertEquals(5, playerBar.getPosition().getDiscreteY());
    }

    @Test
    public void playerBarMovementRight(){
        PlayerBar playerBar = new PlayerBar(new Position(10, 10), "#ffffff");

        Position positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.right()).thenReturn(new Position(11, 10));

        playerBar.moveRight();
        Position position = playerBar.getPosition();
        assertEquals(11, position.getDiscreteX());
        assertEquals(10, position.getDiscreteY());

    }

    @Test
    public void playerBarMovementLeft(){
        PlayerBar playerBar = new PlayerBar(new Position(10, 10), "#ffffff");

        Position positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.right()).thenReturn(new Position(9, 10));

        playerBar.moveLeft();
        Position position = playerBar.getPosition();
        assertEquals(9, position.getDiscreteX());
        assertEquals(10, position.getDiscreteY());
    }
}
