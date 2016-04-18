package com.springer.console_drawing_program;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class DrawerTest {

    private Drawer drawer;

    @Before
    public void setup()
    {
        drawer = new Drawer();
    }

    @Test
    public void canvasOneWideAndOneHighGetsDrawn()
    {
        List<String> expectedCanvas = Arrays.asList("-", "-", "-", "|", " ", "|", "-", "-", "-");

        List<String> actualCanvas = drawer.drawCanvas("1", "1");

        assertEquals(expectedCanvas, actualCanvas);
    }
}
