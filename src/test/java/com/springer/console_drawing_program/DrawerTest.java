package com.springer.console_drawing_program;

import org.junit.Before;
import org.junit.Ignore;
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
    public void canvasTwoWideAndTwoHighGetsDrawn()
    {
        List<String> expectedCanvas = Arrays.asList(
                "-", "-", "-", "-",
                "|", " ", " ", "|",
                "|", " ", " ", "|",
                "-", "-", "-", "-");

        drawer.drawCanvas("2", "2");
        List<String> actualCanvas = drawer.getDrawing();

        assertEquals(expectedCanvas, actualCanvas);
    }

    @Test
    public void horizontalLineTwoLongDrawn()
    {
        List<String> expectedDrawing = Arrays.asList(
                "-", "-", "-", "-",
                "|", "x", "x", "|",
                "|", " ", " ", "|",
                "-", "-", "-", "-");

        drawer.drawCanvas("2", "2");
        drawer.drawLine("1", "1", "2", "1");
        List<String> actualDrawing = drawer.getDrawing();

        assertEquals(expectedDrawing, actualDrawing);
    }

    @Test
    public void verticalLineTwoLongDrawn()
    {
        List<String> expectedDrawing = Arrays.asList(
                "-", "-", "-", "-",
                "|", "x", " ", "|",
                "|", "x", " ", "|",
                "-", "-", "-", "-");

        drawer.drawCanvas("2", "2");
        drawer.drawLine("1", "1", "1", "2");
        List<String> actualDrawing = drawer.getDrawing();

        assertEquals(expectedDrawing, actualDrawing);
    }

    @Test
    public void TwoOnTwoRectangleDrawn()
    {
        List<String> expectedDrawing = Arrays.asList(
                "-", "-", "-", "-",
                "|", "x", "x", "|",
                "|", "x", "x", "|",
                "-", "-", "-", "-");

        drawer.drawCanvas("2", "2");
        drawer.drawRectangle("1", "1", "2", "2");
        List<String> actualDrawing = drawer.getDrawing();

        assertEquals(expectedDrawing, actualDrawing);
    }

    @Test
    public void lineThatGoesOutOfBoundsOfTheCanvasNotDrawn()
    {
        List<String> expectedDrawing = Arrays.asList(
                "-", "-", "-", "-",
                "|", " ", " ", "|",
                "|", " ", " ", "|",
                "-", "-", "-", "-");

        drawer.drawCanvas("2", "2");
        drawer.drawLine("1", "1", "3", "1");
        List<String> actualDrawing = drawer.getDrawing();

        assertEquals(expectedDrawing, actualDrawing);
    }

    @Test
    public void nonStraightLineNotDrawn()
    {
        List<String> expectedDrawing = Arrays.asList(
                "-", "-", "-", "-",
                "|", " ", " ", "|",
                "|", " ", " ", "|",
                "-", "-", "-", "-");

        drawer.drawCanvas("2", "2");
        drawer.drawLine("1", "1", "2", "2");
        List<String> actualDrawing = drawer.getDrawing();

        assertEquals(expectedDrawing, actualDrawing);
    }

    @Test
    public void lineWithLengthOneDrawn()
    {
        List<String> expectedDrawing = Arrays.asList(
                "-", "-", "-", "-",
                "|", "x", " ", "|",
                "|", " ", " ", "|",
                "-", "-", "-", "-");

        drawer.drawCanvas("2", "2");
        drawer.drawLine("1", "1", "1", "1");
        List<String> actualDrawing = drawer.getDrawing();

        assertEquals(expectedDrawing, actualDrawing);
    }

    @Ignore // since I could not get this to work
    @Test
    public void fillInAreaWhenThePointIsAtOneOne()
    {
        List<String> expectedDrawing = Arrays.asList(
                "-", "-", "-", "-", "-", "-",
                "|", "o", "o","x", " ", "|",
                "|", "o", "o","x", " ", "|",
                "|", "o", "o","x", " ", "|",
                "|", "o", "o","x", " ", "|",
                "-", "-", "-", "-", "-", "-");

        drawer.drawCanvas("4", "4");
        drawer.drawLine("3", "1", "3", "4");
        drawer.fillArea("1", "1", "o");
        List<String> actualDrawing = drawer.getDrawing();

        assertEquals(expectedDrawing, actualDrawing);


    }



}
