package com.g19.breakout.controller;

import com.g19.breakout.controller.ball.*;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.TileModel;


public class CollisionChecker {
    private final ArenaModel arena;
    private final Chronometer chrono;

    public CollisionChecker(ArenaModel arena, Chronometer chrono) {
        this.arena = arena;
        this.chrono = chrono;
    }

    public void tileWasHit(TileModel tile) {
        tile.hit();
        int points = 10;

        if (chrono.getLastTime() != -1) {
            double elapsed = chrono.end() / 1000.;  // seconds

            if (elapsed < 1) {   // if less than 1 second
                double mult = 1 - elapsed; // multiplier - the lesser the time elapsed sice last hit, the more points you get
                points = (int) (mult*20) + points;
            }
        }

        arena.getPlayer().addPoints(points);
        chrono.start();
    }

    public BallHit checkBallCollisions(Position position, Dimensions dimensions) {
        BallModel ball = arena.getBall();

        BallHit ballHit = checkBallHitArenaWalls(position, dimensions);

        if (arena.checkHitPlayer(position, arena.getPlayer())) ballHit.setBallHit(new BallHitPlayerBar(ball, arena.getPlayer()));

        TileModel tile = arena.checkHitTile(position);

        if (tile == null) return ballHit;

        ballHit.setBallHit(checkHitTopOrSideTile(tile));
        tileWasHit(tile);

        return ballHit;
    }

    public BallHit checkBallHitArenaWalls(Position position, Dimensions dimensions) {
        BallModel ball = arena.getBall();
        BallHit ballHit = new BallHit(ball);

        if (position.getDiscreteY() <= -1) ballHit.setBallHit(new BallHitHorizontal(ball));
        if (position.getDiscreteY() >= arena.getHeight() - dimensions.getDiscreteY() + 1) ballHit.setBallHit(new BallHitBottom(ball));

        if (position.getDiscreteX() <= dimensions.getDiscreteX()/2. - 1 ||
                position.getDiscreteX() >= arena.getWidth() - dimensions.getDiscreteX()/2. + 1) ballHit.setBallHit(new BallHitVertical(ball));

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
}
