package Classaria.monsters;

import Classaria.characters.Character;

public class Slime extends Enemy {
    public Slime() {
        setLvl(1);
        setEnemyName("Slime");
        setHp(80);
        setAtk(8);
        setSpd(5);

        System.out.println("A bouncy Slime appears!");
    }

    public Slime(int level) {
        setLvl(level);
        setEnemyName("Slime");
        setHp(80 + 10 * (level - 1));
        setAtk(8 + 3 * (level - 1));
        setSpd(5 + (level - 1));

        System.out.println("A bouncy Slime appears!");
    }

    @Override
    public void nextRound() {
        setLvl(getLvl() + 1);
        setHp(getHp() + 12);
        setAtk(getAtk() + 4);
        setSpd(getSpd() + 2);
    }

    @Override
    public void basicAttack(Character target) {
        System.out.println("The Slime slams its gooey body into the player!");

        int damageDealt = getAtk() - target.getDef();

        if (damageDealt < 0) {
            damageDealt = 0;
        }

        target.setHp(Math.max(0, target.getHp() - damageDealt));

        System.out.println("Slime deals " + getAtk() + " of Damage to The Player!");
        System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
        System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
    }
}
