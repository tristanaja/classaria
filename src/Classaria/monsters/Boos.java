package Classaria.monsters;

import Classaria.characters.Character;

public class Boos extends Enemy implements NextRound, BasicAttack {
    public Boos() {
        setLvl(1);
        setEnemyName("Boos");
        setHp(150);
        setAtk(25);
        setSpd(15);

        System.out.println("Space Tremble, Time Diluted, Reality Shifts...");
        System.out.println("Boos descends and crack the ground!!");
    }

    public Boos(int level) {
        setLvl(level);
        setEnemyName("Boos");
        setHp(150 + 12 * (level - 1));
        setAtk(25 + 7 * (level - 1));
        setSpd(15 + 4 * (level - 1));

        System.out.println("Space Tremble, Time Diluted, Reality Shifts...");
        System.out.println("Boos descends and crack the ground!!");
    }

    @Override
    public void nextRound() {
        setLvl(getLvl() + 1);
        setHp(getHp() + 12);
        setAtk(getAtk() + 7);
        setSpd(getSpd() + 4);
    }

    @Override
    public void basicAttack(Character target) {
        System.out.println("Boos blast a magic railgun!");

        int damageDealt = getAtk() - target.getDef();

        if (damageDealt < 0) {
            damageDealt = 0;
        }

        target.setHp(Math.max(0, target.getHp() - damageDealt));

        System.out.println("Boos deals " + getAtk() + " of Damage to The Player!");
        System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
        System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
    }
}
