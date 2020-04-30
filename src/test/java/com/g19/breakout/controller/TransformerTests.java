package com.g19.breakout.controller;

import com.g19.breakout.controller.ball.*;
import com.g19.breakout.controller.commands.*;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerBarModel;
import com.g19.breakout.view.ArenaView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TransformerTests {

    @Test
    public void testToBallHit(){
        List<BallModel.HIT> ballModelHits = new ArrayList<>();
        ballModelHits.add(BallModel.HIT.TOP);
        ballModelHits.add(BallModel.HIT.BOTTOM);
        ballModelHits.add(BallModel.HIT.PLAYERBAR);
        ballModelHits.add(BallModel.HIT.SIDE);
        ballModelHits.add(BallModel.HIT.NOTHING);


        Transformer transformer = new Transformer();

        BallModel ball = Mockito.mock(BallModel.class);
        PlayerBarModel playerBar = Mockito.mock(PlayerBarModel.class);

        BallHit ballHit = transformer.toBallHit(ballModelHits, ball, playerBar);
        assertEquals(ballHit.getClass(), BallHitNothing.class);
        ballHit = ballHit.getBallHit();
        assertEquals(ballHit.getClass(), BallHitVertical.class);
        ballHit = ballHit.getBallHit();
        assertEquals(ballHit.getClass(), BallHitPlayerBar.class);
        ballHit = ballHit.getBallHit();
        assertEquals(ballHit.getClass(), BallHitBottom.class);
        ballHit = ballHit.getBallHit();
        assertEquals(ballHit.getClass(), BallHitHorizontal.class);
        ballHit = ballHit.getBallHit();
        assertNull(ballHit);
    }

    @Test
    public void testToCommand(){
        Transformer transformer = new Transformer();

        Command command = transformer.toCommand(ArenaView.Keys.EOF);
        assertEquals(CommandEXIT.class, command.getClass());
        command = transformer.toCommand(ArenaView.Keys.ARROWRIGHT);
        assertEquals(CommandRight.class, command.getClass());
        command = transformer.toCommand(ArenaView.Keys.ARROWLEFT);
        assertEquals(CommandLeft.class, command.getClass());
        command = transformer.toCommand(ArenaView.Keys.NONE);
        assertEquals(CommandNone.class, command.getClass());
    }

}
