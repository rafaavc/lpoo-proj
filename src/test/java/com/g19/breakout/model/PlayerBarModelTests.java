package com.g19.breakout.model;

import com.g19.breakout.elements.Position;
import com.g19.breakout.model.PlayerBarModel;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class PlayerBarModelTests {

    @Test
    public void playerBarConstructor(){
        PlayerBarModel playerBar = new PlayerBarModel(new Position(10, 5));

        assertEquals(10, playerBar.getPosition().getDiscreteX());
        assertEquals(5, playerBar.getPosition().getDiscreteY());
    }
}
