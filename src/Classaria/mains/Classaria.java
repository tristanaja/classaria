package Classaria.mains;

import Classaria.characters.Assasin;
import Classaria.characters.Mage;
import Classaria.characters.Trickster;
import Classaria.characters.Warrior;
import Classaria.monsters.Enemy;

public class Classaria {
    public static void main(String[] args) {
        Enemy enemy = new Enemy();
        Trickster trickster = new Trickster();

        trickster.getDescription();
        System.out.println();
        enemy.getDescription();
        System.out.println();

        trickster.gotYoHP(enemy);
        trickster.gotYoAttack(enemy);

        trickster.getDescription();
        System.out.println();
        enemy.getDescription();
        System.out.println();

        trickster.levelUp();

        trickster.getDescription();
        System.out.println();
        enemy.getDescription();
        System.out.println();

        trickster.gotYoHP(enemy);
        trickster.gotYoAttack(enemy);

        trickster.getDescription();
        System.out.println();
        enemy.getDescription();
    }
}
