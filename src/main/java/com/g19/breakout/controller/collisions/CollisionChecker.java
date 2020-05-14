package com.g19.breakout.controller.collisions;

import com.g19.breakout.controller.ball.*;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;

import java.util.ArrayList;
import java.util.List;

public class CollisionChecker {
    private final ArenaModel arena;

    public CollisionChecker(ArenaModel arena) {
        this.arena = arena;
    }

    public BallHit checkBallCollisions(Position position, Dimensions dimensions) {
        BallModel ball = arena.getBall();
        BallHit ballHit = new BallHit(ball);

        if (position.getDiscreteY() == -1) ballHit.setBallHit(new BallHitHorizontal(ball));
        if (position.getDiscreteY() == arena.getHeight() - dimensions.getDiscreteY() + 1) ballHit.setBallHit(new BallHitBottom(ball));
        if (checkHitPlayer(position)) ballHit.setBallHit(new BallHitPlayerBar(ball, arena.getPlayer()));

        TileModel tile = checkHitTile(position);
        if (tile != null) {
            ballHit.setBallHit(checkHitTopOrSideTile(tile));
            tile.hit();
            arena.getPlayer().addPoints(10);
        }

        if (position.getDiscreteX() == dimensions.getDiscreteX()/2. - 1 ||
                position.getDiscreteX() == arena.getWidth() - dimensions.getDiscreteX()/2. + 1) ballHit.setBallHit(new BallHitVertical(ball));

        return ballHit;
    }

    protected BallHit checkHitTopOrSideTile(TileModel tile) {
        Position prevPos = arena.getBall().getPosition();
        Position tilePos = tile.getPosition();
        int ballHWidth = arena.getBall().getDimensions().getDiscreteX()/2;
        int tileHWidth = tile.getDimensions().getDiscreteX()/2;

        if (prevPos.getDiscreteX() + ballHWidth == tilePos.getDiscreteX() - tileHWidth ||
                prevPos.getDiscreteX() - ballHWidth == tilePos.getDiscreteX() + tileHWidth) return new BallHitVertical(arena.getBall());
        return new BallHitHorizontal(arena.getBall());
    }

    protected TileModel checkHitTile(Position position) {
        for (TileModel tile : arena.getTiles()) {
            Position tilePos = tile.getPosition();
            int tileHeight = tile.getDimensions().getDiscreteY();
            int ballHeight = arena.getBall().getDimensions().getDiscreteY();

            boolean isInsideY = position.getY() + ballHeight > tilePos.getY() && position.getY() < tilePos.getY() + tileHeight;

            if (isInsideY) {
                int ballHWidth = arena.getBall().getDimensions().getDiscreteX()/2;
                int tileHWidth = tile.getDimensions().getDiscreteX()/2;
                if (position.getDiscreteX() + ballHWidth > tilePos.getDiscreteX() - tileHWidth &&
                        position.getDiscreteX() - ballHWidth < tilePos.getDiscreteX() + tileHWidth)  return tile;
            }
        }
        return null;
    }

    protected boolean checkHitPlayer(Position position) {
        PlayerModel player = arena.getPlayer();
        return position.getDiscreteY() == player.getPosition().getDiscreteY() &&
                position.getDiscreteX() >= player.getPosition().getDiscreteX() - player.getDimensions().getDiscreteX()/2 &&
                position.getDiscreteX() <= player.getPosition().getDiscreteX() + player.getDimensions().getDiscreteX()/2;
    }

    public boolean isInsideArena(Position position, Dimensions dimension) {
        return position.getDiscreteX() >= dimension.getDiscreteX()/2 && position.getDiscreteX() <= arena.getWidth() - dimension.getDiscreteX()/2
                && position.getDiscreteY() >= 0 && position.getDiscreteY() <= arena.getHeight() - dimension.getDiscreteY()/2;
    }
}
