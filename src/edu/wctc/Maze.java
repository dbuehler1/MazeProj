package edu.wctc;

import java.util.ArrayList;
import java.util.Currency;

public class Maze implements Looting, Exit, Interact {
    private Room currentRoom;
    private Player player;
    private boolean isFinished = false;
     public Maze(Room room, Player currentPlayer){
         player = currentPlayer;
         currentRoom = room;
     }
     public String exitCurrentRoom(){
             return currentRoom.getExits();
     }
     public String interactWithCurrentRoom(){
         if(currentRoom.interactable == true){
             player.newPlayerScore(10);
             return "You toggled the lights\n+10pts for interaction";
         }
         else return "This room is NOT interactable";
     }
     public String lootCurrentRoom(){
         if(currentRoom.lootable == true){

             if (currentRoom.getName().equals("room1")){
                 player.addToInventory("Car Keys");
                 currentRoom.lootable = false;
                 return "desk contained car keys";
             }
             else if(Math.random() < 0.5){
                 player.addToInventory("Paper");
                 currentRoom.lootable = false;
                 return "You found paper";

             }
             else{
                 player.addToInventory("Pen");
                 currentRoom.lootable = false;
                 return "you found a pen";
             }

             //disables the user from grabbing the item multiple times


         }
         else return "No loot in this room";
     }
     public int getPlayerScore(){
         return player.getPlayerScore();
     }
     public String Inventory(){
         return player.listInventory();
     }
     public boolean isFinished(){
         if(currentRoom.getExit() == true){
             return true;
         }
         else return false;
     }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
