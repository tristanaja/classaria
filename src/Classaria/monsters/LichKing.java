package Classaria.monsters;

import Classaria.characters.Character;

public class LichKing extends Enemy {
    private int summonCount;
    private boolean hasSummoned;

    public LichKing() {
        setLvl(1);
        setEnemyName("Lich King");
        setHp(250);
        setAtk(25);
        setSpd(10);
        this.summonCount = 0;
        this.hasSummoned = false;

        System.out.println("The Lich King rises from his icy throne!");
        System.out.println("A chilling aura fills the air!");
    }

    public LichKing(int level) {
        setLvl(level);
        setEnemyName("Lich King");
        setHp(250 + 20 * (level - 1));
        setAtk(25 + 7 * (level - 1));
        setSpd(10 + 4 * (level - 1));
        this.summonCount = 0;
        this.hasSummoned = false;
        System.out.println("The Lich King rises from his icy throne!");
        System.out.println("A chilling aura fills the air!");
    }

    @Override
    public void nextRound() {
        setLvl(getLvl() + 1);
        setHp(getHp() + 25);
        setAtk(getAtk() + 9);
        setSpd(getSpd() + 6);
    }

    @Override
    public void basicAttack(Character target) {
        // Lich King has a chance to summon minions or cast powerful spells
        int action = (int)(Math.random() * 100);

        if (action < 30 && summonCount < 3) { // 30% chance to summon if not already summoned this fight
            // Summoning will be handled in Classaria.java
            System.out.println("The Lich King prepares to summon an Undead Minion!");
            this.hasSummoned = true; // Set flag to indicate a summon attempt
        } else if (action < 70) { // 40% chance for Frostmourne Strike
            frostmourneStrike(target);
            this.hasSummoned = false;
        } else { // 30% chance for Death Coil
            deathCoil(target);
            this.hasSummoned = false;
        }
    }

    public boolean getHasSummoned() {
        return hasSummoned;
    }

    public void setHasSummoned(boolean hasSummoned) {
        this.hasSummoned = hasSummoned;
    }

    private void frostmourneStrike(Character target) {
        System.out.println("The Lich King strikes with Frostmourne!");

        int damageDealt = getAtk() - target.getDef();
        if (damageDealt < 0) damageDealt = 0;

        target.setHp(Math.max(0, target.getHp() - damageDealt));

        System.out.println("Lich King deals " + getAtk() + " of Damage to The Player!");
        System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
        System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
    }

    private void deathCoil(Character target) {
        System.out.println("The Lich King casts Death Coil!");

        int damageDealt = (int)(getAtk() * 1.2) - (int)(target.getDef() * 0.5); // Deals more damage, partially ignores defense
        if (damageDealt < 0) damageDealt = 0;

        target.setHp(Math.max(0, target.getHp() - damageDealt));

        System.out.println("Lich King deals " + (int)(getAtk() * 1.2) + " of Magic Damage to The Player!");
        System.out.println("The attack partially ignores defense!");
        System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
    }

    public UndeadMinion summonUndead() {
        System.out.println("The Lich King summons an Undead Minion!");
        summonCount++;
        return new UndeadMinion(getLvl());
    }

    

    protected int getMaxHp() {
        return 250 + 20 * (getLvl() - 1);
    }
}
