import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Room {
    private String name;
    private Map<String, Room> connections = new HashMap<>();
    private Enemy enemy;

    public Room(String name, Enemy enemy) {
        this.name = name;
        this.enemy = enemy;
    }

    public String getName() {
        return name;
    }

    public void connect(String direction, Room room) {
        connections.put(direction, room);
    }

    public Room getConnectedRoom(String direction) {
        return connections.get(direction);
    }

    public Set<String> getConnections() {
        return connections.keySet();
    }

    public boolean hasEnemy() {
        return enemy != null && enemy.isAlive();
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void defeatEnemy() {
        enemy = null;
    }
}