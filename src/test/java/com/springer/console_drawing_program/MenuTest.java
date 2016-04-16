package com.springer.console_drawing_program;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MenuTest {

    private Drawer drawer;
    private Menu menu;

    @Before
    public void setup()
    {
        drawer = mock(Drawer.class);
        menu = new Menu(drawer);
    }

    @Test
    public void canvasDrawingOptionInvoked() {
        // Canvas drawing first time around the loop and then quitting the program the second time round
        String userInput = "C 5 2" + "\nQ";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        menu.displayMenu();

        verify(drawer, times(1)).drawCanvas(anyString(), anyString());
    }
}
