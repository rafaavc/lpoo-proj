package com.g19.breakout.controller.state;

import com.g19.breakout.elements.Chronometer;
import com.g19.breakout.view.View;

public interface GameState {
    default void update(Chronometer chrono) {}
    default boolean commandL() { return true; }
    default boolean commandR() { return true; }
    default boolean commandP() { return true; }
    default boolean commandQ() { return true; }
    View getView();
}
