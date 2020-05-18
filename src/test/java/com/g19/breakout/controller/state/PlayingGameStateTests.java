package com.g19.breakout.controller.state;

import com.g19.breakout.controller.CollisionChecker;
import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.ball.BallHitHorizontal;
import com.g19.breakout.controller.ball.BallHitNothing;
import com.g19.breakout.controller.state.GameState;
import com.g19.breakout.controller.state.PauseGameState;
import com.g19.breakout.controller.state.PlayingGameState;
import com.g19.breakout.controller.state.StateFactory;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Direction;
import com.g19.breakout.elements.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.view.ArenaView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;

public class PlayingGameStateTests {
    ArenaModel arena = Mockito.mock(ArenaModel.class);
    ArenaView view = Mockito.mock(ArenaView.class);
    GameController controller = Mockito.mock(GameController.class);
    StateFactory stateFactory = Mockito.mock(StateFactory.class);
    CollisionChecker collisionChecker = Mockito.mock(CollisionChecker.class);
    PlayingGameState playingGameState;

    @Before
    public void setup(){
        playingGameState = new PlayingGameState(arena, view, controller, collisionChecker, stateFactory);
    }

     @Test
    public void updateBallDirectionTest(){
         BallModel ball = new BallModel(new Position(10, 10), 10);
         Mockito.when(arena.getBall()).thenReturn(ball);

         BallHitHorizontal ballHitHorizontal = new BallHitHorizontal(ball);

         Mockito.when(collisionChecker.checkBallCollisions(any(Position.class), any(Dimensions.class))).thenReturn(ballHitHorizontal);

         assertTrue(playingGameState.updateBallDirection(ball, new Position(11, 10)));
    }

    @Test
    public void updateTest(){
        BallModel ball = new BallModel(new Position(10, 10), 10);
        Mockito.when(arena.getBall()).thenReturn(ball);

        List<TileModel> tiles = new ArrayList<>();
        /*Mockito.when(arena.getTiles()).thenReturn(tiles);
        Mockito.when(collisionChecker.checkBallCollisions(any(Position.class), any(Dimensions.class))).thenReturn(Mockito.mock(BallHitNothing.class));
        Mockito.when(playingGameState.updateBallDirection(any(BallModel.class), any(Position.class))).thenReturn(true);

        playingGameState.update(30);*/
    }


    @Test
    public void commandsTest(){
        PlayerModel playerModel = new PlayerModel(new Position(30, 10));
        Mockito.when(arena.getPlayer()).thenReturn(playerModel);

        Mockito.when(collisionChecker.isInsideArena(any(Position.class), any(Dimensions.class))).thenReturn(true);

        assertTrue(playingGameState.commandLeft());
        assertEquals(new Position(29, 10), arena.getPlayer().getPosition());


        assertTrue(playingGameState.commandRight());
        assertEquals(new Position(30, 10), arena.getPlayer().getPosition());

        Mockito.doNothing().when(controller).setState(any(GameState.class));
        PauseGameState pauseGameState = Mockito.mock(PauseGameState.class);
        Mockito.when(stateFactory.createPauseGameState(any(GameController.class))).thenReturn(pauseGameState);

        PlayingGameState playingGameStateSpy = Mockito.spy(playingGameState);

        assertTrue(playingGameStateSpy.commandP());
        Mockito.verify(playingGameStateSpy, Mockito.times(1)).commandP();
    }
}
