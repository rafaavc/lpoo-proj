package com.g19.breakout.model;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.factory.BasicModelFactory;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaModelTests {
    ArenaModel arena;
    Dimensions dimensions = new Dimensions(100, 120);

    @BeforeEach
    @BeforeProperty
    public void setup() {
        arena = new ArenaModel(dimensions, new BasicModelFactory());
    }

    @Property
    public void isInsideArenaTest(@ForAll int x, @ForAll int y){
        Dimensions newDimensions = new Dimensions(1, 1);
        Position position = new Position(x, y);
        assert(x >= 0 || !arena.isInsideArena(position, newDimensions));
        assert(y >= 0 || !arena.isInsideArena(position, newDimensions));
        assert(x < arena.getWidth() || !arena.isInsideArena(position, newDimensions));
        assert(y < arena.getHeight() || !arena.isInsideArena(position, newDimensions));
    }

    @Test
    public void checkHitTileTest(){

        Position position = new Position(this.dimensions.getDiscreteX() / 2., 11);
        List<TileModel> tiles = new ArrayList<>();
        TileModel expectedTile = new TileModel(new Position(this.dimensions.getDiscreteX()/2., 8), new Dimensions(10, 4), 5, 1);
        tiles.add(expectedTile);
        tiles.add(new TileModel(new Position(this.dimensions.getDiscreteX()/2. + 20, 8), new Dimensions(10, 4), 5, 1));
        arena.setTiles(tiles);

        TileModel actualTile = arena.checkHitTile(position);


        assertEquals(expectedTile.getLife(), actualTile.getLife());
        assertEquals(expectedTile.getDimensions(), actualTile.getDimensions());
        assertEquals(expectedTile.getPosition(), actualTile.getPosition());
    }

    @Test
    public void checkHitPlayerBarTest(){

        Position nextPosition = new Position(60, 40);

        PlayerModel player = Mockito.mock(PlayerModel.class);

        Position position = new Position(60, 40);
        Mockito.when(player.getPosition()).thenReturn(position);

        Dimensions dimensions = new Dimensions(10, 1);
        Mockito.when(player.getDimensions()).thenReturn(dimensions);

        ArenaModel arena1 = new ArenaModel(dimensions, new BasicModelFactory());

        assertTrue(arena1.checkHitPlayer(nextPosition, player));

        nextPosition = new Position(1 ,1);
        assertFalse(arena1.checkHitPlayer(nextPosition, player));
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
