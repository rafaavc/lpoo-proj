package com.g19.breakout.view.factory;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.*;
import com.g19.breakout.view.*;
import com.g19.breakout.view.graphics.Graphics;
import com.sun.tools.javac.util.Pair;

import java.util.List;
import java.util.PriorityQueue;


public interface ViewFactory {
    BallView createBallView(BallModel ball, Graphics graphics);
    PlayerView createPlayerView(PlayerModel playerBar, Graphics graphics);
    TilesView createTilesView(List<TileModel> tiles, Graphics graphics);
    ScoreboardView createScoreboardView(PlayerModel player, Graphics graphics);
    ArenaView createArenaView(ArenaModel arena, Graphics graphics);
    MainMenuView createMainMenuView(Graphics graphics, Dimensions gameDimensions);
    LeaderboardView createLeaderboardView(Graphics graphics, Dimensions gameDimensions, PriorityQueue<Pair<String, Integer>> lb);
    PauseView createPauseView(Graphics graphics, Dimensions gameDimensions);
    GameOverView createGameOverView(Graphics graphics, Dimensions gameDimensions, PlayerModel playerModel);
    MenuView createMenuView(Graphics graphics, Dimensions dimensions, Position position);
    MenuButtonView createMenuButtonView(String text, String color, Graphics graphics);
    BackgroundView createBackgroundView(Graphics graphics, Dimensions gameDimensions, BackgroundModel backgroundModel);
}
