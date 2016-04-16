package com.springer.console_drawing_program;

public class App
{
    public static void main(String[] args)
    {
        Drawer drawer = new Drawer();
        Menu menu = new Menu(drawer);
        menu.displayMenu();

    }
}
