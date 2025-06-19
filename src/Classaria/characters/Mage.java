package Classaria.characters;

import Classaria.monsters.Enemy;

public class Mage extends Character implements LevelUp, BasicAttack {
    private int mATK;
    private int skillDMG;
    private int healAMT;

    public Mage() {
        setClassName("Mage");
        this.mATK = 15;
        this.skillDMG = 20;
        this.healAMT = 5;
        setHp(25);
        setDef(5);
        setSpd(10);
        setLvl(1);
    }

    @Override
    public int getAtk() {
        return mATK;
    }

    @Override
    public void firstSkill(Enemy target) {
        System.out.println("Player chants and casted Disintegration!");

        if (target.getHp() > 0) {
            target.setHp(target.getHp() - skillDMG);
        }

        if (target.getHp() < skillDMG) {
            target.setHp(0);
        }

        System.out.println("Player deals " + skillDMG + " of Damage to the enemy!");
    }

    public void heal() {
        setHp(getHp() + this.healAMT);
    }

    @Override
    public int getFirstSkillDMG() {
        return skillDMG;
    }

    @Override
    public int getSecondSkillDMG() {
        return healAMT;
    }

    public void basicAttack(Enemy target) {
        System.out.println("Player casted a Fire Ball to the enemy!");

        if (target.getHp() > 0) {
            target.setHp(target.getHp() - mATK);
        }

        if (target.getHp() < mATK) {
            target.setHp(0);
        }

        System.out.println("Player deals " + mATK + " of Damage to the enemy!");
    }

    @Override
    public void displaySkills() {
        System.out.printf("1. Fire Ball => -%d DMG%n", mATK);
        System.out.printf("2. Disintegration => -%d DMG%n", getFirstSkillDMG());
        System.out.printf("3. Heal => +%d Heal%n", getSecondSkillDMG());
    }

    public void levelUp() {
        this.mATK += 5;
        this.skillDMG += 10;
        this.healAMT += 5;
        setHp(getHp() + 5);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
    }
}
