package com.springer.console_drawing_program;

import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        boolean isQuitting = false;


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
                    // drawCanvas(width, height)
                    break;
                case 'L':
                    // drawLine(x1, y1, x2, y2)
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
        }


    }
}
