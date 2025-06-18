package Classaria.characters;

public class Mage extends Character {
    private int mATK;
    private int skillDMG;
    private int healAMT;

    public Mage() {
        this.mATK = 15;
        this.skillDMG = 20;
        this.healAMT = 5;
        setHp(25);
        setDef(5);
        setSpd(10);
        setLvl(1);
    }

    public int disintegration() {
        return skillDMG;
    }

    public void heal() {
        setHp(getHp() + this.healAMT);
    }

    public int basicAttack() {
        return mATK;
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

    public int getmATK() {
        return mATK;
    }

    public int getSkillDMG() {
        return skillDMG;
    }

    public void getDescription() {
        System.out.println("HP: " + getHp());
        System.out.println("P.ATK: " + getmATK());
        System.out.println("skillDMG: " + getSkillDMG());
        System.out.println("Def: " + getDef());
        System.out.println("Spd: " + getSpd());
        System.out.println("Lvl: " + getLvl());
    }
}
