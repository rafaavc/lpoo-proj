package com.g19.breakout.view.factory;

import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerBarModel;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.BallView;
import com.g19.breakout.view.PlayerBarView;
import com.g19.breakout.view.TilesView;
import com.g19.breakout.view.graphics.Graphics;


public interface ViewFactory {
    BallView createBallView(BallModel ball, Graphics graphics);
    PlayerBarView createPlayerBarView(PlayerBarModel playerBar, Graphics graphics);
    TilesView createTilesView(TileModel tile, Graphics graphics);
}
