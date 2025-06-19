package Classaria.monsters;

import Classaria.characters.Character;

public class Speedster extends Enemy implements NextRound, BasicAttack {
    public Speedster() {
        setHp(50);
        setAtk(10);
        setSpd(20);

        System.out.println("Wild Razor Egg shows up!");
    }

    public void nextRound() {
        setHp(getHp() + 10);
        setAtk(getAtk() + 10);
        setSpd(getSpd() + 5);
    }

    public void basicAttack(Character target) {
        System.out.println("Speedster moves at light speed and hit the player!");

        if (target.getHp() > 0) {
            target.setHp(target.getHp() - getAtk());
        }

        if (target.getHp() < getAtk()) {
            target.setHp(0);
        }

        System.out.println("Speedster deals " + getAtk() + " of Damage to the Player!");
    }
}
