package com.g19.breakout.view;

import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.view.graphics.Graphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ElementViewTests {
    private BallModel model;
    private ElementView view;
    private Graphics graphics;

    @BeforeEach
    public void setup() throws IOException {
        model = Mockito.mock(BallModel.class);
        graphics = Mockito.mock(Graphics.class);

        Mockito.when(model.getDimensions()).thenReturn(new Dimensions(10, 2));
        Mockito.when(model.getPosition()).thenReturn(new Position(20, 20));
        view = new BallView(model, graphics, "ffffff", 'p');
    }

    @Test
    public void testUpdateStringRep() {
        view.updateStringRep(model);
        assertEquals(view.stringRep, "pppppppppp");
    }

    @Test
    public void testDrawModel() {
        view.drawElementModel(model);
        verify(graphics, times(2)).drawCenteredString(any(Position.class), any(String.class), any(String.class));
    }
}
