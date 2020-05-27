package com.g19.breakout.elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTests {
    @Test
    public void directionNextPosition(){
        Direction direction = new Direction(1, -1);

        Position initialPosition = new Position(10, 5);
        Position finalPosition = direction.getNextPosition(initialPosition, Math.sqrt(2));

        assertEquals(11,finalPosition.getX(), 0.001);
        assertEquals(4, finalPosition.getY(), 0.001);
    }

    @Test
    public void directionEquals(){
        Direction direction1 = new Direction(1, 1);
        Direction direction2 = new Direction(1, 1);

        assertEquals(direction1, direction2);
    }

    @Test
    public void directionGetMethods(){
        Direction direction = new Direction(1, -1);

        assertEquals(Math.sqrt(2)/2, direction.getX(), 0.001);
        assertEquals(-Math.sqrt(2)/2, direction.getY(), 0.001);

    }
}
