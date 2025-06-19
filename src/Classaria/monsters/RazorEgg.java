package Classaria.monsters;

import Classaria.characters.Character;

public class RazorEgg extends Enemy implements NextRound, BasicAttack {
    public RazorEgg() {
        setHp(65);
        setAtk(15);
        setSpd(10);

        System.out.println("Wild Razor Egg shows up!");
    }

    public void nextRound() {
        setHp(getHp() + 10);
        setAtk(getAtk() + 10);
        setSpd(getSpd() + 5);
    }

    public void basicAttack(Character target) {
        System.out.println("Razor Egg twirl around and nudge the player!");

        if (target.getHp() > 0) {
            target.setHp(target.getHp() - getAtk());
        }

        if (target.getHp() < getAtk()) {
            target.setHp(0);
        }

        System.out.println("Razor Egg deals " + getAtk() + " of Damage to the Player!");
    }
}
