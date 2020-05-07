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

public class BasicViewFactory implements ViewFactory {
    public BallView createBallView(BallModel ball, Graphics graphics) {
        return new BallView(ball, graphics, "#0000ff", '█');
    }
    public PlayerView createPlayerView(PlayerModel playerBar, Graphics graphics) {
        return new PlayerView(playerBar, graphics, "#ffffff", '█');
    }
    public TilesView createTilesView(TileModel tile, Graphics graphics) {
        return new TilesView(tile, graphics, "#ff0000", '█');
    }
    public ArenaView createArenaView(ArenaModel arena, Graphics graphics) {
        ArenaView view = new ArenaView(graphics);

        view.addView(createBallView(arena.getBall(), graphics));
        view.addView(createPlayerView(arena.getPlayer(), graphics));
        view.addView(createTilesView(arena.getTiles().get(0), graphics));

        return view;
    }
}
