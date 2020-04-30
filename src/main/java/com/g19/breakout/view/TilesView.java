package com.g19.breakout.view;

import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.graphics.Graphics;

import java.util.List;

public class TilesView extends ElementView {
    public TilesView(TileModel tile, Graphics graphics, String color, char charRep) {
        super(tile, graphics, color, charRep);
    }

    String[] tileColors = {"#ff00f0", "#f0f0f0", "#f0f000", "#ff0000", "#0f0ff0", "#00ff00", "#00ff00", "#00ff00", "#00ff00"};

    public void draw(List<TileModel> tiles) {
        for (TileModel tile : tiles) {
            color = tileColors[tile.getLife()-1];
            drawModel(tile);
        }
    }
}
