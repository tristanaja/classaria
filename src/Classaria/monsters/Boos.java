package Classaria.monsters;

import Classaria.characters.Character;

public class Boos extends Enemy implements NextRound, BasicAttack {
    public Boos() {
        setHp(150);
        setAtk(25);
        setSpd(15);

        System.out.println("Space Tremble, Time Diluted, Reality Shifts...");
        System.out.println("Boos descends and crack the ground!!");
    }

    public void nextRound() {
        setHp(getHp() + 10);
        setAtk(getAtk() + 10);
        setSpd(getSpd() + 10);
    }

    public void basicAttack(Character target) {
        System.out.println("Boos blast a magic railgun!");

        if (target.getHp() > 0) {
            target.setHp(target.getHp() - getAtk());
        }

        if (target.getHp() < getAtk()) {
            target.setHp(0);
        }

        System.out.println("Boos deals " + getAtk() + " of Damage to the Player!");
    }
}
