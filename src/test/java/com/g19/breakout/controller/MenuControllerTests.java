package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.input.CommandLeft;
import com.g19.breakout.controller.commands.input.CommandNone;
import com.g19.breakout.controller.commands.input.CommandRight;
import com.g19.breakout.model.utilities.Dimensions;
import com.g19.breakout.model.utilities.Position;
import com.g19.breakout.view.MenuButtonView;
import com.g19.breakout.view.MenuView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class MenuControllerTests {
    @Test
    public void menuControllerTest(){
        MenuView menuView = Mockito.mock(MenuView.class);
        MenuController menuController = new MenuController(new Dimensions(100, 50), menuView);

        doNothing().when(menuView).addView(any(MenuButtonView.class));
        MenuButtonView menuButtonView = Mockito.mock(MenuButtonView.class);


        assertEquals(CommandNone.class, menuController.getCommand(new Position(50, 30)).getClass());

        GameController gameController = Mockito.mock(GameController.class);
        CommandRight commandRight = new CommandRight(gameController);
        menuController.addButton(commandRight, menuButtonView);
        assertEquals(commandRight, menuController.getCommand(new Position(50, 30)));

        CommandLeft commandLeft = new CommandLeft(gameController);
        menuController.addButton(commandLeft, menuButtonView);
        assertEquals(commandRight, menuController.getCommand(new Position(30, 30)));
        assertEquals(commandLeft, menuController.getCommand(new Position(70, 30)));
    }
}
