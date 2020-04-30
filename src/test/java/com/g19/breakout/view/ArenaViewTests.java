package com.g19.breakout.view;

import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerBarModel;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.factory.ViewFactory;
import com.g19.breakout.view.graphics.Graphics;
import com.g19.breakout.view.graphics.LanternaAdapter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ArenaViewTests {
    private Graphics graphics;
    private ArenaView view;
    private ViewFactory factory;

    @Before
    public void setup() {
        graphics = Mockito.mock(LanternaAdapter.class);
        factory = Mockito.mock(ViewFactory.class);
    }

    @Test
    public void testDraw() throws IOException {
        BallView ballViewMock = Mockito.mock(BallView.class);
        PlayerBarView playerBarViewMock = Mockito.mock(PlayerBarView.class);
        TilesView tilesViewMock = Mockito.mock(TilesView.class);

        Mockito.when(factory.createBallView(any(BallModel.class), any(Graphics.class))).thenReturn(ballViewMock);
        Mockito.when(factory.createPlayerBarView(any(PlayerBarModel.class), any(Graphics.class))).thenReturn(playerBarViewMock);
        Mockito.when(factory.createTilesView(any(TileModel.class), any(Graphics.class))).thenReturn(tilesViewMock);


        view = new ArenaView(new ArenaModel(100, 100), graphics, factory);

        ArenaView view1 = Mockito.spy(view);
        view1.draw();

        verify(view1, times(1)).drawBackground(any(ArenaModel.class));
        verify(graphics, times(1)).startDrawing();
        verify(graphics, times(1)).stopDrawing();
        verify(tilesViewMock, times(1)).draw(any(List.class));
        verify(playerBarViewMock, times(1)).draw(any(PlayerBarModel.class));
        verify(ballViewMock, times(1)).draw(any(BallModel.class));
    }

    @Test
    public void testDrawBackground() {
        view = new ArenaView(new ArenaModel(100, 100), graphics, factory);

        ArenaModel arena = Mockito.mock(ArenaModel.class);
        view.drawBackground(arena);
        verify(graphics, times(1)).drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', view.getBGColor());
    }

    @Test
    public void testReadInput() throws IOException {
        view = new ArenaView(new ArenaModel(100, 100), graphics, factory);

        view.readInput();
        verify(graphics, times(1)).readInput();
    }
}
