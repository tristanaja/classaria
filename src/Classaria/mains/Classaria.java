package Classaria.mains;

import Classaria.characters.Character;
import Classaria.monsters.Enemy;
import Classaria.monsters.LichKing;
import java.util.ArrayList;
import java.util.List;
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
        List<Enemy> activeEnemies = new ArrayList<>();
        Random random = new Random();
        int normalMonsterCount = 5; // Speedster, RazorEgg, ShadowPhantom, Goblin, Slime
        int bossMonsterCount = 3; // Boos, ChaosDragon, LichKing
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
                System.out.println(
                    "6. Necromancer - Dark magic user with life-stealing abilities"
                );
                System.out.println(
                    "7. Ranger - Agile archer with precise shots"
                );
                System.out.println(
                    "8. Berserker - Furious warrior with increasing attack as HP decreases"
                );
                System.out.print("Input 1-8 to see Class Overview! ");

                try {
                    chosenClass = input.nextInt();

                    if (chosenClass < 1 || chosenClass > 8) {
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

            activeEnemies.clear(); // Clear enemies from previous round

            if (counter % 4 == 0) {
                int randomBossIndex =
                    random.nextInt(bossMonsterCount) + 1;
                activeEnemies.add(Enemy.randomizedBossEnemy(
                    randomBossIndex,
                    counter
                ));
            } else {
                int randomNormalIndex =
                    random.nextInt(normalMonsterCount) + 1;
                activeEnemies.add(Enemy.randomizedNormalEnemy(
                    randomNormalIndex,
                    counter
                ));
            }

            if (counter > 1) {
                player.levelUp();
            }

            while (player.getHp() > 0 && !activeEnemies.isEmpty()) {
                // Display battle status
                System.out.println("\n" + "=".repeat(50));
                System.out.printf(
                    "Lv.%d %s%n",
                    player.getLvl(),
                    player.getClassName()
                );
                System.out.printf("HP: %d%n", player.getHp());
                System.out.println("=".repeat(50));

                System.out.println("Active Enemies:");
                for (int i = 0; i < activeEnemies.size(); i++) {
                    Enemy currentEnemy = activeEnemies.get(i);
                    System.out.printf(
                        "%d. Lv.%d %s (HP: %d)%n",
                        (i + 1),
                        currentEnemy.getLvl(),
                        currentEnemy.getEnemyName(),
                        currentEnemy.getHp()
                    );
                }
                System.out.println("=".repeat(50));

                System.out.println("\nWhat will you do?");
                player.displaySkills();
                System.out.print("Input your move (1-3): ");

                try {
                    playerMove = input.nextInt();

                    if (playerMove < 1 || playerMove > 3) {
                        System.out.println("Invalid skill choice! Turn skipped.");
                        input.nextLine(); // Clear the invalid input
                        continue;
                    }

                    int targetEnemyIndex;
                    if (activeEnemies.size() > 1) {
                        System.out.print("Choose target enemy (1-" + activeEnemies.size() + "): ");
                        targetEnemyIndex = input.nextInt() - 1;
                        if (targetEnemyIndex < 0 || targetEnemyIndex >= activeEnemies.size()) {
                            System.out.println("Invalid target! Turn skipped.");
                            input.nextLine(); // Clear the invalid input
                            continue;
                        }
                    } else {
                        targetEnemyIndex = 0; // Automatically target the only enemy
                    }

                    Enemy targetedEnemy = activeEnemies.get(targetEnemyIndex);

                    System.out.println("\n" + "=".repeat(50));

                    // Determine turn order based on speed
                    if (player.getSpd() >= targetedEnemy.getSpd()) {
                        // Player goes first
                        Character.chooseSkill(
                            playerMove,
                            player,
                            targetedEnemy
                        );
                        if (targetedEnemy.getHp() <= 0) {
                            System.out.println(targetedEnemy.getEnemyName() + " defeated!");
                            activeEnemies.remove(targetEnemyIndex);
                        }
                        if (!activeEnemies.isEmpty()) {
                            System.out.println("=".repeat(50));
                            // Enemies attack
                            for (Enemy currentAttackingEnemy : activeEnemies) {
                                if (currentAttackingEnemy instanceof LichKing lichKing) {
                                    lichKing.basicAttack(player);
                                    if (lichKing.getHasSummoned()) {
                                        activeEnemies.add(lichKing.summonUndead());
                                        lichKing.setHasSummoned(false); // Reset for next summon opportunity
                                    }
                                } else {
                                    currentAttackingEnemy.basicAttack(player);
                                }
                                if (player.getHp() <= 0) break; // Player defeated
                            }
                        }
                    } else {
                        // Enemy goes first
                        for (Enemy currentAttackingEnemy : activeEnemies) {
                            if (currentAttackingEnemy instanceof LichKing lichKing) {
                                lichKing.basicAttack(player);
                                if (lichKing.getHasSummoned()) {
                                    activeEnemies.add(lichKing.summonUndead());
                                    lichKing.setHasSummoned(false); // Reset for next summon opportunity
                                }
                            } else {
                                currentAttackingEnemy.basicAttack(player);
                            }
                            if (player.getHp() <= 0) break; // Player defeated
                        }
                        if (player.getHp() > 0) {
                            System.out.println("=".repeat(50));
                            Character.chooseSkill(
                                playerMove,
                                player,
                                targetedEnemy
                            );
                            if (targetedEnemy.getHp() <= 0) {
                                System.out.println(targetedEnemy.getEnemyName() + " defeated!");
                                activeEnemies.remove(targetEnemyIndex);
                            }
                        }
                    }

                    System.out.println("=".repeat(50));
                } catch (Exception e) {
                    System.out.println(
                        "Invalid input! Turn skipped." + e.getMessage()
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
                    ">= Final Score: %d rounds\n",
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

            // Check if all enemies are defeated
            if (activeEnemies.isEmpty()) {
                System.out.println("\n" + "=".repeat(20));
                System.out.println("= All Enemies Defeated! =");
                System.out.println("=".repeat(20));
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
