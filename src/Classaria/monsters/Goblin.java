package Classaria.monsters;

import Classaria.characters.Character;

public class Goblin extends Enemy {
    public Goblin() {
        setLvl(1);
        setEnemyName("Goblin");
        setHp(50);
        setAtk(12);
        setSpd(8);

        System.out.println("A wild Goblin appears!");
    }

    public Goblin(int level) {
        setLvl(level);
        setEnemyName("Goblin");
        setHp(50 + 7 * (level - 1));
        setAtk(12 + 4 * (level - 1));
        setSpd(8 + 2 * (level - 1));

        System.out.println("A wild Goblin appears!");
    }

    @Override
    public void nextRound() {
        setLvl(getLvl() + 1);
        setHp(getHp() + 8);
        setAtk(getAtk() + 5);
        setSpd(getSpd() + 3);
    }

    @Override
    public void basicAttack(Character target) {
        System.out.println("The Goblin attacks with its rusty dagger!");

        int damageDealt = getAtk() - target.getDef();

        if (damageDealt < 0) {
            damageDealt = 0;
        }

        target.setHp(Math.max(0, target.getHp() - damageDealt));

        System.out.println("Goblin deals " + getAtk() + " of Damage to The Player!");
        System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
        System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
    }
}
