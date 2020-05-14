package com.g19.breakout.view;

import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.graphics.Graphics;

public class PlayerView extends ElementView implements View {
    PlayerModel playerModel;
    public PlayerView(PlayerModel player, Graphics graphics, String color, char charRep) {
        super(player, graphics, color, charRep);
        this.playerModel = player;

    }

    public void draw() {
        drawElementModel(playerModel);
    }

    public void drawWithoutArena(PlayerModel model) {
        drawElementModel(model);
    }
}
