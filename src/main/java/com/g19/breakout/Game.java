package com.g19.breakout;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.Transformer;
import com.g19.breakout.controller.state.StateFactory;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.model.GameModel;
import com.g19.breakout.view.GameView;
import com.g19.breakout.view.graphics.Graphics;
import com.g19.breakout.view.graphics.LanternaAdapter;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException, InterruptedException {
        GameModel model = new GameModel(new Dimensions(120, 50));
        Graphics graphics = new LanternaAdapter(model.getDimensions());
        GameView view = new GameView(graphics);

        GameController controller = new GameController(view, model, new Chronometer(), new StateFactory(), 60);

        controller.start(new Transformer());
        graphics.exit();
    }
}
