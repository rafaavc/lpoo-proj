package com.g19.breakout.controller.state;

import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.view.SuperView;

public interface GameState {
    void update(Chronometer chrono);
    void commandL();
    void commandR();
    void commandP();
    SuperView getView();
}
