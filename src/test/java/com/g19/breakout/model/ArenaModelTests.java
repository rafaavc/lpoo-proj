package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.factory.BasicArenaModelFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArenaModelTests {
    ArenaModel arena;
    Dimensions dimensions = new Dimensions(100, 120);

    @Before
    public void setup() {
        arena = new ArenaModel(dimensions, new BasicArenaModelFactory());
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
