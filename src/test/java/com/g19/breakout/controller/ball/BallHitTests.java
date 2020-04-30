package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class BallHitTests {
    BallModel ball = Mockito.mock(BallModel.class);

    @Test
    public void ballHitBottom(){
        BallHitBottom ballHitBottom = new BallHitBottom(ball, null);

        ballHitBottom.updateDirection();
        Mockito.verify(ball, Mockito.times(1)).setDirection(new Direction(0,0));
    }

    @Test
    public void ballHitHorizontal(){

    }
}
