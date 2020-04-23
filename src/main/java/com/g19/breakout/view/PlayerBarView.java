package com.g19.breakout.view;

import com.g19.breakout.model.PlayerBarModel;
import com.g19.breakout.view.graphics.Graphics;

public class PlayerBarView extends ElementView {
    PlayerBarView(PlayerBarModel playerBar, Graphics graphics, String color, char charRep) {
        super(playerBar, graphics, color, charRep);
    }
}
