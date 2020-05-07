package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class BallHitTests {

    @Test
    public void testBallHitBottom(){
        BallModel ball = new BallModel(new Position(1, 1), 1);
        BallHitBottom ballHitBottom = new BallHitBottom(ball, null);

        ballHitBottom.updateDirection();
        assertEquals(ball.getDirection(), new Direction(0, 0));
    }

    @Test
    public void testBallHitHorizontal(){
        BallModel ball = new BallModel(new Position(1, 1), 1);
        BallHitHorizontal ballHitHorizontal = new BallHitHorizontal(ball, null);

        Direction direction = Mockito.mock(Direction.class);
        Mockito.when(direction.hitHorizontal()).thenReturn(new Direction(0, 1));

        ballHitHorizontal.updateDirection();
        assertEquals(ball.getDirection(), new Direction(0, 1));
    }

    @Test
    public void testBallHitNothing(){
        BallModel ball = new BallModel(new Position(1,1),1);
        BallHitNothing ballHitNothing = new BallHitNothing(ball, null);

        ballHitNothing.updateDirection();
        assertEquals(ball.getDirection(), new Direction(0, -1));
    }

    @Test
    public void testBallHitPlayerBar(){
        BallModel ball = new BallModel(new Position(1,1), 1);
        ball.setDirection(new Direction(0, 1));

        PlayerModel playerBar = Mockito.mock(PlayerModel.class);
        Mockito.when(playerBar.getPosition()).thenReturn(new Position(1, 2));
        Mockito.when(playerBar.getDimensions()).thenReturn(new Dimensions(1, 1));


        BallHitPlayerBar ballHitPlayerBar = new BallHitPlayerBar(ball, null, playerBar);

        ballHitPlayerBar.updateDirection();
        assertEquals(new Direction(0, -1), ball.getDirection());
    }

    @Test
    public void testBallHitVertical(){
        BallModel ball = new BallModel(new Position(1, 1), 1);
        ball.setDirection(new Direction(1, 1));
        BallHitVertical ballHitVertical = new BallHitVertical(ball, null);

        ballHitVertical.updateDirection();
        assertEquals(new Direction(-1, 1), ball.getDirection());
    }

    @Test
    public void testMultipleBallHit(){
        BallModel ball = new BallModel(new Position(1,1), 1);
        ball.setDirection(new Direction(1, -1));
        BallHitVertical ballHitVertical = new BallHitVertical(ball, null);
        BallHitHorizontal ballHitHorizontal = new BallHitHorizontal(ball, ballHitVertical);

        ballHitHorizontal.updateDirection();
        assertEquals(new Direction(-1,1 ), ball.getDirection());
    }
}
