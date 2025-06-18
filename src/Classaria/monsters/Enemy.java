package Classaria.monsters;

public class Enemy {
    private int hp;
    private int atk;
    private int spd;

    public Enemy() {
        setHp(50);
        setAtk(10);
        setSpd(20);
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getSpd() {
        return spd;
    }

    public void getDescription() {
        System.out.println("Enemy");
        System.out.println("HP: " + getHp());
        System.out.println("ATK: " + getAtk());
        System.out.println("SPD: " + getSpd());
    }
}
