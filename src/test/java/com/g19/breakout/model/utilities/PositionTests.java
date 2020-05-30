package com.g19.breakout.model.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTests {
    private final Position initial = new Position(10, 5);
    @Test
    public void positionLeft(){
        Position test = initial.left();

        assertEquals(9, test.getDiscreteX());
        assertEquals(5, test.getDiscreteY());
    }

    @Test
    public void positionRight(){
        Position test = initial.right();

        assertEquals(11, test.getDiscreteX());
        assertEquals(5, test.getDiscreteY());
    }

    @Test
    public void positionUp(){
        Position test = initial.up();

        assertEquals(10, test.getDiscreteX());
        assertEquals(4, test.getDiscreteY());
    }

    @Test
    public void positionDown(){
        Position test = initial.down();

        assertEquals(10, test.getDiscreteX());
        assertEquals(6, test.getDiscreteY());
    }

    @Test
    public void positionEquals(){
        Position test = new Position(10, 5);

        assertEquals(initial, test);
    }
}
