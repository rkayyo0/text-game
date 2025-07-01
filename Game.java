import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private Map map;

    public void start() {
        player = new Player("Hero", 100, 5, 2);
        map = new Map();
        System.out.println("Welcome to the Text Adventure Game!");

        while (true) {
            Room currentRoom = map.getCurrentRoom();
            System.out.println("\nYou are in: " + currentRoom.getName());

            if (currentRoom.hasEnemy()) {
                System.out.println("An enemy appears: " + currentRoom.getEnemy().getName());
                combat(currentRoom.getEnemy());
                currentRoom.defeatEnemy();
            }

            System.out.println("Available directions: " + currentRoom.getConnections());
            System.out.print("Enter direction (north, south, east, west) or 'quit': ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            if (!map.move(input)) {
                System.out.println("Can't go that way.");
            }
        }
    }

    private void combat(Enemy enemy) {
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nYour HP: " + player.getHp() + " | Enemy HP: " + enemy.getHp());
            System.out.print("Enter 'attack': ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("attack")) {
                int damage = player.attack();
                enemy.takeDamage(damage);
                System.out.println("You deal " + damage + " damage to the " + enemy.getName());

                if (enemy.isAlive()) {
                    int enemyDamage = enemy.attack();
                    player.takeDamage(enemyDamage);
                    System.out.println(enemy.getName() + " hits you for " + enemyDamage + " damage!");
                } else {
                    System.out.println("You defeated the " + enemy.getName() + "!");
                }
            }
        }

        if (!player.isAlive()) {
            System.out.println("You have died. Game over.");
            System.exit(0);
        }
    }
}