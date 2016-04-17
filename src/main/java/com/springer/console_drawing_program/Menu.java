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
        while(isQuitting == false){

//        TODO: There should be some sort of menu/manual on how to use this program and what commands are available
            System.out.println("Enter command: ");
            String commandEntered = inputScanner.nextLine();

//        TODO: is there some nicer way/better practice than splitting things on a space? The code will be a bit brittle now (what if user enters 2 spaces?)
            String[] commandAndOptionsEntered = commandEntered.split(" ");

            char command = commandAndOptionsEntered[0].charAt(0);

//        char command = commandEntered.charAt(0); // should give the same result as the line above?

            // What should the behaviour be if something is already drawn at the coordinates specified?
            switch(command)
            {
                case 'C':
                    if(commandAndOptionsEntered.length == 3)
                    {
                        String width = commandAndOptionsEntered[1];
                        String height = commandAndOptionsEntered[2];
                        drawer.drawCanvas(width, height);
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
                    // drawLine(x1, y1, x2, y2)
                    String x1 = commandAndOptionsEntered[1];
                    String y1 = commandAndOptionsEntered[2];
                    String x2 = commandAndOptionsEntered[3];
                    String y2 = commandAndOptionsEntered[4];

                    drawer.drawLine(x1, y1, x2, y2);
                    break;
                case 'R':
                    // drawRectangle(x1, y1, x2, y2)
                    break;
                case 'B':
                    // fillArea(x, y, colour)
                    break;
                case 'Q':
                    isQuitting = true;
                    System.out.println("Quitting drawing program...");
                    break;
                default:
                    System.out.printf("Command %c does not exist. Please enter a valid command.", command);
                    System.out.println();
            }
            System.out.println();
        }
    }
}
