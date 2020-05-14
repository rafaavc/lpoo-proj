package com.g19.breakout.view.factory;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.*;
import com.g19.breakout.view.graphics.Graphics;
import sun.rmi.rmic.Main;

import java.util.List;

public class BasicViewFactory implements ViewFactory {
    public PauseView createPauseView(Graphics graphics, Dimensions gameDimensions, PlayerModel player) {
        return new PauseView(graphics, gameDimensions, player, new BasicViewFactory());
    }
    public MainMenuView createMainMenuView(Graphics graphics) {
        return new MainMenuView(graphics);
    }
    public BallView createBallView(BallModel ball, Graphics graphics) {
        return new BallView(ball, graphics, "#0000ff", '█');
    }
    public PlayerView createPlayerView(PlayerModel playerBar, Graphics graphics) {
        return new PlayerView(playerBar, graphics, "#ffffff", '█');
    }
    public TilesView createTilesView(List<TileModel> tiles, Graphics graphics) {
        return new TilesView(tiles, graphics, "#ff0000", '█');
    }
    public ScoreboardView createScoreboardView(PlayerModel player, Graphics graphics) {
        return new ScoreboardView(graphics, player);
    }
    public ArenaView createArenaView(ArenaModel arena, Graphics graphics) {
        ArenaView view = new ArenaView(graphics, arena);

        view.addView(createBallView(arena.getBall(), graphics));
        view.addView(createPlayerView(arena.getPlayer(), graphics));
        view.addView(createTilesView(arena.getTiles(), graphics));
        view.addView(createScoreboardView(arena.getPlayer(), graphics));

        return view;
    }
}
