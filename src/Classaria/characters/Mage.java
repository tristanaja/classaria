package Classaria.characters;

import Classaria.monsters.Enemy;

public class Mage extends Character implements LevelUp, BasicAttack {
    private int mATK;
    private int skillDMG;
    private int healAMT;
    private int initialHP;

    public Mage() {
        setClassName("Mage");
        this.mATK = 15;
        this.skillDMG = 20;
        this.healAMT = 5;
        setHp(25);
        setDef(5);
        setSpd(10);
        setLvl(1);
        setInitialHP(getHp());
    }

    public void setInitialHP(int initialHP) {
        this.initialHP = initialHP;
    }

    @Override
    public int getAtk() {
        return mATK;
    }

    @Override
    void firstSkill(Enemy target) {
        this.basicAttack(target);
    }

    @Override
    public void secondSkill(Enemy target) {
        System.out.println("Player chants and casted Disintegration!");

        target.setHp(Math.max(0, target.getHp() - skillDMG));

        System.out.println("Player deals " + skillDMG + " of Damage to the enemy!");
    }

    @Override
    public void thirdSkill() {
        this.heal();
    }

    public void heal() {
        if (getHp() < initialHP) {
            int beforeHeal = getHp();
            int healedHP = Math.min(initialHP, beforeHeal + healAMT);
            setHp(healedHP);

            System.out.println("Player heals for " + (healedHP - beforeHeal) + " HP!");
        } else {
            System.out.println("HP is full! Heal skipped.");
        }
    }

    public void flushInitialStats() {
        setHp(initialHP);
    }

    @Override
    public int getFirstSkillDMG() {
        return mATK;
    }

    @Override
    public int getSecondSkillDMG() {
        return skillDMG;
    }

    @Override
    public int getThirdSkillDMG() {
        return healAMT;
    }

    public void basicAttack(Enemy target) {
        System.out.println("Player casted a Fire Ball to the enemy!");

        target.setHp(Math.max(0, target.getHp() - mATK));

        System.out.println("Player deals " + mATK + " of Damage to the enemy!");
    }

    @Override
    public void displaySkills() {
        System.out.printf("1. Fire Ball => -%d DMG%n", getFirstSkillDMG());
        System.out.printf("2. Disintegration => -%d DMG%n", getSecondSkillDMG());
        System.out.printf("3. Heal => +%d Heal%n", getThirdSkillDMG());
    }

    @Override
    public void levelUp() {
        flushInitialStats();
        this.mATK += 5;
        this.skillDMG += 10;
        this.healAMT += 5;
        setHp(getHp() + 5);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
    }
}
