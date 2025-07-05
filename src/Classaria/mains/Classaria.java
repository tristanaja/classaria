package Classaria.mains;

import Classaria.characters.Character;
import Classaria.monsters.Enemy;
import java.util.Random;
import java.util.Scanner;

public class Classaria {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 1;
        String YNGame;
        String YNClass;
        String YNRound = "y";
        int chosenClass;
        Character player;
        int playerMove;
        Enemy enemy;
        Random random = new Random();
        int[] randomNormalIndexes = { 1, 2, 3 }; // Added ShadowPhantom
        int[] randomBossIndexes = { 1, 2 }; // Added ChaosDragon
        int highScore = 0;

        System.out.println("-+-+-+-+-+-+-");
        System.out.println("+ Classaria +");
        System.out.println("-+-+-+-+-+-+-\n");

        System.out.print("Start The Game? (y/n) ");
        YNGame = input.nextLine().toLowerCase();

        if (YNGame.equals("y")) {
            while (YNGame.equals("y")) {
                System.out.println("\nChoose your Class!");
                System.out.println(
                    "1. Warrior - Balanced fighter with strong defense"
                );
                System.out.println(
                    "2. Assassin - Swift striker with high damage"
                );
                System.out.println(
                    "3. Mage - Powerful spellcaster with healing"
                );
                System.out.println(
                    "4. Trickster - Unique stat-stealing abilities"
                );
                System.out.println(
                    "5. Paladin - Holy warrior with defense and healing"
                );
                System.out.print("Input 1-5 to see Class Overview! ");

                try {
                    chosenClass = input.nextInt();

                    if (chosenClass < 1 || chosenClass > 5) {
                        System.out.println("\n" + "=".repeat(30));
                        System.out.println("= Invalid Input! Start Over! =");
                        System.out.println("=".repeat(30) + "\n");
                        continue;
                    }

                    player = Character.chooseClass(chosenClass);

                    assert player != null;
                    System.out.printf(
                        "%nYou Choose %s!%n",
                        player.getClassName()
                    );
                    System.out.println("=".repeat(30));
                    System.out.println("Starting Stats:");
                    System.out.printf("=> Health  = %d%n", player.getHp());
                    System.out.printf("=> Attack  = %d%n", player.getAtk());
                    System.out.printf("=> Defense = %d%n", player.getDef());
                    System.out.printf("=> Speed   = %d%n", player.getSpd());
                    System.out.println("\nSkills:");
                    player.displaySkills();
                    System.out.println("=".repeat(30));
                    System.out.println(
                        "Skill Damage and Player Stats will increase each round!"
                    );

                    System.out.print("\nDo you want this class? (y/n) ");
                    input.nextLine();
                    YNClass = input.nextLine().toLowerCase();

                    if (YNClass.equals("n")) {
                        System.out.println("\n" + "=".repeat(38));
                        System.out.println(
                            "= Okay! Select Different Class Next! ="
                        );
                        System.out.println("=".repeat(38));
                        continue;
                    } else if (!YNClass.equals("y")) {
                        System.out.println("\n" + "=".repeat(30));
                        System.out.println("= Invalid Input! Start Over! =");
                        System.out.println("=".repeat(30));
                        continue;
                    }

                    System.out.println("\n-+-+-+-+-+-+-");
                    System.out.println("+ Classaria +");
                    System.out.println("-+-+-+-+-+-+-\n");

                    System.out.printf(
                        "Welcome! Your Journey Starts now %s!%n",
                        player.getClassName()
                    );

                    while (YNRound.equals("y")) {
                        System.out.println("=".repeat(30));
                        System.out.println("= Round " + counter + " =");
                        if (counter > 9) {
                            System.out.println("=".repeat(12));
                        } else {
                            System.out.println("=".repeat(11));
                        }
                        System.out.println("\n...\n");

                        if (counter % 4 == 0) {
                            int randomBossIndex =
                                random.nextInt(randomBossIndexes.length) + 1;
                            enemy = Enemy.randomizedBossEnemy(
                                randomBossIndex,
                                counter
                            );
                        } else {
                            int randomNormalIndex =
                                random.nextInt(randomNormalIndexes.length) + 1;
                            enemy = Enemy.randomizedNormalEnemy(
                                randomNormalIndex,
                                counter
                            );
                        }

                        assert enemy != null;

                        if (counter > 1) {
                            player.levelUp();
                        }

                        while (enemy.getHp() > 0 && player.getHp() > 0) {
                            // Display battle status
                            System.out.println("\n" + "=".repeat(50));
                            System.out.printf(
                                "Lv.%d %s%n",
                                enemy.getLvl(),
                                enemy.getEnemyName()
                            );
                            System.out.printf("HP: %d%n", enemy.getHp());
                            System.out.println("-".repeat(20));
                            System.out.printf(
                                "Lv.%d %s%n",
                                player.getLvl(),
                                player.getClassName()
                            );
                            System.out.printf("HP: %d%n", player.getHp());
                            System.out.println("=".repeat(50));

                            System.out.println("\nWhat will you do?");
                            player.displaySkills();
                            System.out.print("Input your move (1-3): ");

                            try {
                                playerMove = input.nextInt();

                                System.out.println("\n" + "=".repeat(50));

                                // Determine turn order based on speed
                                if (player.getSpd() >= enemy.getSpd()) {
                                    // Player goes first
                                    Character.chooseSkill(
                                        playerMove,
                                        player,
                                        enemy
                                    );
                                    if (enemy.getHp() > 0) {
                                        System.out.println("=".repeat(50));
                                        Enemy.monsterAttack(player, enemy);
                                    }
                                } else {
                                    // Enemy goes first
                                    Enemy.monsterAttack(player, enemy);
                                    if (player.getHp() > 0) {
                                        System.out.println("=".repeat(50));
                                        Character.chooseSkill(
                                            playerMove,
                                            player,
                                            enemy
                                        );
                                    }
                                }

                                System.out.println("=".repeat(50));
                            } catch (Exception e) {
                                System.out.println(
                                    "Invalid input! Turn skipped."
                                );
                                input.nextLine(); // Clear the invalid input
                            }
                        }

                        if (player.getHp() == 0) {
                            System.out.println("\n" + "=".repeat(40));
                            System.out.println(
                                "=   Game Over! You've been defeated!   ="
                            );
                            System.out.printf(
                                "=> Final Score: %d rounds\n",
                                counter - 1
                            );
                            if (counter - 1 > highScore) {
                                highScore = counter - 1;
                                System.out.println("=> New High Score!");
                            }
                            System.out.println("=".repeat(40));
                            YNRound = "n";
                            break;
                        }

                        counter++;

                        if ((counter - 1) % 4 == 0) {
                            System.out.println("\n" + "=".repeat(18));
                            System.out.println("= Boss Defeated! =");
                            System.out.println("=".repeat(18));

                            System.out.print(
                                "\nContinue to next round? (y/n) "
                            );
                            input.nextLine();
                            YNRound = input.nextLine().toLowerCase();

                            if (!YNRound.equals("y") && !YNRound.equals("n")) {
                                System.out.println("\n" + "=".repeat(45));
                                System.out.println(
                                    "= Invalid Input! Game Over! ="
                                );
                                System.out.println("=".repeat(45));
                                YNRound = "n";
                            }
                        }
                    }

                    System.out.println("\n" + "=".repeat(40));
                    System.out.println(
                        "=   Thank You for Playing Classaria!   ="
                    );
                    System.out.printf(
                        "=> Your High Score: %d rounds\n",
                        highScore
                    );
                    System.out.println("=".repeat(40));

                    System.out.print("\nPlay Again? (y/n) ");
                    input.nextLine();
                    YNGame = input.nextLine().toLowerCase();

                    if (YNGame.equals("y")) {
                        counter = 1;
                        YNRound = "y";
                    }
                } catch (Exception e) {
                    System.out.println("\nInvalid input! Please start over.");
                    input.nextLine(); // Clear the invalid input
                }
            }
        } else if (YNGame.equals("n")) {
            System.out.println("\n" + "=".repeat(26));
            System.out.println("= Thank You for Playing! =");
            System.out.println("=".repeat(26));
        } else {
            System.out.println("\n" + "=".repeat(37));
            System.out.println("= Invalid Input! See you next time! =");
            System.out.println("=".repeat(37));
        }
    }
}
