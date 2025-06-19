package Classaria.characters;

import Classaria.monsters.Enemy;

public class Warrior extends Character implements LevelUp, BasicAttack {
    private int pATK;
    private int skillDMG;

    public Warrior() {
        setClassName("Warrior");
        this.pATK = 5;
        this.skillDMG = 10;
        setHp(35);
        setDef(15);
        setSpd(5);
        setLvl(1);
    }

    @Override
    public int getAtk() {
        return pATK;
    }

    @Override
    public void firstSkill(Enemy target) {
        System.out.println("Player have slash the blade and yell GETSUGA TENSHO!");

        if (target.getHp() > 0) {
            target.setHp(target.getHp() - skillDMG);
        }

        if (target.getHp() < skillDMG) {
            target.setHp(0);
        }

        System.out.println("Player deals " + skillDMG + " of Damage to the enemy!");
    }

    @Override
    public int getFirstSkillDMG() {
        return skillDMG;
    }

    public void basicAttack(Enemy target) {
        System.out.println("Player rush forward and slash the enemy!");

        if (target.getHp() > 0) {
            target.setHp(target.getHp() - pATK);
        }

        if (target.getHp() < pATK) {
            target.setHp(0);
        }

        System.out.println("Player deals " + pATK + " of Damage to the enemy!");
    }

    @Override
    public void displaySkills() {
        System.out.printf("1. Slash => -%d DMG%n", pATK);
        System.out.printf("2. Getsuga Tensho => -%d DMG%n", getFirstSkillDMG());
    }

    public void levelUp() {
        this.pATK += 5;
        this.skillDMG += 10;
        setHp(getHp() + 5);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
    }
}
