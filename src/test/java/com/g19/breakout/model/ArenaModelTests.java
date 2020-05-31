package com.g19.breakout.model;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.factory.BasicModelFactory;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaModelTests {
    private ArenaModel arena;
    private final Dimensions dimensions = new Dimensions(100, 120);

    @BeforeEach
    @BeforeProperty
    public void setup() {
        arena = new ArenaModel(dimensions, new BasicModelFactory());
    }

    @Property
    public void isInsideArenaTest(@ForAll int x, @ForAll int y, @ForAll @IntRange(min = 1) int dx, @ForAll @IntRange(min = 1) int dy){
        Dimensions newDimensions = new Dimensions(dx, dy);
        Position position = new Position(x, y);
        assert(x >= newDimensions.getDiscreteX()/2 || !arena.isInsideArena(position, newDimensions));
        assert(y >= 0 || !arena.isInsideArena(position, newDimensions));
        assert(x <= arena.getDimensions().getDiscreteX() - newDimensions.getDiscreteX()/2 || !arena.isInsideArena(position, newDimensions));
        assert(y <= arena.getDimensions().getDiscreteY() - newDimensions.getDiscreteY() || !arena.isInsideArena(position, newDimensions));
    }

    @Property
    public void checkHitTileTest(@ForAll int x, @ForAll int y){

        Position position = new Position(x, y);
        List<TileModel> tiles = new ArrayList<>();
        TileModel expectedTile = new TileModel(new Position(this.dimensions.getDiscreteX()/2., 8), new Dimensions(10, 4), 5, 1);
        tiles.add(expectedTile);
        arena.setTiles(tiles);

        TileModel actualTile = arena.checkHitTile(position);

        assert(x >= this.dimensions.getDiscreteX()/2. - 1 || actualTile == null);
        assert(x <= this.dimensions.getDiscreteX()/2. + 11 || actualTile == null);
        assert(y >= 8 || actualTile == null);
        assert(y <= 12 || actualTile == null);
        assert(actualTile == null || expectedTile.getLife() == actualTile.getLife());
        assert(actualTile == null || expectedTile.getDimensions() == actualTile.getDimensions());
        assert(actualTile == null || expectedTile.getPosition() == actualTile.getPosition());
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
        assertEquals(arena.getDimensions().getDiscreteY(), this.dimensions.getDiscreteY() - 6);
        assertEquals(arena.getDimensions().getDiscreteX(), this.dimensions.getDiscreteX());
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
