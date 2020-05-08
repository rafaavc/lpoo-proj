package com.g19.breakout;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.Transformer;
import com.g19.breakout.controller.state.PlayingGameState;
import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.factory.BasicArenaModelFactory;
import com.g19.breakout.view.GameView;
import com.g19.breakout.view.factory.BasicViewFactory;
import com.g19.breakout.view.graphics.Graphics;
import com.g19.breakout.view.graphics.LanternaAdapter;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.view.ArenaView;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        Graphics graphics = new LanternaAdapter(new Dimensions(120, 50));
        GameView view = new GameView(graphics);
        GameController controller = new GameController(view, new Chronometer());

        ArenaModel arena = new BasicArenaModelFactory().createArenaModel(new Position(0, 6), new Dimensions(120, 44));
        ArenaView arenaView = new BasicViewFactory().createArenaView(arena, graphics);

        controller.setState(new PlayingGameState(arena, arenaView, controller), new Chronometer());

        controller.start(new Transformer());
    }
}
