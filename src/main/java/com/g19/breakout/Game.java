package com.g19.breakout;

import com.g19.breakout.graphics.LanternaAdapter;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        ArenaModel arena = new ArenaModel(120, 40);
        ArenaView view = new ArenaView(arena, new LanternaAdapter());
        ArenaController controller = new ArenaController(arena, view);
        controller.start();
    }
}
