package edu.wctc;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player user = new Player();
        //Initialing the rooms for the maze, this maze is linear to ensure that moving between rooms is working
        //Each room is initialized with a name, and a couple booleans for room customization
        Room room1 = new Room("room1", true, true) {
            @Override
            public String getDescription() {
                return "Your Office";
            }
        };
        Room room2 = new Room("room2", true, false) {
            @Override
            public String getDescription() {
                return "foyer";
            }
        };
        Room room3 = new Room("room3", true, true) {
            @Override
            public String getDescription() {
                return "end of the hall with a stairwell";
            }
        };
        Room room4 = new Room("room4", true, false) {
            @Override
            public String getDescription() {
                return "bottom floor hall";
            }
        };
        Room room5 = new Room("room5", true, true) {
            @Override
            public String getDescription() {
                return "employee lockers";
            }
        };
        Room room6 = new Room("room6", true, false, true) {
            @Override
            public String getDescription() {
                return "Entrance";
            }
        };
        Room room7 = new Room("room7", false, true, false) {
            @Override
            public String getDescription() {
                return "Closet";
            }
        };

        //maze room's alignment
        room1.setNorth(room2);
        room2.setSouth(room1);
        room1.setEast(room7);
        room7.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setDown(room4);
        room4.setUp(room3);
        room4.setWest(room5);
        room5.setEast(room4);
        room5.setSouth(room6);
        room6.setNorth(room5);
        Maze myMaze = new Maze(room1, user);
        Scanner reader = new Scanner(System.in);
        String Response;
        char userResponse;


        //Testing user input
        do {
            System.out.println("Current room: " + myMaze.getCurrentRoom().getName());
            System.out.println("room Description: " + myMaze.getCurrentRoom().getDescription());
            //possible exits
            System.out.println("Possible routes: " + myMaze.exitCurrentRoom());
            //obtaining user's choice
            Response = reader.nextLine().toLowerCase();
            //converting user input string to a char
            userResponse = Response.charAt(0);

            //determining user input
            if (userResponse == 'i') {
                //interaction with room
                System.out.println(myMaze.interactWithCurrentRoom());

            } else if (userResponse == 'l') {
                //loot current room
                System.out.println(myMaze.lootCurrentRoom());
            } else if (userResponse == 'x') {
                if (myMaze.getCurrentRoom().getExit() == true) {
                    //end result if you find the exit
                    System.out.println("You have left work for the day! Go enjoy your evening!");
                } else System.out.println("This is not an exit, nice try.");

            } else if (userResponse == 'v') {
                //displays inventory
                System.out.println("Inventory:" + myMaze.Inventory());
            } else {
                if (myMaze.getCurrentRoom().isValidDirection(userResponse)) {
                    //moving between rooms and/or switching the current room
                    myMaze.setCurrentRoom(myMaze.getCurrentRoom().getAdjoiningRoom(userResponse));
                } else System.out.println("That is not a valid direction");
            }
            //clear some room in the terminal to enable easier reading
            System.out.println("");

        } while (myMaze.isFinished() == false || userResponse != 'x'); //tests to see if you have exited and finished



        //final output
        System.out.println("Final Score: " + myMaze.getPlayerScore());
        System.out.println("End");

    }
}
