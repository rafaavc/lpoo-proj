package com.g19.breakout.model;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class TileModel extends ElementModel {
    int life, horizontalIndex;

    public TileModel(Position position, Dimensions dim, int life, int horizontalIndex) {
        super(position, dim);
        this.life = life;
        this.horizontalIndex = horizontalIndex;
    }

    static public List<TileModel> createTileArray(int nHorizontal, int nVertical, ArenaModel arena) {
        int horizontalFreeSpace, horizontalFreeSpaceEach, verticalFreeSpaceEach, tileWidth, marginBetweenTiles, margin, tileHeight;

        horizontalFreeSpace = arena.getWidth();
        horizontalFreeSpaceEach = horizontalFreeSpace/nHorizontal;
        verticalFreeSpaceEach = 5;
        marginBetweenTiles = 4;
        tileWidth = horizontalFreeSpaceEach-marginBetweenTiles;
        tileHeight = verticalFreeSpaceEach-(marginBetweenTiles/2);

        margin = (arena.getWidth() - horizontalFreeSpaceEach*nHorizontal + marginBetweenTiles)/2;

        if (tileWidth%2 != 0) {
            tileWidth--;
            margin++;
        }

        List<TileModel> tiles = new ArrayList<>();
        for (int i = 0; i < nHorizontal; i++) {
            for (int j = 0; j < nVertical; j++) {
                Position pos = new Position(margin + tileWidth/2. + i*horizontalFreeSpaceEach, margin/2. + j*verticalFreeSpaceEach);
                Dimensions dim = new Dimensions(tileWidth, tileHeight);
                tiles.add(new TileModel(pos, dim, 2 + nVertical - j, i));
            }
        }
        return tiles;
    }

    // returns true if hit killed the tile
    public boolean hit() {
        life--;
        return life == 0;
    }

    public int getHorizontalIndex() {
        return horizontalIndex;
    }

    public int getLife() {
        return life;
    }
}
