package com.g19.breakout.view.factory;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.ArenaView;
import com.g19.breakout.view.BallView;
import com.g19.breakout.view.PlayerView;
import com.g19.breakout.view.TilesView;
import com.g19.breakout.view.graphics.Graphics;


public interface ViewFactory {
    BallView createBallView(BallModel ball, Graphics graphics);
    PlayerView createPlayerView(PlayerModel playerBar, Graphics graphics);
    TilesView createTilesView(TileModel tile, Graphics graphics);
    ArenaView createArenaView(ArenaModel arena, Graphics graphics);
}
