package com.g19.breakout;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        Arena arena = new Arena(80, 50);
        View view = new View(arena);
        Controller controller = new Controller(arena);
        view.draw();
        while (controller.getNextCommand(view)){
            view.draw();;
        }

    }
}
