package com.g19.breakout.controller.state;

import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.view.View;

public interface GameState {
    default void update(Chronometer chrono) {}
    default void commandL() {}
    default void commandR() {}
    default void commandP() {}
    default void commandQ() {}
    View getView();
}
