package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.ballhit.BallHit;
import com.g19.breakout.controller.commands.ballhit.BallHitHorizontal;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

public class BallControllerTests {
    @Mock private BallCollisionChecker collisionChecker;
    @Mock private ArenaModel arena;

    private BallController ballController;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(collisionChecker.checkBallCollisions(any(Position.class), any(Dimensions.class))).thenReturn(new ArrayList<>());
        Mockito.when(collisionChecker.getArena()).thenReturn(arena);

        BallModel ball = new BallModel(new Position(10, 10), 1);
        Mockito.when(arena.getBall()).thenReturn(ball);

        ballController = new BallController(collisionChecker);
    }

    @Test
    public void updateTest() {

        BallController ballControllerSpy = Mockito.spy(ballController);

        assertEquals(ballControllerSpy.update(1000), new Position(10, 9));
        Mockito.verify(ballControllerSpy, times(1)).updateBallDirection(new Position(10, 9));
    }

    @Test
    public void updateBallDirectionTest(){
         BallModel ball = new BallModel(new Position(10, 10), 10);
         Mockito.when(arena.getBall()).thenReturn(ball);

         BallHitHorizontal ballHitHorizontal = new BallHitHorizontal(ball);
         List<BallHit> ballHits = new ArrayList<>();
         ballHits.add(ballHitHorizontal);

         Mockito.when(collisionChecker.checkBallCollisions(any(Position.class), any(Dimensions.class))).thenReturn(ballHits);

         assertTrue(ballController.updateBallDirection(new Position(11, 10)));
    }

}
