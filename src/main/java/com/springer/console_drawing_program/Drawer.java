package com.springer.console_drawing_program;

import java.util.ArrayList;
import java.util.List;

public class Drawer {

    private List<String> drawing;
    private int frameHeight;
    private int frameWidth;

    public List<String> getDrawing() {
        return drawing;
    }

    public void drawCanvas(String width, String height)
    {
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
        if(!(drawing == null))
        {
            try
            {
                int x1Int = Integer.parseInt(x1);
                int x2Int = Integer.parseInt(x2);
                int y1Int = Integer.parseInt(y1);
                int y2Int = Integer.parseInt(y2);

                if((x2Int < (frameWidth - 1)) && (y2Int < (frameHeight - 1)))
                {
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
                        System.out.printf("Only straight lines can be drawn. Coordinates %d %d %d %d would not yield a straight line.",
                                            x1Int, y1Int, x2Int, y2Int);
                        System.out.println();
                    }
                }
                else
                {
                    System.out.printf("Lines can not exit the canvas! Please enter coordinates within the current canvas. Current canvas: C %d %d",
                                        frameWidth - 2, frameHeight - 2);
                    System.out.println();
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Function arguments should only be natural numbers, e.g.: C 5 2");
            }
        }
    }


    public void drawRectangle(String x1, String y1, String x2, String y2)
    {
        if(!(drawing == null))
        {
            if(x1.equals(x2) || y1.equals(y2))
            {
                System.out.println("The coordinates you have entered represent a line rather than a rectangle!");
                System.out.println("Please enter the coordinates of the top left corner and the bottom right corner.");
            }
            else
            {
                drawLine(x1, y1, x2, y1);
                drawLine(x1, y2, x2, y2);
                drawLine(x1, y1, x1, y2);
                drawLine(x2, y1, x2, y2);
            }
        }
    }

    // Could not implement within reasonable time frame
    public void fillArea(String x, String y, String colour)
    {
        if(!(drawing == null))
        {
            try
            {
                int xInt = Integer.parseInt(x);
                int yInt = Integer.parseInt(y);
                int lineAt = 0;

                for(int n = 0; n < frameHeight; n++)
                {
                    for (int i = 0; i < frameWidth; i++)
                    {
                        if (drawing.get(i) == "x")
                        {
                            lineAt = i;

                            for (int j = 0; j < lineAt; j++)
                            {
                                drawing.remove(j + 1);
                                drawing.add(j + 1, colour);
                            }
                        }
                    }
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Function arguments should only be natural numbers, e.g.: C 5 2");
            }
        }
    }

    public void printDrawing()
    {
        if(drawing == null)
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
