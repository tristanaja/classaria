package Classaria.monsters;

import Classaria.characters.Character;

public class ChaosDragon extends Enemy {
    private int rageCounter;
    private boolean isEnraged;
    
    public ChaosDragon() {
        setLvl(1);
        setEnemyName("Chaos Dragon");
        setHp(200);
        setAtk(30);
        setSpd(12);
        this.rageCounter = 0;
        this.isEnraged = false;
        
        System.out.println("The ground trembles as an ancient Chaos Dragon descends!");
        System.out.println("The air crackles with magical energy!");
    }
    
    public ChaosDragon(int level) {
        setLvl(level);
        setEnemyName("Chaos Dragon");
        setHp(200 + 15 * (level - 1));
        setAtk(30 + 8 * (level - 1));
        setSpd(12 + 5 * (level - 1));
        this.rageCounter = 0;
        this.isEnraged = false;
        System.out.println("The ground trembles as an ancient Chaos Dragon descends!");
        System.out.println("The air crackles with magical energy!");
    }
    
    @Override
    public void nextRound() {
        setLvl(getLvl() + 1);
        setHp(getHp() + 15);
        setAtk(getAtk() + 8);
        setSpd(getSpd() + 5);
    }
    
    @Override
    public void basicAttack(Character target) {
        rageCounter++;
        
        if (rageCounter >= 3 && !isEnraged) {
            System.out.println("The Chaos Dragon's eyes glow with intense fury!");
            System.out.println("Its power increases dramatically!");
            isEnraged = true;
            setAtk(getAtk() * 2);  // Double attack when enraged
        }
        
        // Choose random attack pattern
        int attackPattern = (int)(Math.random() * 3);
        
        switch (attackPattern) {
            case 0 -> breathAttack(target);
            case 1 -> clawStrike(target);
            case 2 -> tailWhip(target);
        }
        
        // Heal when HP is low (below 30%)
        if (getHp() < getMaxHp() * 0.3 && Math.random() < 0.3) {
            int healAmount = getMaxHp() / 10;
            setHp(Math.min(getMaxHp(), getHp() + healAmount));
            System.out.println("The Chaos Dragon regenerates " + healAmount + " HP!");
        }
    }
    
    private void breathAttack(Character target) {
        System.out.println("Chaos Dragon unleashes a devastating breath attack!");
        
        int damageDealt = (int)(getAtk() * 1.5) - target.getDef();
        if (damageDealt < 0) damageDealt = 0;
        
        target.setHp(Math.max(0, target.getHp() - damageDealt));
        
        System.out.println("Chaos Dragon deals " + (int)(getAtk() * 1.5) + " of Damage to The Player!");
        System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
        System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
    }
    
    private void clawStrike(Character target) {
        System.out.println("Chaos Dragon performs a swift claw strike!");
        
        // Two-hit attack
        for (int i = 0; i < 2; i++) {
            int damageDealt = (int)(getAtk() * 0.6) - target.getDef();
            if (damageDealt < 0) damageDealt = 0;
            
            target.setHp(Math.max(0, target.getHp() - damageDealt));
            
            System.out.println("Hit " + (i+1) + ": Chaos Dragon deals " + (int)(getAtk() * 0.6) + " of Damage!");
            System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
            System.out.println("Damage taken: " + damageDealt + " DMG");
        }
    }
    
    private void tailWhip(Character target) {
        System.out.println("Chaos Dragon swings its massive tail!");
        
        int damageDealt = getAtk() - (int)(target.getDef() * 0.5); // Partially ignores defense
        if (damageDealt < 0) damageDealt = 0;
        
        target.setHp(Math.max(0, target.getHp() - damageDealt));
        
        System.out.println("Chaos Dragon deals " + getAtk() + " of Damage to The Player!");
        System.out.println("The attack partially ignores defense!");
        System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
    }
    
    protected int getMaxHp() {
        return 200 + 15 * (getLvl() - 1);
    }
}
