package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.ballhit.*;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.TileModel;

import java.util.ArrayList;
import java.util.List;


public class BallCollisionChecker {
    private final ArenaModel arena;
    private final TilesController tilesController;

    public BallCollisionChecker(ArenaModel arena, TilesController tilesController) {
        this.arena = arena;
        this.tilesController = tilesController;
    }

    public List<BallHit> checkBallCollisions(Position position, Dimensions dimensions) {
        BallModel ball = arena.getBall();

        List<BallHit> ballHits = checkBallHitArenaWalls(position, dimensions);

        if (arena.checkHitPlayer(position, arena.getPlayer())) ballHits.add(new BallHitPlayerBar(ball, arena.getPlayer()));

        TileModel tile = arena.checkHitTile(position);

        if (tile != null) {
            ballHits.add(checkHitTopOrSideTile(tile));
            tilesController.tileWasHit(tile, arena.getPlayer());
        }

        return ballHits;
    }

    public List<BallHit> checkBallHitArenaWalls(Position position, Dimensions dimensions) {
        BallModel ball = arena.getBall();
        List<BallHit> ballHits = new ArrayList<>();

        if (position.getDiscreteY() <= -1) ballHits.add(new BallHitHorizontal(ball));
        if (position.getDiscreteY() >= arena.getHeight() - dimensions.getDiscreteY() + 1) ballHits.add(new BallHitBottom(ball));

        if (position.getDiscreteX() <= dimensions.getDiscreteX()/2. - 1 ||
                position.getDiscreteX() >= arena.getWidth() - dimensions.getDiscreteX()/2. + 1) ballHits.add(new BallHitVertical(ball));

        return ballHits;
    }

    protected BallHit checkHitTopOrSideTile(TileModel tile) {
        Position tilePos = tile.getPosition();
        Position prevPos = arena.getBall().getPosition();

        int ballHWidth = arena.getBall().getDimensions().getDiscreteX()/2;
        int tileHWidth = tile.getDimensions().getDiscreteX()/2;

        if (prevPos.getDiscreteX() + ballHWidth == tilePos.getDiscreteX() - tileHWidth ||
                prevPos.getDiscreteX() - ballHWidth == tilePos.getDiscreteX() + tileHWidth) return new BallHitVertical(arena.getBall());
        return new BallHitHorizontal(arena.getBall());
    }

    public ArenaModel getArena() {
        return arena;
    }
}
