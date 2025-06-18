package Classaria.characters;

public class Assasin extends Character {
    private int pATK;
    private int skillDMG;

    public Assasin() {
        this.pATK = 20;
        this.skillDMG = 15;
        setHp(30);
        setDef(10);
        setSpd(15);
        setLvl(1);
    }

    public int starburstStream() {
        return skillDMG;
    }

    public int basicAttack() {
        return pATK;
    }

    public void levelUp() {
        this.pATK += 5;
        this.skillDMG += 15;
        setHp(getHp() + 5);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
    }

    public int getpATK() {
        return pATK;
    }

    public int getSkillDMG() {
        return skillDMG;
    }

    public void getDescription() {
        System.out.println("HP: " + getHp());
        System.out.println("P.ATK: " + getpATK());
        System.out.println("skillDMG: " + getSkillDMG());
        System.out.println("Def: " + getDef());
        System.out.println("Spd: " + getSpd());
        System.out.println("Lvl: " + getLvl());
    }
}
