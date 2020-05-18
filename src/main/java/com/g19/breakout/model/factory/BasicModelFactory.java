package com.g19.breakout.model.factory;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;

public class BasicModelFactory implements ModelFactory {
    public PlayerModel createPlayerModel(Dimensions arenaDimensions) {
        return new PlayerModel(new Position(arenaDimensions.getDiscreteX()/2., arenaDimensions.getDiscreteY()-4));
    }
    public PlayerModel createPlayerModel(Position position) {
        return new PlayerModel(position);
    }
    public BallModel createBallModel(Dimensions arenaDimensions) {
        return new BallModel(new Position(arenaDimensions.getDiscreteX() / 2., arenaDimensions.getDiscreteY() - 5), 20);
    }
    public ArenaModel createArenaModel(Dimensions gameDimensions) {
        ArenaModel arena = new ArenaModel(gameDimensions, this);
        arena.setTiles(TileModel.createTileArray(5, 4, arena));
        return arena;
    }
}
