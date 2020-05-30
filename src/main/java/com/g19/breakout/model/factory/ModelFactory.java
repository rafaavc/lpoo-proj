package com.g19.breakout.model.factory;

import com.g19.breakout.model.*;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;

public interface ModelFactory {
    BallModel createBallModel(Dimensions arenaDimensions);
    PlayerModel createPlayerModel(Dimensions arenaDimensions);
    ArenaModel createArenaModel(Dimensions dimensions);
    PlayerModel createPlayerModel(Position position);
    GameModel createGameModel(Dimensions gameDimensions);
    BackgroundModel createBackgroundModel(Dimensions gameDimensions);

}
