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
    void firstSkill(Enemy target) {
        this.basicAttack(target);
    }

    @Override
    public void secondSkill(Enemy target) {
        System.out.println("Player desperately move their hands to slash the enemy repeatedly with the two blades, Starburst Stream!");

        target.setHp(Math.max(0, target.getHp() - skillDMG));

        System.out.println("Player deals " + skillDMG + " of Damage to the enemy!");
    }

    @Override
    public int getFirstSkillDMG() {
        return skillDMG;
    }

    public void basicAttack(Enemy target) {
        System.out.println("Player sneak behind the enemy and slash, shhh....");

        target.setHp(Math.max(0, target.getHp() - pATK));

        System.out.println("Player deals " + pATK + " of Damage to the enemy!");
    }

    @Override
    public void displaySkills() {
        System.out.printf("1. Sneak => -%d DMG%n", pATK);
        System.out.printf("2. Starburst Stream => -%d DMG%n", getFirstSkillDMG());
    }

    @Override
    public void levelUp() {
        this.pATK += 5;
        this.skillDMG += 15;
        setHp(getHp() + 5);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
    }
}
