package com.springer.console_drawing_program;

public class Drawer {


    // shall there be a limit on the dimensions of the canvas?
    public void drawCanvas(String width, String height) {

        try
        {
            for(int i = 0; i < Integer.parseInt(width); i++)
            {
                System.out.print("-");
            }

            for(int i = 0; i < Integer.parseInt(height); i++)
            {
                System.out.println();
                System.out.print("|");
                for(int j = 0; j < (Integer.parseInt(width) - 2); j++)
                {
                    System.out.print(" ");
                }
                System.out.print("|");
            }

            System.out.println();

            for(int i = 0; i < Integer.parseInt(width); i++)
            {
                System.out.print("-");
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid input. Function arguments should only be natural numbers, e.g.: C 5 2");
        }


    }
}
