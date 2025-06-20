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
        int[] randomNormalIndexes = {1, 2};
        int[] randomBossIndexes = {1};

        System.out.println("-+-+-+-+-+-+-");
        System.out.println("+ Classaria +");
        System.out.println("-+-+-+-+-+-+-\n");

        System.out.print("Start The Game? (y/n) ");
        YNGame = input.nextLine();

        if (YNGame.equals("y")) {
            while (YNGame.equals("y")) {
                System.out.println("\nChoose your Class!");
                System.out.println("1. Warrior");
                System.out.println("2. Assasin");
                System.out.println("3. Mage");
                System.out.println("4. Trickster");
                System.out.print("Input 1-4 to see Class Overview! ");
                chosenClass = input.nextInt();

                if (chosenClass != 1 && chosenClass != 2 && chosenClass != 3 && chosenClass != 4) {
                    System.out.println("\n" + "=".repeat(30));
                    System.out.println("= Invalid Input! Start Over! =");
                    System.out.println("=".repeat(30) + "\n");
                    continue;
                }

                player = Character.chooseClass(chosenClass);

                assert player != null;
                System.out.printf("%nYou Choose %s!%n", player.getClassName());
                System.out.println("=".repeat(30));
                System.out.println("Starting Stats:");
                System.out.printf("=> Health = %d%n", player.getHp());
                System.out.printf("=> Attack = %d%n", player.getAtk());
                System.out.printf("=> Defend = %d%n", player.getDef());
                System.out.printf("=> Speed  = %d%n", player.getSpd());
                System.out.println("\nSkills:");
                player.displaySkills();
                System.out.println("=".repeat(30));
                System.out.println("Skill Damage and Player Stats will increase on each round completion!\n");
                System.out.print("Do you want this class? (y/n) ");
                input.nextLine();
                YNClass = input.nextLine();

                if (YNClass.equals("n")) {
                    System.out.println("\n" + "=".repeat(38));
                    System.out.println("= Okay! Select Different Class Next! =");
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

                System.out.printf("Welcome! Your Journey Starts now %s!%n", player.getClassName());
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
                        int randomBossIndex = random.nextInt(randomBossIndexes.length);
                        int enemyIndex = randomNormalIndexes[randomBossIndex];

                        enemy = Enemy.randomizedBossEnemy(enemyIndex, counter);
                    } else {
                        int randomNormalIndex = random.nextInt(randomNormalIndexes.length);
                        int enemyIndex = randomNormalIndexes[randomNormalIndex];

                        enemy = Enemy.randomizedNormalEnemy(enemyIndex, counter);
                    }

                    assert enemy != null;

                    if (counter > 1) {
                        player.levelUp();
                    }

                    counter++;

                    while (enemy.getHp() != 0) {
                        System.out.printf("%nLv.%d %s%n", enemy.getLvl(), enemy.getEnemyName());
                        System.out.printf("HP: %d%n", enemy.getHp());
                        System.out.println("=".repeat(15));
                        System.out.printf("Lv.%d %s%n", player.getLvl(), player.getClassName());
                        System.out.printf("HP: %d%n", player.getHp());
                        System.out.println("\nWhat will you do?");
                        player.displaySkills();
                        System.out.print("Input your move: ");
                        playerMove = input.nextInt();

                        if (player.getSpd() >= enemy.getSpd()) {
                            System.out.println();
                            System.out.println("=".repeat(50));
                            Character.chooseSkill(playerMove, player, enemy);
                            System.out.println("=".repeat(50));
                            Enemy.monsterAttack(player, enemy);
                            System.out.println("=".repeat(50));
                        }

                        if (player.getSpd() < enemy.getSpd()) {
                            System.out.println();
                            System.out.println("=".repeat(50));
                            enemy.basicAttack(player);
                            System.out.println("=".repeat(50));
                            Character.chooseSkill(playerMove, player, enemy);
                            System.out.println("=".repeat(50));
                        }

                        if (player.getHp() == 0) {
                            break;
                        }
                    }

                    if (player.getHp() == 0) {
                        System.out.println("\n" + "=".repeat(13));
                        System.out.println("= You Lose! =");
                        System.out.println("=".repeat(13));
                        YNRound = "n";
                        break;
                    }

                    if ((counter - 1) % 4 == 0) {
                        System.out.println("\n" + "=".repeat(18));
                        System.out.println("= Boss Defeated! =");
                        System.out.println("=".repeat(18));

                        System.out.print("\nDo you want to continue? (y/n) ");
                        input.nextLine();
                        YNRound = input.nextLine();

                        if (!YNRound.equals("y") && !YNRound.equals("n")) {
                            System.out.println("\n" + "=".repeat(45));
                            System.out.println("= Invalid Input! We are Finishing the Game! =");
                            System.out.println("=".repeat(45));
                            YNRound = "n";
                        }
                    }
                }

                System.out.println("\n" + "=".repeat(26));
                System.out.println("= Thank You for Playing! =");
                System.out.println("=".repeat(26));
                YNGame = "n";
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
