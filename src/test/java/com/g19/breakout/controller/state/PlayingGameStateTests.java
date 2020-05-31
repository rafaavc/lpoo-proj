package com.g19.breakout.controller.state;

import com.g19.breakout.controller.BallController;
import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.TilesController;
import com.g19.breakout.model.TileModel;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Direction;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.model.ArenaModel;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.ArenaView;
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
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.times;

public class PlayingGameStateTests {
    @Mock private ArenaModel arena;
    @Mock private ArenaView view;
    @Mock private GameController controller;
    @Mock private StateFactory stateFactory;
    @Mock private BallController ballController;
    @Mock private TilesController tilesController;

    private PlayingGameState playingGameState;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(view.getArena()).thenReturn(arena);
        playingGameState = new PlayingGameState(view, controller, ballController, tilesController, stateFactory);
    }

    @Test
    public void updateTest(){
        BallModel ball = new BallModel(new Position(10, 10), 1);
        Mockito.when(arena.getBall()).thenReturn(ball);

        List<TileModel> tiles = Mockito.mock(ArrayList.class);
        Mockito.when(tiles.isEmpty()).thenReturn(false);

        Mockito.when(arena.getTiles()).thenReturn(tiles);
        Mockito.when(ballController.update(1000)).thenReturn(new Position(10, 9));

        PlayingGameState playingGameStateSpy = Mockito.spy(playingGameState);
        playingGameStateSpy.update(1000);

        Mockito.verify(ballController, times(1)).update(1000);
        Mockito.verify(playingGameStateSpy, times(1)).moveElement(new Position(10, 9), ball);
        Mockito.verify(playingGameStateSpy, times(0)).gameOver(anyBoolean());
        Mockito.verify(tilesController, times(1)).update();

        ball.setDirection(new Direction(0, 0));
        playingGameStateSpy.update(100);
        Mockito.verify(playingGameStateSpy, times(1)).gameOver(true);


        Mockito.when(tiles.isEmpty()).thenReturn(true);
        playingGameStateSpy.update(100);
        Mockito.verify(playingGameStateSpy, times(1)).gameOver(false);

    }


    @Test
    public void commandsTest(){
        PlayerModel playerModel = new PlayerModel(new Position(30, 10));
        Mockito.when(arena.getPlayer()).thenReturn(playerModel);

        Mockito.when(arena.isInsideArena(any(Position.class), any(Dimensions.class))).thenReturn(true);

        playingGameState.commandLeft();
        assertEquals(new Position(29, 10), arena.getPlayer().getPosition());


        playingGameState.commandRight();
        assertEquals(new Position(30, 10), arena.getPlayer().getPosition());

        Mockito.doNothing().when(controller).setState(any(GameState.class));
        PauseGameState pauseGameState = Mockito.mock(PauseGameState.class);
        Mockito.when(stateFactory.createPauseGameState(any(GameController.class))).thenReturn(pauseGameState);

        PlayingGameState playingGameStateSpy = Mockito.spy(playingGameState);

        playingGameStateSpy.commandP();
        Mockito.verify(playingGameStateSpy, times(1)).commandP();
    }
}
