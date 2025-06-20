package Classaria.characters;

import Classaria.monsters.Enemy;

public class Trickster extends Character {
    private int initialHP;
    private int initialAtk;
    private int initialSpd;
    private int firstSkillDMG;
    private int secondSkillDMG;
    private int thirdSkillDMG;

    public Trickster() {
        setClassName("Trickster");
        this.firstSkillDMG = 5;
        this.secondSkillDMG = 5;
        this.thirdSkillDMG = 5;
        setHp(25);
        setDef(5);
        setSpd(10);
        setLvl(1);
        setInitials(getHp(), getAtk(), getSpd());
    }

    public void setInitials(int hp, int atk, int spd) {
        this.initialHP = hp;
        this.initialAtk = atk;
        this.initialSpd = spd;
    }

    public void setInitialAtk(int initialAtk) {
        this.initialAtk = initialAtk;
    }

    public void flushInitialStats() {
        setHp(initialHP);
        setInitialAtk(0);
        setSpd(initialSpd);
    }

    @Override
    public void firstSkill(Enemy target) {
        int stolenHP = Math.min(firstSkillDMG, target.getHp());
        target.setHp(Math.max(0, target.getHp() - stolenHP));
        setHp(getHp() + stolenHP);

        System.out.println("Got yo HP dawg!");
        System.out.println("Player steals " + stolenHP + " HP from the enemy!");
    }

    @Override
    public void secondSkill(Enemy target) {
        int stolenAtk = Math.min(secondSkillDMG, target.getAtk());
        target.setAtk(Math.max(0, target.getAtk() - stolenAtk));
        this.initialAtk += stolenAtk;

        System.out.println("Got yo Attack dawg!");
        System.out.println("Player steals " + stolenAtk + " Attack from the enemy!");
    }

    @Override
    public void thirdSkill(Enemy target) {
        int stolenSpd = Math.min(thirdSkillDMG, target.getSpd());
        target.setSpd(Math.max(0, target.getSpd() - stolenSpd));
        setSpd(getSpd() + stolenSpd);

        System.out.println("Got yo Speed dawg!");
        System.out.println("Player steals " + stolenSpd + " Speed from the enemy!");
    }

    @Override
    public int getFirstSkillDMG() {
        return firstSkillDMG;
    }

    @Override
    public int getSecondSkillDMG() {
        return secondSkillDMG;
    }

    @Override
    public int getThirdSkillDMG() {
        return thirdSkillDMG;
    }

    @Override
    public void displaySkills() {
        System.out.printf("1. Got Yo HP! => Steals %d HP from Enemy!%n", getFirstSkillDMG());
        System.out.printf("2. Got Yo Attack! => Steals %d Attack from Enemy!%n", getSecondSkillDMG());
        System.out.printf("3. Got Yo Speed! => Steals %d Speed from Enemy!%n", getThirdSkillDMG());
    }

    @Override
    public void levelUp() {
        flushInitialStats();
        this.firstSkillDMG += 10;
        this.secondSkillDMG += 10;
        this.thirdSkillDMG += 10;
        setHp(getHp() + 5);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
    }
}
