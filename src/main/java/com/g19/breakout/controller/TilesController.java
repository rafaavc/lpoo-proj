package com.g19.breakout.controller;

import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;

import java.util.List;

public class TilesController {
    List<TileModel> tiles;
    Chronometer chrono;

    public TilesController(List<TileModel> tiles, Chronometer chrono) {
        this.tiles = tiles;
        this.chrono = chrono;
    }

    public void update() {
        tiles.removeIf(t -> t.getLife() == 0);
    }

    public void tileWasHit(TileModel tile, PlayerModel player) {
        tile.hit();
        int points = 10;

        if (chrono.getLastTime() != -1) {
            double elapsed = chrono.end() / 1000.;  // seconds

            if (elapsed < 1) {   // if less than 1 second
                double mult = Math.round((1 - elapsed)*10)/10.;   // multiplier - the lesser the time elapsed sice last hit, the more points you get
                points = (int) (mult*20) + points;
            }
        }

        player.addPoints(points);
        chrono.start();
    }
}
