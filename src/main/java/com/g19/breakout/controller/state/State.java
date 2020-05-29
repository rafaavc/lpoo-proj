package com.g19.breakout.controller.state;

import com.g19.breakout.view.View;

public interface State {
    default void update(int elapsedTime) {}

    default StringBuilder getTextReader() {
        return null;
    }

    default boolean isReadingText() { return false; }

    default boolean commandLeft() { return true; }

    default boolean commandRight() { return true; }

    default boolean commandP() { return true; }

    default boolean commandQ() { return true; }

    default boolean commandL() { return true; }

    default boolean commandENTER() { return true; }

    View getView();
}
