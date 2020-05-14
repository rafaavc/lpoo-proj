package com.g19.breakout.model.factory;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;

public interface ArenaModelFactory {
    BallModel createBallModel(Dimensions arenaDimensions);
    PlayerModel createPlayerModel(Dimensions arenaDimensions);
    ArenaModel createArenaModel(Dimensions dimensions);
    PlayerModel createPlayerModel(Position position);
}
