package com.g19.breakout.view;

import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.graphics.Graphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TilesView extends ElementView implements View {
    private final List<TileModel> tiles;
    String[] colors = {"00ad08", "9111d6", "f0f000", "ff0000", "0f0ff0", "00ff00", "00ff00", "00ff00", "00ff00"};
    List<Color> tileColors;

    public TilesView(List<TileModel> tiles, Graphics graphics, String color, char charRep) {
        super(tiles.get(0), graphics, color, charRep);
        this.tiles = tiles;
        this.tileColors = new ArrayList<>();
        for (String s : colors) {
            tileColors.add(new Color(Integer.parseInt(s, 16)));
        }
    }

    public void draw() {
        for (TileModel tile : tiles) {
            Color c = tileColors.get(tile.getHorizontalIndex()%tileColors.size());

            for (int i = 0; i < 6 - tile.getLife(); i++) {
                c = c.darker();
            }

            color = String.format("#%06x", c.getRGB() & 0x00FFFFFF);

            drawElementModel(tile);
        }
    }
}
