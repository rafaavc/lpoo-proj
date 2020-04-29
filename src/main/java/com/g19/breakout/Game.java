package com.g19.breakout;

import com.g19.breakout.controller.ArenaController;
import com.g19.breakout.view.graphics.LanternaAdapter;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.view.ArenaView;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        ArenaModel arena = new ArenaModel(120, 50);
        ArenaView view = new ArenaView(arena, new LanternaAdapter(arena.getWidth(), arena.getHeight()));
        ArenaController controller = new ArenaController(arena, view);
        controller.start();
    }
}
