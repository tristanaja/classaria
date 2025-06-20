package Classaria.monsters;

import Classaria.characters.Character;

public class Speedster extends Enemy {
    public Speedster() {
        setLvl(1);
        setEnemyName("Speedster");
        setHp(50);
        setAtk(10);
        setSpd(20);
        System.out.println("Wild Speedster shows up!");
    }

    public Speedster(int level) {
        setLvl(level);
        setEnemyName("Speedster");
        setHp(50 + 10 * (level - 1));
        setAtk(10 + 10 * (level - 1));
        setSpd(20 + 5 * (level - 1));

        System.out.println("Wild Speedster shows up!");
    }

    @Override
    public void nextRound() {
        setLvl(getLvl() + 1);
        setHp(getHp() + 10);
        setAtk(getAtk() + 10);
        setSpd(getSpd() + 5);
    }

    @Override
    public void basicAttack(Character target) {
        System.out.println("Speedster moves at light speed and hit the player!");

        int damageDealt = getAtk() - target.getDef();

        if (damageDealt < 0) {
            damageDealt = 0;
        }

        target.setHp(Math.max(0, target.getHp() - damageDealt));

        System.out.println("Speedster deals " + getAtk() + " of Damage to The Player!");
        System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
        System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
    }
}
