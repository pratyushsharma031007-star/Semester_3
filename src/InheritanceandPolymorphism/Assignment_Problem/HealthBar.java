package InheritanceandPolymorphism.Assignment_Problem;

import java.util.Scanner;

class Character {
    private int health;
    private final int maxHealth;

    Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        health -= amount;

        if (health < 0) {
            health = 0;
        }
    }

    void heal(int amount) {
        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    int getHealth() {
        return health;
    }
}

public class HealthBar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum health: ");
        int maxHealth = sc.nextInt();

        Character character = new Character(maxHealth);

        System.out.print("Enter damage: ");
        int damage = sc.nextInt();
        character.takeDamage(damage);

        System.out.println("Health after damage: " + character.getHealth());

        System.out.print("Enter healing: ");
        int healing = sc.nextInt();
        character.heal(healing);

        System.out.println("Health after healing: " + character.getHealth());
    }
}
