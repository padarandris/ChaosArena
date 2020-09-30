import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        String[] enemies = {"Dark Dwarf", "Lizard Fighter", "White Panther", "Hound Warrior", "Screaming Gelatine", "Animated Gargoyle",
                "Dangerous Stranger", "Rabid Weresquirrel", "Mad Sorcerer", "Owlbear Magician"};
        int maxEnemyHealth = 50;
        int enemyAttackDamage = 8;

        int health = 47;
        int attackDamage = 15;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //percentage

        boolean running = true;

        System.out.println("Welcome to the Chaos Arena!");

        GAME:
        while (running) {
            System.out.println("-------------------------------------------------------");
            System.out.println("As you enter the arena you see your next enemy is commencing. Prepare, champion!");
            int enemyHealth = random.nextInt(maxEnemyHealth);
            String enemy = enemies[random.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " is stepping into the arena! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");
                System.out.println("");

                String input = in.nextLine();
                if (input.equals("1") || input.equals("1.")) {
                    int damageDealt = random.nextInt(attackDamage);
                    int damageTaken = random.nextInt(enemyAttackDamage);
                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t You strike the " + enemy + " for " + damageDealt + " DMG!");
                    System.out.println("\t> You receive " + damageTaken + " DMG in retaliation.");

                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage. You are on the brink of death!");
                        System.out.println("\tYou limp out of the dungeon, too weak to continue fighting. Your fighting days are over.");
                        break GAME;
                    }
                } else if (input.equals("2") || input.equals("2.")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + ". "
                                + "\n\t> You now have " + health + " HP."
                                + "\n\t> You have " + numHealthPotions + " health potions left. \n");
                        int damageTaken = random.nextInt(enemyAttackDamage);
                        health -= damageTaken;
                        System.out.println("\t> You receive " + damageTaken + " DMG from " + enemy + " while drinking potion.");

                        if (health < 1) {
                            System.out.println("\t> You have taken too much damage. You are on the brink of death!");
                            System.out.println("\tYou limp out of the dungeon, too weak to continue fighting. Your fighting days are over.");
                            break GAME;
                        } else {
                            System.out.println("I don't have any potions left! <Defeat enemies to have a chance to get one!>");
                            damageTaken = random.nextInt(enemyAttackDamage);
                            health -= damageTaken;
                            System.out.println("\t> You receive " + damageTaken + " DMG from " + enemy + " while checking your pocket for potions.");
                            if (health < 1) {
                                System.out.println("\t> You have taken too much damage. You are on the brink of death!");
                                System.out.println("\tYou limp out of the dungeon, too weak to continue fighting. Your fighting days are over.");
                                break GAME;
                            }
                        }
                    }
                } else if (input.equals("3") || input.equals("3.")) {
                    System.out.println("\tYou run away from " + enemy + " while the crowd in the arena is booing!");
                    System.out.println("\tMaybe you can prove yourself against the next opponent...");
                    continue GAME;
                } else {
                    System.out.println("\tInvalid command.");
                }

                if (health < 1) {
                    System.out.println("\tYou limp out of the dungeon, too weak to continue fighting. Your fighting days are over.");
                    break GAME;
                }
            }
                System.out.println("-------------------------------------------------------");
                System.out.println(" # " + enemy + " was defeated! # ");
                System.out.println(" # You have " + health + " HP left #");
                if (random.nextInt(100) < healthPotionDropChance) {
                    numHealthPotions++;
                    System.out.println(" # The " + enemy + " has dropped a health potion! #");
                    System.out.println(" # You have " + numHealthPotions + " health potion(s)! #");
                }

                System.out.println("-------------------------------------------------------");

            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");
            System.out.println("");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("1.") && !input.equals("2") && !input.equals("2.")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            if (input.equals("1") || input.equals("1.")) {
                System.out.println("You prepare to fight your next opponent.");
            } else if (input.equals("2") || input.equals("2.")) {
                System.out.println("You exit the ring as the reigning champion of Chaos Arena!");
                break GAME;
            }


        }
        System.out.println("###############");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("###############");
    }
}
