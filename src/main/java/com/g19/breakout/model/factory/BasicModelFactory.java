package com.g19.breakout.model.factory;

import com.g19.breakout.model.*;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;

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

    public GameModel createGameModel(Dimensions gameDimensions) {
        return new GameModel(gameDimensions, this);
    }

    public BackgroundModel createBackgroundModel(Dimensions gameDimensions) {
        return new BackgroundModel(gameDimensions);
    }
}
