package Classaria.monsters;

import Classaria.characters.Character;

public class ShadowPhantom extends Enemy {
    private boolean isInvisible;
    
    public ShadowPhantom() {
        setLvl(1);
        setEnemyName("Shadow Phantom");
        setHp(75);
        setAtk(20);
        setSpd(15);
        this.isInvisible = false;
        
        System.out.println("A mysterious shadow materializes from the darkness!");
    }
    
    public ShadowPhantom(int level) {
        setLvl(level);
        setEnemyName("Shadow Phantom");
        setHp(75 + 10 * (level - 1));
        setAtk(20 + 6 * (level - 1));
        setSpd(15 + 4 * (level - 1));
        this.isInvisible = false;
        
        System.out.println("A mysterious shadow materializes from the darkness!");
    }
    
    @Override
    public void nextRound() {
        setLvl(getLvl() + 1);
        setHp(getHp() + 10);
        setAtk(getAtk() + 6);
        setSpd(getSpd() + 4);
    }
    
    @Override
    public void basicAttack(Character target) {
        if (!isInvisible) {
            System.out.println("Shadow Phantom strikes from the shadows!");
            
            int damageDealt = getAtk() - target.getDef();
            if (damageDealt < 0) damageDealt = 0;
            
            target.setHp(Math.max(0, target.getHp() - damageDealt));
            
            System.out.println("Shadow Phantom deals " + getAtk() + " of Damage to The Player!");
            System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
            System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
            
            // 30% chance to become invisible
            if (Math.random() < 0.3) {
                System.out.println("Shadow Phantom melts into the darkness!");
                isInvisible = true;
            }
        } else {
            System.out.println("Shadow Phantom emerges with a devastating strike!");
            
            // Deal 50% more damage when attacking from invisibility
            int boostedAtk = (int)(getAtk() * 1.5);
            int damageDealt = boostedAtk - target.getDef();
            if (damageDealt < 0) damageDealt = 0;
            
            target.setHp(Math.max(0, target.getHp() - damageDealt));
            
            System.out.println("Shadow Phantom deals " + boostedAtk + " of Damage to The Player!");
            System.out.println(target.getDef() + " Amount of DMG is blocked by The Player!");
            System.out.println("Total Damage taken by Player: " + damageDealt + " DMG");
            
            isInvisible = false;
        }
    }
}
