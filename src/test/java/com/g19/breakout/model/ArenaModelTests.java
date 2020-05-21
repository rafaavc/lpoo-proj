package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.factory.BasicModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaModelTests {
    ArenaModel arena;
    Dimensions dimensions = new Dimensions(100, 120);

    @BeforeEach
    public void setup() {
        arena = new ArenaModel(dimensions, new BasicModelFactory());
    }

    @Test
    public void testWidthHeight() {
        assertEquals(arena.getHeight(), this.dimensions.getDiscreteY() - 6);
        assertEquals(arena.getWidth(), this.dimensions.getDiscreteX());
    }

    @Test
    public void testPlayerBar() {
        assertEquals(arena.getPlayer().getPosition(), new Position(this.dimensions.getDiscreteX()/2., this.dimensions.getDiscreteY()-6-4));
    }

    @Test
    public void testBall() {
        assertEquals(arena.getBall().getPosition(), new Position(this.dimensions.getDiscreteX()/2., this.dimensions.getDiscreteY()-6-5));
    }

}
