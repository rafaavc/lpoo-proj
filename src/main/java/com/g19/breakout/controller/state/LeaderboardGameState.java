package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.model.PlayerModel;
import com.g19.breakout.view.LeaderboardView;
import com.g19.breakout.view.View;

public class LeaderboardGameState extends MenuGameState {
    private final LeaderboardView leaderboardView;
    private final StateFactory stateFactory;

    public LeaderboardGameState(GameController controller, LeaderboardView leaderboardView, MenuController menu, PlayerModel playerModel, StateFactory stateFactory) {
        super(controller, playerModel, menu);
        this.leaderboardView = leaderboardView;
        this.stateFactory = stateFactory;
    }

    @Override
    public void commandQ() {
        controller.setState(stateFactory.createMainMenuGameState(controller));
    }

    @Override
    public View getView() {
        return leaderboardView;
    }
}
