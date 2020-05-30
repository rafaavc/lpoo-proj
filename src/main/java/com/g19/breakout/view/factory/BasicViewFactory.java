package com.g19.breakout.view.factory;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.*;
import com.g19.breakout.view.*;
import com.g19.breakout.view.graphics.Graphics;
import com.sun.tools.javac.util.Pair;

import java.util.List;
import java.util.PriorityQueue;

public class BasicViewFactory implements ViewFactory {
    private final String backgroundColor = "#0f0f0f";

    public PauseView createPauseView(Graphics graphics, Dimensions gameDimensions) {
        return new PauseView(graphics, gameDimensions, backgroundColor);
    }
    public MainMenuView createMainMenuView(Graphics graphics, Dimensions gameDimensions) {
        return new MainMenuView(graphics, gameDimensions, backgroundColor);
    }
    public BackgroundView createBackgroundView(Graphics graphics, GameModel model) {
        return new BackgroundView(graphics, model, backgroundColor);
    }
    public LeaderboardView createLeaderboardView(Graphics graphics, Dimensions gameDimensions, PriorityQueue<Pair<String, Integer>> lb) {
        return new LeaderboardView(graphics, gameDimensions, lb, backgroundColor);
    }
    public GameOverView createGameOverView(Graphics graphics, Dimensions gameDimensions, PlayerModel playerModel) {
        return new GameOverView(graphics, gameDimensions, playerModel, backgroundColor);
    }
    public MenuView createMenuView(Graphics graphics, Dimensions dimensions, Position position) {
        return new MenuView(graphics, dimensions, position);
    }
    public MenuButtonView createMenuButtonView(String text, String color, Graphics graphics) {
        return new MenuButtonView(text, color, graphics);
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

    public GameView createGameView(Graphics graphics, GameModel model) {
        return new GameView(graphics, this, model);
    }
}
