package edu.wctc;

public abstract class Room {
    boolean exit = false;
    boolean lootable;
    boolean interactable;
    private String roomName;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room up;
    private Room down;
    public Room(String Name, boolean interact, boolean loot){
        roomName = Name;
        lootable = loot;
        interactable = interact;
    }
    public Room(String Name, boolean interact, boolean loot, boolean exitpossible){
        exit = exitpossible;
        roomName = Name;
        lootable = loot;
        interactable = interact;
    }
    public abstract String getDescription();

    public Room getAdjoiningRoom(char direction){
        if(isValidDirection('n') == true && direction == 'n'){
            return north;
        }
        else if(isValidDirection('s') == true && direction == 's'){
            return south;
        }
        else if(isValidDirection('e') == true && direction == 'e'){
            return east;
        }
        else if(isValidDirection('w') == true && direction == 'w'){
            return west;
        }
        else if(isValidDirection('u') == true && direction == 'u'){
            return up;
        }
        else if(isValidDirection('d') == true && direction == 'd'){
            return down;
        }
        else return null;
    }

    public String getExits(){
        String exits = "";
        boolean test = false;
        exits = isValidDirection('n') == true ? exits + "n," : exits;
        exits = isValidDirection('s') == true ? exits + "s," : exits;
        exits = isValidDirection('e') == true ? exits + "e," : exits;
        exits = isValidDirection('w') == true ? exits + "w," : exits;
        exits = isValidDirection('u') == true ? exits + "u," : exits;
        exits = isValidDirection('d') == true ? exits + "d," : exits;
        //eliminating the comma at the end and replacing with period for proper formatting
        return exits.substring(0,exits.length() - 1) + ".";
    }
    public String getName(){
        return roomName;
    }
    public boolean isValidDirection(char direction){
        if(direction == 'n'){
            return north == null ? false : true;
        }
        else if(direction == 's'){
            return south == null ? false : true;
        }
        else if(direction == 'e'){
            return east == null ? false : true;
        }
        else if(direction == 'w'){
            return west == null ? false : true;
        }
        else if(direction == 'u'){
            return up == null ? false : true;
        }
        else if(direction == 'd'){
            return down == null ? false : true;
        }
        else return false;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setDown(Room down) {
        this.down = down;
    }

    public boolean getExit() {
        return exit;
    }
    public void setExit(){
        exit = true;
    }
}

