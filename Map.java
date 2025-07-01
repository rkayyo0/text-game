public class Map {
    private Room startRoom;
    private Room currentRoom;

    public Map() {
        Room room1 = new Room("Forest Clearing", new Enemy("Goblin", 30, 5, 1));
        Room room2 = new Room("Abandoned Cabin", new Enemy("Skeleton", 40, 7, 2));
        Room room3 = new Room("Dark Cave", null);

        room1.connect("east", room2);
        room2.connect("west", room1);
        room2.connect("north", room3);
        room3.connect("south", room2);

        startRoom = room1;
        currentRoom = startRoom;
    }

    public boolean move(String direction) {
        Room nextRoom = currentRoom.getConnectedRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}