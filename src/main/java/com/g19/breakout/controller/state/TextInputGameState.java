package com.g19.breakout.controller.state;

import com.g19.breakout.controller.GameController;
import com.g19.breakout.controller.MenuController;
import com.g19.breakout.controller.TextReader;
import com.g19.breakout.model.PlayerModel;

abstract class TextInputGameState extends MenuGameState {
    protected TextReader textReader;

    public TextInputGameState(GameController controller, PlayerModel playerModel, MenuController menu, TextReader textReader) {
        super(controller, playerModel, menu);
        this.textReader = textReader;
    }

    @Override
    public TextReader getTextReader() {
        return textReader;
    }

    @Override
    public boolean isReadingText() {
        return textReader.isReadingText();
    }
}
