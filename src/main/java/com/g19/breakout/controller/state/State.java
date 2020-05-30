package com.g19.breakout.controller.state;

import com.g19.breakout.controller.TextReader;
import com.g19.breakout.view.View;

public interface State {
    default void update(int elapsedTime) {}

    default TextReader getTextReader() {
        return null;
    }

    default boolean isReadingText() { return false; }

    default void commandLeft() {  }

    default void commandRight() {  }

    default void commandP() {  }

    default void commandQ() {  }

    default void commandL() {  }

    default void commandEnter() {  }

    View getView();
}
