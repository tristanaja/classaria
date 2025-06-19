package Classaria.characters;

import Classaria.monsters.Enemy;

public class Assasin extends Character implements LevelUp, BasicAttack {
    private int pATK;
    private int skillDMG;

    public Assasin() {
        setClassName("Assasin");
        this.pATK = 20;
        this.skillDMG = 15;
        setHp(30);
        setDef(10);
        setSpd(15);
        setLvl(1);
    }

    @Override
    public int getAtk() {
        return pATK;
    }

    @Override
    public void firstSkill(Enemy target) {
        System.out.println("Player desperately move their hands to slash the enemy repeatedly with the two blades, Starburst Stream!");

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
        System.out.println("Player sneak behind the enemy and slash, shhh....");

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
        System.out.printf("1. Sneak => -%d DMG%n", pATK);
        System.out.printf("2. Starburst Stream => -%d DMG%n", getFirstSkillDMG());
    }

    public void levelUp() {
        this.pATK += 5;
        this.skillDMG += 15;
        setHp(getHp() + 5);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
    }
}
