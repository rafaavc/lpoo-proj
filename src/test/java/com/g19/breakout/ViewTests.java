package com.g19.breakout;

import com.g19.breakout.elements.Ball;
import com.g19.breakout.graphics.Graphics;
import com.g19.breakout.graphics.LanternaAdapter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ViewTests {
    private ArenaModel arena;
    private Graphics graphics;
    private ArenaView view;

    @Before
    public void setup() throws IOException {
        arena = Mockito.mock(ArenaModel.class);
        graphics = Mockito.mock(LanternaAdapter.class);
        view = new ArenaView(arena, graphics);
    }

    @Test
    public void testConstructor() throws IOException {
        verify(arena, times(1)).getHeight();
        verify(arena, times(1)).getWidth();
        verify(graphics, times(1)).init(arena.getWidth(), arena.getHeight());
    }



    @Test
    public void testDrawBall() throws IOException {
        ArenaView view = new ArenaView(arena, graphics);
        Ball ball = Mockito.mock(Ball.class);

        view.drawBall(ball);
        verify(graphics, times(1)).drawCenteredString(ball.getPosition(), ball.getStringRep(), ball.getColor());
    }
}
