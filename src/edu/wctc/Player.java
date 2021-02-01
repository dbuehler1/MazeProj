package edu.wctc;

import java.util.ArrayList;

public class Player {
    private int playerScore = 0;
    ArrayList Inventory = new ArrayList();
    //adding new element/item to the array
    public void addToInventory(String item){
        Inventory.add(item);

    }
    public String listInventory(){
        String items = "";
        //creating a string list of your inventory items
        for (int i = 0; i < Inventory.size(); i++){
            items = items + Inventory.get(i) + ", ";
        }
        //determine if Inventory is empty to prevent out of bounds error
        if(Inventory.size() == 0){
            return "Inventory is Empty";
        }
        else return (items.substring(0,items.length() - 2)) + ".";
    }
    //returning your score
    public int getPlayerScore(){
        return playerScore;
    }
    //setting a new score for interacting with a room
    public void newPlayerScore(int newScore){
        playerScore = newScore+ playerScore;
    }
}
