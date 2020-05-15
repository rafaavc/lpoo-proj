package com.g19.breakout.view.factory;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.*;
import com.g19.breakout.view.graphics.Graphics;

import java.util.List;


public interface ViewFactory {
    BallView createBallView(BallModel ball, Graphics graphics);
    PlayerView createPlayerView(PlayerModel playerBar, Graphics graphics);
    TilesView createTilesView(List<TileModel> tiles, Graphics graphics);
    ScoreboardView createScoreboardView(PlayerModel player, Graphics graphics);
    ArenaView createArenaView(ArenaModel arena, Dimensions gameDimensions, Graphics graphics);
    MainMenuView createMainMenuView(Graphics graphics, Dimensions gameDimensions);
    MenuView createMenuView(Dimensions dimensions, Position position);
    MenuButtonView createMenuButtonView(String text, String color, Graphics graphics);
}
