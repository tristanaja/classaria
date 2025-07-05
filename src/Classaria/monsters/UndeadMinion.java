package Classaria.monsters;

import Classaria.characters.Character;

public class UndeadMinion extends Enemy {

    public UndeadMinion(int level) {
        setLvl(level);
        setEnemyName("Undead Minion");
        setHp(50 + 10 * (level - 1));
        setAtk(10 + 3 * (level - 1));
        setSpd(5 + 2 * (level - 1));
        System.out.println("An Undead Minion rises!");
    }

    @Override
    public void nextRound() {
        setLvl(getLvl() + 1);
        setHp(getHp() + 10);
        setAtk(getAtk() + 3);
        setSpd(getSpd() + 2);
    }

    @Override
    public void basicAttack(Character target) {
        System.out.println("The Undead Minion attacks!");
        int damageDealt = getAtk() - target.getDef();
        if (damageDealt < 0) damageDealt = 0;
        target.setHp(Math.max(0, target.getHp() - damageDealt));
        System.out.println("Undead Minion deals " + damageDealt + " damage to " + target.getClassName() + "!");
    }

    protected int getMaxHp() {
        return 50 + 10 * (getLvl() - 1);
    }
}