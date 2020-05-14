package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.Command;
import com.g19.breakout.controller.commands.CommandNone;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.MenuButtonView;
import com.g19.breakout.view.MenuView;
import com.g19.breakout.view.View;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final List<Command> menuButtons;
    private final Dimensions gameDimensions;
    private final MenuView view;

    public MenuController(Dimensions gameDimensions, MenuView menuView) {
        menuButtons = new ArrayList<>();
        this.gameDimensions = gameDimensions;
        this.view = menuView;
    }

    public void addButton(Command button, MenuButtonView buttonView) {
        menuButtons.add(button);
        view.addView(buttonView);
    }

    public Command getCommand(Position position) {
        int buttonCount = menuButtons.size();
        int buttonWidth = gameDimensions.getDiscreteX() / buttonCount;

        for (int i = 0; i < buttonCount; i++) {
            if (position.getDiscreteX() > i*buttonWidth && position.getDiscreteX() < (i+1)*buttonWidth) {
                return menuButtons.get(i);
            }
        }

        return new CommandNone();
    }

    public View getView() {
        return view;
    }
}
