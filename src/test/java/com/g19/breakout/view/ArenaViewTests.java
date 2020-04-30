package com.g19.breakout.view;

import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.view.graphics.Graphics;
import com.g19.breakout.view.graphics.LanternaAdapter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ArenaViewTests {
    private ArenaModel arena;
    private Graphics graphics;
    private ArenaView view;

    /*
    * To test this class maybe remove view's
    * initialization from constructor
    * to a set method
    * */

    //@Before
    public void setup() throws IOException {
        arena = Mockito.mock(ArenaModel.class);
        graphics = Mockito.mock(LanternaAdapter.class);
        view = new ArenaView(arena, graphics);
    }

    /*@Test
    public void testConstructor() throws IOException {
        /*
        verify(arena, times(1)).getHeight();
        verify(arena, times(1)).getWidth();
        verify(graphics, times(1)).init(arena.getWidth(), arena.getHeight());
    }*/

    /*@Test
    public void testDraw() throws IOException {
        /* I don't think this needs testing */
        /*ArenaView view1 = Mockito.mock(ArenaView.class);
        view.draw(view1, arena);

        verify(graphics, times(1)).startDrawing();
        verify(view1, times(1)).drawBackground(arena);
        verify(view1, times(1)).drawPlayerBar(arena.getPlayerBar());
        verify(view1, times(1)).drawBall(arena.getBall());
        verify(graphics, times(1)).stopDrawing();*/
    //}

/*
    @Test
    public void testDrawBall() {
        BallModel ball = Mockito.mock(BallModel.class);

        view.drawBall(ball);
        verify(graphics, times(1)).drawElement(ball);
    }

    @Test
    public void testDrawPlayerBar() {
        PlayerBarModel playerBar = Mockito.mock(PlayerBarModel.class);

        view.drawPlayerBar(playerBar);
        verify(graphics, times(1)).drawElement(playerBar);
    }*/

    //@Test
    public void testDrawBackground() {
        view.drawBackground(arena);
        verify(graphics, times(1)).drawRectangle(new Position(0, 0), new Position(arena.getWidth(), arena.getHeight()), ' ', view.getBGColor());
    }

    //@Test
    public void testReadInput() throws IOException {
        view.readInput();
        verify(graphics, times(1)).readInput();
    }
}
