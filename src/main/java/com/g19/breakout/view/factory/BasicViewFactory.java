package com.g19.breakout.view.factory;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerBarModel;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.ArenaView;
import com.g19.breakout.view.BallView;
import com.g19.breakout.view.PlayerBarView;
import com.g19.breakout.view.TilesView;
import com.g19.breakout.view.graphics.Graphics;

public class BasicViewFactory implements ViewFactory {
    public BallView createBallView(BallModel ball, Graphics graphics) {
        return new BallView(ball, graphics, "#0000ff", '█');
    }
    public PlayerBarView createPlayerBarView(PlayerBarModel playerBar, Graphics graphics) {
        return new PlayerBarView(playerBar, graphics, "#ffffff", '█');
    }
    public TilesView createTilesView(TileModel tile, Graphics graphics) {
        return new TilesView(tile, graphics, "#ff0000", '█');
    }
    public ArenaView createArenaView(ArenaModel arena, Graphics graphics) {
        return new ArenaView(arena, graphics, this);
    }
}
