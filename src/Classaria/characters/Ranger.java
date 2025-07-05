package Classaria.characters;

import Classaria.monsters.Enemy;

public class Ranger extends Character implements LevelUp, BasicAttack {
    private int pATK;
    private int skillDMG;
    private int initialHP;

    public Ranger() {
        setClassName("Ranger");
        this.pATK = 18;
        this.skillDMG = 25;
        setHp(28);
        setDef(8);
        setSpd(18);
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

    @Override
    void firstSkill(Enemy target) {
        this.basicAttack(target);
    }

    @Override
    public void secondSkill(Enemy target) {
        System.out.println("Player shoots a powerful arrow, Piercing Shot!");

        target.setHp(Math.max(0, target.getHp() - skillDMG));

        System.out.println("Player deals " + skillDMG + " of Damage to the enemy!");
    }

    @Override
    public void thirdSkill() {
        System.out.println("Player sharpens their focus, increasing their next attack's damage!");
        this.pATK += 10;
    }

    public void flushInitialStats() {
        setHp(initialHP);
    }

    @Override
    public int getFirstSkillDMG() {
        return pATK;
    }

    @Override
    public int getSecondSkillDMG() {
        return skillDMG;
    }

    @Override
    public int getThirdSkillDMG() {
        return 10; // Bonus damage
    }

    public void basicAttack(Enemy target) {
        System.out.println("Player shoots an arrow at the enemy!");

        target.setHp(Math.max(0, target.getHp() - pATK));

        System.out.println("Player deals " + pATK + " of Damage to the enemy!");
    }

    @Override
    public void displaySkills() {
        System.out.printf("1. Arrow Shot => -%d DMG%n", getFirstSkillDMG());
        System.out.printf("2. Piercing Shot => -%d DMG%n", getSecondSkillDMG());
        System.out.printf("3. Sharpen Focus => +%d DMG on next attack%n", getThirdSkillDMG());
    }

    @Override
    public void levelUp() {
        flushInitialStats();
        this.pATK += 7;
        this.skillDMG = (int)Math.ceil(this.skillDMG * 1.15); // +15% per level
        setHp(getHp() + 8);
        setDef(getDef() + 3);
        setSpd(getSpd() + 7);
        setLvl(getLvl() + 1);
    }
}
