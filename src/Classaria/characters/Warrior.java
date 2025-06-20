package Classaria.characters;

import Classaria.monsters.Enemy;

public class Warrior extends Character implements BasicAttack {
    private int pATK;
    private int skillDMG;
    private int initialHP;

    public Warrior() {
        setClassName("Warrior");
        this.pATK = 5;
        this.skillDMG = 10;
        setHp(35);
        setDef(15);
        setSpd(5);
        setLvl(1);
        setInitialHP(getHp());
    }

    public void setInitialHP(int initialHP) {
        this.initialHP = initialHP;
    }

    @Override
    public int getAtk() {
        return pATK;
    }

    public void basicAttack(Enemy target) {
        System.out.println("Player rush forward and slash the enemy!");

        target.setHp(Math.max(0, target.getHp() - pATK));

        System.out.println("Player deals " + pATK + " of Damage to the enemy!");
    }

    @Override
    public void firstSkill(Enemy target) {
        this.basicAttack(target);
    }

    @Override
    public void secondSkill(Enemy target) {
        System.out.println("Player have slash the blade and yell GETSUGA TENSHO!");

        target.setHp(Math.max(0, target.getHp() - skillDMG));

        System.out.println("Player deals " + skillDMG + " of Damage to the enemy!");
    }

    public void flushInitialStats() {
        setHp(initialHP);
    }

    @Override
    public int getFirstSkillDMG() {
        return skillDMG;
    }

    @Override
    public void displaySkills() {
        System.out.printf("1. Slash => -%d DMG%n", pATK);
        System.out.printf("2. Getsuga Tensho => -%d DMG%n", getFirstSkillDMG());
    }

    @Override
    public void levelUp() {
        flushInitialStats();
        this.pATK += 5;
        this.skillDMG += 10;
        setHp(getHp() + 5);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
    }
}
