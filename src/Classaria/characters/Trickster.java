package Classaria.characters;

import Classaria.monsters.Enemy;

public class Trickster extends Character {
    private int secondHP;
    private int secondAtk;
    private int secondSpd;
    private int firstSkillDMG;
    private int secondSkillDMG;
    private int thirdSkillDMG;

    public Trickster() {
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

    public void flushSecondStats() {
        this.secondHP = getHp();
        this.secondAtk = 0;
        this.secondSpd = getSpd();
    }

    public void gotYoHP(Enemy target) {
        if (target.getHp() > 0) {
            target.setHp(target.getHp() - firstSkillDMG);
            this.secondHP += firstSkillDMG;
        }

        if (target.getHp() < firstSkillDMG) {
            int tmpHP = target.getHp();
            target.setHp(0);
            this.secondHP += tmpHP;
        }
    }

    public void gotYoAttack(Enemy target) {
        if (target.getAtk() > 0) {
            target.setAtk(target.getAtk() - secondSkillDMG);
            this.secondAtk += secondSkillDMG;
        }

        if (target.getAtk() < secondSkillDMG) {
            int tmpATK = target.getAtk();
            target.setAtk(0);
            this.secondAtk += tmpATK;
        }
    }

    public void gotYoSpeed(Enemy target) {
        if (target.getSpd() > 0) {
            target.setSpd(target.getSpd() - thirdSkillDMG);
            this.secondSpd += thirdSkillDMG;
        }

        if (target.getSpd() < thirdSkillDMG) {
            int tmpSPD = target.getSpd();
            target.setSpd(0);
            this.secondSpd += tmpSPD;
        }
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

    public int getFirstSkillDMG() {
        return firstSkillDMG;
    }

    public int getSecondSkillDMG() {
        return secondSkillDMG;
    }

    public void getDescription() {
        System.out.println("Trickster");
        System.out.println("Original HP: " + getHp());
        System.out.println("Current HP: " + this.secondHP);
        System.out.println("firstSkillDMG: " + getFirstSkillDMG());
        System.out.println("secondSkillDMG: " + getSecondSkillDMG());
        System.out.println("Def: " + getDef());
        System.out.println("Spd: " + getSpd());
        System.out.println("Lvl: " + getLvl());
    }
}
