package com.springer.console_drawing_program;

import java.util.Scanner;

public class Menu {

    private Drawer drawer;

    public Menu(Drawer drawer) {
        this.drawer = drawer;
    }

    public void displayMenu()
    {
        boolean isQuitting = false;
        Scanner inputScanner = new Scanner(System.in);

        String x1;
        String y1;
        String x2;
        String y2;

        while(!isQuitting){

            System.out.println("Enter command: ");
            String commandEntered = inputScanner.nextLine();
            String[] commandAndOptionsEntered = commandEntered.split(" ");
            char command = 'X';

            try
            {
                command = commandAndOptionsEntered[0].charAt(0);
            }
            catch (StringIndexOutOfBoundsException e)
            {
                // Swallowing exception on an empty use input
            }

            switch(command)
            {
                case 'C':
                    if(commandAndOptionsEntered.length == 3)
                    {
                        String width = commandAndOptionsEntered[1];
                        String height = commandAndOptionsEntered[2];
                        drawer.drawCanvas(width, height);
                        drawer.printDrawing();
                    }
                    else if(commandAndOptionsEntered.length < 3)
                    {
                        System.out.println("You need to enter height and width to draw a canvas!");
                    }
                    else if(commandAndOptionsEntered.length > 3)
                    {
                        System.out.println("Too many parameters entered for command 'C'! Correct usage: C height width");
                    }

                    break;
                case 'L':
                    if(commandAndOptionsEntered.length == 5)
                    {
                        x1 = commandAndOptionsEntered[1];
                        y1 = commandAndOptionsEntered[2];
                        x2 = commandAndOptionsEntered[3];
                        y2 = commandAndOptionsEntered[4];

                        drawer.drawLine(x1, y1, x2, y2);
                        drawer.printDrawing();
                    }
                    else if(commandAndOptionsEntered.length < 5)
                    {
                        System.out.println("You need to enter coordinates x1 y1 x2 y2 to draw a line!");
                    }
                    else if(commandAndOptionsEntered.length > 5)
                    {
                        System.out.println("Too many parameters entered for command 'L'! Correct usage: L x1 y1 x2 y2");
                    }
                    break;
                case 'R':
                    if(commandAndOptionsEntered.length == 5) {
                        x1 = commandAndOptionsEntered[1];
                        y1 = commandAndOptionsEntered[2];
                        x2 = commandAndOptionsEntered[3];
                        y2 = commandAndOptionsEntered[4];

                        drawer.drawRectangle(x1, y1, x2, y2);
                        drawer.printDrawing();
                    }
                    else if(commandAndOptionsEntered.length < 5)
                    {
                        System.out.println("You need to enter coordinates x1 y1 x2 y2 to draw a rectangle!");
                    }
                    else if(commandAndOptionsEntered.length > 5)
                    {
                        System.out.println("Too many parameters entered for command 'R'! Correct usage: R x1 y1 x2 y2");
                    }
                    break;
                case 'B':
                    x1 = commandAndOptionsEntered[1];
                    y1 = commandAndOptionsEntered[2];
                    String colour = commandAndOptionsEntered[3];

                    drawer.fillArea(x1, y1, colour);
                    drawer.printDrawing();
                    break;
                case 'Q':
                    isQuitting = true;
                    System.out.println("Quitting drawing program...");
                    break;
                case 'X':
                    // Empty command to handle user hitting "Enter" before anything is entered
                    break;
                default:
                    System.out.printf("Command %c does not exist. Please enter a valid command.", command);
                    System.out.println();
            }
            System.out.println();
        }
    }
}
