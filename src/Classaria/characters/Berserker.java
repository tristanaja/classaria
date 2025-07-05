package Classaria.characters;

import Classaria.monsters.Enemy;

public class Berserker extends Character implements LevelUp, BasicAttack {
    private int pATK;
    private int skillDMG;
    private int initialHP;

    public Berserker() {
        setClassName("Berserker");
        this.pATK = 10;
        this.skillDMG = 15;
        setHp(40);
        setDef(12);
        setSpd(6);
        setLvl(1);
        setInitialHP(getHp());
    }

    public void setInitialHP(int initialHP) {
        this.initialHP = initialHP;
    }

    @Override
    public int getAtk() {
        // Berserker's attack increases as HP decreases
        double hpPercentage = (double) getHp() / initialHP;
        return (int) (pATK * (2 - hpPercentage));
    }

    @Override
    void firstSkill(Enemy target) {
        this.basicAttack(target);
    }

    @Override
    public void secondSkill(Enemy target) {
        System.out.println("Player enters a furious rage, Reckless Swing!");
        int currentAttack = getAtk();
        target.setHp(Math.max(0, target.getHp() - (currentAttack + skillDMG)));
        setHp(Math.max(0, getHp() - 5)); // Recoil damage

        System.out.println("Player deals " + (currentAttack + skillDMG) + " of Damage to the enemy and takes 5 recoil damage!");
    }

    @Override
    public void thirdSkill() {
        System.out.println("Player lets out a warcry, increasing their attack at the cost of defense!");
        this.pATK += 5;
        setDef(Math.max(0, getDef() - 5));
    }

    public void flushInitialStats() {
        setHp(initialHP);
    }

    @Override
    public int getFirstSkillDMG() {
        return getAtk();
    }

    @Override
    public int getSecondSkillDMG() {
        return getAtk() + skillDMG;
    }

    @Override
    public int getThirdSkillDMG() {
        return 5; // Attack increase
    }

    public void basicAttack(Enemy target) {
        System.out.println("Player wildly swings their axe at the enemy!");
        int currentAttack = getAtk();
        target.setHp(Math.max(0, target.getHp() - currentAttack));

        System.out.println("Player deals " + currentAttack + " of Damage to the enemy!");
    }

    @Override
    public void displaySkills() {
        System.out.printf("1. Wild Swing => -%d DMG%n", getFirstSkillDMG());
        System.out.printf("2. Reckless Swing => -%d DMG, -5 HP%n", getSecondSkillDMG());
        System.out.printf("3. Warcry => +%d ATK, -5 DEF%n", getThirdSkillDMG());
    }

    @Override
    public void levelUp() {
        flushInitialStats();
        this.pATK += 4;
        this.skillDMG = (int)Math.ceil(this.skillDMG * 1.1); // +10% per level
        setHp(getHp() + 15);
        setDef(getDef() + 6);
        setSpd(getSpd() + 3);
        setLvl(getLvl() + 1);
    }
}
