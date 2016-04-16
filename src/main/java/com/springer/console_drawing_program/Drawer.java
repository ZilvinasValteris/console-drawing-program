package com.springer.console_drawing_program;

public class Drawer {


    // shall there be a limit on the dimensions of the canvas?
    // what if height of 0 or 1 or 2 is entered?
    public void drawCanvas(String width, String height) {

        try
        {
            int frameWidth = Integer.parseInt(width) + 2;
            int frameHeight = Integer.parseInt(height) + 2;

            String canvas[][] = new String[frameHeight][frameWidth];

            for(int i = 0; i < frameWidth; i++)
            {
                canvas[0][i] = "-";
            }


            for(int i = 1; i < (frameHeight - 1); i++)
            {
                canvas[i][0] = "|";
                for(int j = 1; j < (frameWidth - 1); j++)
                {
                    canvas[i][j] = " ";
                }
                canvas[i][frameWidth - 1] = "|";
            }

            for(int i = 0; i < frameWidth; i++)
            {
                canvas[frameHeight - 1][i] = "-";
            }


            // Print frame
            // Will probably need to sit in a separate class/method since other methods will have to use this canvas as well
            for(int i = 0; i < frameHeight; i++)
            {
                for(int j = 0; j < frameWidth; j++)
                {
                    System.out.print(canvas[i][j]);
                }
                System.out.println();
            }

        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid input. Function arguments should only be natural numbers, e.g.: C 5 2");
        }


    }
}
