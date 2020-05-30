package com.g19.breakout;

import com.g19.breakout.controller.FileManager;
import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.Transformer;
import com.g19.breakout.controller.state.StateFactory;
import com.g19.breakout.controller.Chronometer;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.BackgroundModel;
import com.g19.breakout.model.GameModel;
import com.g19.breakout.model.factory.BasicModelFactory;
import com.g19.breakout.view.GameView;
import com.g19.breakout.view.factory.BasicViewFactory;
import com.g19.breakout.view.graphics.Graphics;
import com.g19.breakout.view.graphics.LanternaAdapter;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException, InterruptedException {
        //model
        GameModel model = new BasicModelFactory().createGameModel(new Dimensions(120, 50));

        //view
        Graphics graphics = new LanternaAdapter(model.getDimensions());
        GameView view = new BasicViewFactory().createGameView(graphics, model);

        //controller
        GameController controller = new GameController(view, model, new Chronometer(), new StateFactory(), 60);

        controller.start(new Transformer(), new FileManager());
    }
}
