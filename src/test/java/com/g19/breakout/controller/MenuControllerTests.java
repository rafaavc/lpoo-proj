package com.g19.breakout.controller;

import com.g19.breakout.controller.commands.CommandLeft;
import com.g19.breakout.controller.commands.CommandNone;
import com.g19.breakout.controller.commands.CommandRight;
import com.g19.breakout.elements.Dimensions;
import com.g19.breakout.elements.Position;
import com.g19.breakout.view.MenuButtonView;
import com.g19.breakout.view.MenuView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class MenuControllerTests {
    MenuView menuView = Mockito.mock(MenuView.class);
    MenuController menuController = new MenuController(new Dimensions(100, 50), menuView);

    @Test
    public void menuControllerTest(){
        doNothing().when(menuView).addView(any(MenuButtonView.class));
        MenuButtonView menuButtonView = Mockito.mock(MenuButtonView.class);


        assertEquals(CommandNone.class, menuController.getCommand(new Position(50, 30)).getClass());

        CommandRight commandRight = new CommandRight();
        menuController.addButton(commandRight, menuButtonView);
        assertEquals(commandRight, menuController.getCommand(new Position(50, 30)));

        CommandLeft commandLeft = new CommandLeft();
        menuController.addButton(commandLeft, menuButtonView);
        assertEquals(commandRight, menuController.getCommand(new Position(30, 30)));
        assertEquals(commandLeft, menuController.getCommand(new Position(70, 30)));
    }
}
