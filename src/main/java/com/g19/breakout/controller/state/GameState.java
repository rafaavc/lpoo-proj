package com.g19.breakout.controller.state;

import com.g19.breakout.view.View;

public interface GameState {
    default void update(int elapsedTime) {}
    default boolean commandL() { return true; }
    default boolean commandR() { return true; }
    default boolean commandP() { return true; }
    default boolean commandQ() { return true; }
    default boolean commandENTER() { return true; }
    View getView();
}
