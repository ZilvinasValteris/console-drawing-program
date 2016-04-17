package com.springer.console_drawing_program;

import java.util.ArrayList;
import java.util.List;

public class Drawer {

    private List<String> drawing;
    private int frameHeight;
    private int frameWidth;

    // shall there be a limit on the dimensions of the canvas?
    // what if height of 0 or 1 or 2 is entered?
    public void drawCanvas(String width, String height) {

        try
        {
            frameWidth = Integer.parseInt(width) + 2;
            frameHeight = Integer.parseInt(height) + 2;
            drawing = new ArrayList<String>();

            if(Integer.parseInt(width) < 1 || Integer.parseInt(height) < 1)
            {
                System.out.println("Canvas must have the length and the width of at least 1!");
            }
            else
            {
                for(int i = 0; i < frameWidth; i++)
                {
                    drawing.add("-");
                }

                for(int i = 0; i < frameHeight - 2; i++)
                {
                    drawing.add("|");
                    for(int j = 0; j < frameWidth - 2; j++)
                    {
                        drawing.add(" ");
                    }
                    drawing.add("|");
                }

                for(int i = 0; i < frameWidth; i++)
                {
                    drawing.add("-");
                }
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid input. Function arguments should only be natural numbers, e.g.: C 5 2");
        }

    }

    public void drawLine(String x1, String y1, String x2, String y2)
    {
        int x1Int;
        int x2Int;
        int y1Int;
        int y2Int;

        try
        {
            x1Int = Integer.parseInt(x1);
            x2Int = Integer.parseInt(x2);
            y1Int = Integer.parseInt(y1);
            y2Int = Integer.parseInt(y2);

            if (x1Int == x2Int)
            {
                // Vertical line
                for (int i = y1Int; i <= y2Int; i++)
                {
                    drawing.remove((i * frameWidth) + x1Int);
                    drawing.add((i * frameWidth) + x1Int, "x");
                }
            }
            else if (y1Int == y2Int)
            {
                // Horizontal line

                for (int i = x1Int; i <= x2Int; i++)
                {
                    drawing.remove((y1Int * frameWidth) + i);
                    drawing.add((y1Int * frameWidth) + i, "x");
                }
            }
            else
            {
                System.out.printf("Only straight lines can be drawn. Coordinates %d %d %d %d would not yield a straight line.", x1Int, y1Int, x2Int, y2Int);
                System.out.println();
            }

        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid input. Function arguments should only be natural numbers, e.g.: C 5 2");
        }
    }


    public void drawRectangle(String x1, String y1, String x2, String y2)
    {
        drawLine(x1, y1, x2, y1);
        drawLine(x1, y2, x2, y2);
        drawLine(x1, y1, x1, y2);
        drawLine(x2, y1, x2, y2);

    }

    public void fillArea(String x, String y, String colour)
    {

    }


    public void printDrawing()
    {
        if(drawing.isEmpty())
        {
            System.out.println("No canvas exists. You need to create a canvas first. Use the command: C width length");
        }
        else
        {
            for(int i = 0; i < frameHeight; i++)
            {
                for(int j = 0; j < frameWidth; j++)
                {
                    System.out.print(drawing.get(j + (i * frameWidth)));
                }
                System.out.println();
            }
        }

    }
}
