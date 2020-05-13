package com.g19.breakout.model.factory;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;

public class BasicArenaModelFactory implements ArenaModelFactory {
    public PlayerModel createPlayerModel(ArenaModel arena) {
        return new PlayerModel(new Position(arena.getWidth()/2., arena.getHeight()-4));
    }
    public BallModel createBallModel(ArenaModel arena) {
        return new BallModel(new Position(arena.getWidth() / 2., arena.getHeight() - 5), 20);
    }
    public ArenaModel createArenaModel(Dimensions gameDimensions) {
        ArenaModel arena = new ArenaModel(gameDimensions, this);
        arena.setTiles(TileModel.createTileArray(5, 4, arena));
        return arena;
    }
}
