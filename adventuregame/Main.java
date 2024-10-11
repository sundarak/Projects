package com.adventuregame;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // EXPOSITION
        printTitle();
        System.out.println("Welcome to 'A Chapel Hill Adventure!'");
        System.out.println("In this virtual map, there are 10 items hidden across 12 treasure chests.\n" +
                "Your goal is to explore the area and collect them all!\n");
        System.out.println("Game commands are not case sensitive. See below:");
        printCommands();

        // GAME SET UP
        System.out.println("\nWhat is your name?");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        Game game = new GameImpl(new MapUNC(), new PlayerImpl(name, 5, 5));

        // GAME START
        System.out.println("Let's explore, " + game.getPlayerName() + "!");
        System.out.println("Your starting coordinates are (" + game.getPlayerPosition().getX() + ", " +
                game.getPlayerPosition().getY() + ").\n");

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        game.printCellInfo();

        // MAIN PROGRAM LOOP
        boolean isPlaying = true;
        boolean isWon = false;
        while (isPlaying) {
            System.out.println("\nWhat do you want to do? Type \"help\" for options.");
            String str = scan.next();
            switch (str.toLowerCase()) {
                case "leave":
                case "quit":
                case "exit":
                    System.out.println("Thanks for playing, " + game.getPlayerName() + "!");
                    isPlaying = false;
                    break;
                case "open":
                    game.openChest();
                    isWon = game.getIsWinner();
                    break;
                case "north":
                case "go north":
                    game.move(Direction.NORTH);
                    break;
                case "south":
                case "go south":
                    game.move(Direction.SOUTH);
                    break;
                case "east":
                case "go east":
                    game.move(Direction.EAST);
                    break;
                case "west":
                case "go west":
                    game.move(Direction.WEST);
                    break;
                case "look":
                case "look around":
                    game.printCellInfo();
                    break;
                case "status":
                case "inventory":
                    System.out.println("Current coordinates: (" +
                            game.getPlayerPosition().getX() + ", " +
                            game.getPlayerPosition().getY() + ")");
                    List<Item> list = game.getPlayerItems();
                    System.out.println("Inventory: " + list);
                    System.out.println("# Items: " + list.size());
                    break;
                case "help":
                    System.out.println("\nTry typing one of the following commands:");
                    printCommands();
                    break;
                default:
                    System.out.println("Input not recognized. Type 'help' to see all commands.");
                    break;
            }
            if (isWon) {
                System.out.println("Congratulations " + game.getPlayerName() + ", you won the game!");
                isPlaying = false;
            }
        }
        scan.close();
    }

    public static void printCommands() {
        System.out.printf("%-10s %s %n", "'north'", "| move north");
        System.out.printf("%-10s %s %n", "'south'", "| move south");
        System.out.printf("%-10s %s %n", "'east'", "| move east");
        System.out.printf("%-10s %s %n", "'west'", "| move west");
        System.out.printf("%-10s %5s %n", "'status'", "| see player status");
        System.out.printf("%-10s %5s %n", "'open'", "| open chest");
        System.out.printf("%-10s %5s %n", "'look'", "| look around at current location");
        System.out.printf("%-10s %5s %n", "'leave'", "| end game");
    }

    public static void printTitle() {
        System.out.println(" _____ _     _    _ _   _     _ _     _   _ \n" +
                "/\\     ____| |   | |  | |  | (_)   | |\n" +
                "  /  \\  | |  | |  __  __ _  ___ | |   | |__  |_| |\n" +
                " / /\\ \\ |  | '_\\ _\\  _' | '_\\|_ / | | __  __| |\n" +
                " /  ____  \\  |____| |   | (_| |  |_)  | ___ / | \n" +
                " /_ \\_____|_| |_| \\__ |_| \n" +
                " ");
    }
}
