package Classaria.mains;

import Classaria.characters.Character;

import java.util.Scanner;

public class Classaria {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String YN;
        int chosenClass;
        Character player;

        System.out.println("-+-+-+-+-+-+-");
        System.out.println("+ Classaria +");
        System.out.println("-+-+-+-+-+-+-\n");

        System.out.print("Start The Game? (y/n) ");
        YN = input.nextLine();

        if (YN.equals("y")) {
            while (YN.equals("y")) {
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
                System.out.println("Skill Damage and Player Stats will increase on each round completion!");
                System.out.print("Do you want this class? (y/n) ");
                YN = input.nextLine();
            }
        } else if (YN.equals("n")) {
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
