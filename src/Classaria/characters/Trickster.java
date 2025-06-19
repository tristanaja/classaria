package Classaria.characters;

import Classaria.monsters.Enemy;

public class Trickster extends Character implements LevelUp {
    private int secondHP;
    private int secondAtk;
    private int secondSpd;
    private int firstSkillDMG;
    private int secondSkillDMG;
    private int thirdSkillDMG;

    public Trickster() {
        setClassName("Trickster");
        this.firstSkillDMG = 5;
        this.secondSkillDMG = 5;
        this.thirdSkillDMG = 5;
        this.secondHP = 25;
        this.secondAtk = 0;
        this.secondSpd = 10;
        setHp(25);
        setDef(5);
        setSpd(10);
        setLvl(1);
    }

    public int getSecondHP() {
        return secondHP;
    }

    public int getSecondAtk() {
        return secondAtk;
    }

    public int getSecondSpd() {
        return secondSpd;
    }

    public void flushSecondStats() {
        this.secondHP = getHp();
        this.secondAtk = 0;
        this.secondSpd = getSpd();
    }

    @Override
    public void firstSkill(Enemy target) {
        if (target.getHp() > 0) {
            target.setHp(target.getHp() - firstSkillDMG);
            this.secondHP += firstSkillDMG;

            System.out.println("Got yo HP dawg!");
            System.out.println("Player steals " + firstSkillDMG + " HP from the enemy!");
        }

        if (target.getHp() < firstSkillDMG) {
            int tmpHP = target.getHp();
            target.setHp(0);
            this.secondHP += tmpHP;

            System.out.println("Got yo HP dawg!");
            System.out.println("Player steals " + tmpHP + " HP from the enemy!");
        }
    }

    @Override
    public void secondSkill(Enemy target) {
        if (target.getAtk() > 0) {
            target.setAtk(target.getAtk() - secondSkillDMG);
            this.secondAtk += secondSkillDMG;

            System.out.println("Got yo Attack dawg!");
            System.out.println("Player steals " + secondSkillDMG + " Attack from the enemy!");
        }

        if (target.getAtk() < secondSkillDMG) {
            int tmpATK = target.getAtk();
            target.setAtk(0);
            this.secondAtk += tmpATK;

            System.out.println("Got yo Attack dawg!");
            System.out.println("Player steals " + tmpATK + " Attack from the enemy!");
        }
    }

    @Override
    public void thirdSkill(Enemy target) {
        if (target.getSpd() > 0) {
            target.setSpd(target.getSpd() - thirdSkillDMG);
            this.secondSpd += thirdSkillDMG;

            System.out.println("Got yo Speed dawg!");
            System.out.println("Player steals " + thirdSkillDMG + " Speed from the enemy!");

        }

        if (target.getSpd() < thirdSkillDMG) {
            int tmpSPD = target.getSpd();
            target.setSpd(0);
            this.secondSpd += tmpSPD;

            System.out.println("Got yo Speed dawg!");
            System.out.println("Player steals " + tmpSPD + " Speed from the enemy!");
        }
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

    public void levelUp() {
        this.firstSkillDMG += 10;
        this.secondSkillDMG += 10;
        this.thirdSkillDMG += 10;
        setHp(getHp() + 5);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
        flushSecondStats();
    }
}
