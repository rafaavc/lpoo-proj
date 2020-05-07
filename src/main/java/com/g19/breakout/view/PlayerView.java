package com.g19.breakout.view;

import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.graphics.Graphics;

public class PlayerView extends ElementView implements View {
    public PlayerView(PlayerModel playerBar, Graphics graphics, String color, char charRep) {
        super(playerBar, graphics, color, charRep);
    }

    public void draw(ArenaModel arena) {
        drawModel(arena.getPlayerBar());
    }
}
