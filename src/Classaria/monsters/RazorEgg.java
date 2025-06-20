package Classaria.monsters;

import Classaria.characters.Character;

public class RazorEgg extends Enemy {
    public RazorEgg() {
        setLvl(1);
        setEnemyName("Razor Egg");
        setHp(65);
        setAtk(15);
        setSpd(10);

        System.out.println("Wild Razor Egg shows up!");
    }

    public RazorEgg(int level) {
        setLvl(level);
        setEnemyName("Razor Egg");
        setHp(65 + 10 * (level - 1));
        setAtk(15 + 10 * (level - 1));
        setSpd(10 + 5 * (level - 1));

        System.out.println("Wild Razor Egg shows up!");
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
        System.out.println("Razor Egg twirl around and nudge the player!");

        int damageDealt = getAtk() - target.getDef();

        if (damageDealt < 0) {
            damageDealt = 0;
        }

        target.setHp(Math.max(0, target.getHp() - damageDealt));

        System.out.println("Razor Egg deals " + getAtk() + " of Damage to The Player!");
        System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
        System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
    }
}
